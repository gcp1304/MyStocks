package com.jayplabs.mystocks.domain.interactor;

import com.jayplabs.mystocks.domain.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Named;

public abstract class UseCase<REQUEST_DATA, RESPONSE_DATA, REPOSITORY extends Repository> {

    protected final REPOSITORY mRepository;

    private final Scheduler mThreadScheduler;

    private final Scheduler mPostExecutionScheduler;

    private CompositeDisposable mDisposable = new CompositeDisposable();

    public UseCase(final REPOSITORY repository, @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecution") final Scheduler postExecutionScheduler) {
        mRepository = repository;
        mThreadScheduler = threadScheduler;
        mPostExecutionScheduler = postExecutionScheduler;
    }

    protected abstract Observable<RESPONSE_DATA> buildObservable(REQUEST_DATA requestData);

    public void execute(final REQUEST_DATA requestData,
        final DefaultObserver<RESPONSE_DATA> observer) {
        mDisposable.add(buildObservable(requestData).subscribeOn(mThreadScheduler)
            .observeOn(mPostExecutionScheduler).subscribeWith(observer));

        mRepository.register(this);
    }

    public boolean isDisposed() {
        return mDisposable.isDisposed();
    }

    public void dispose() {
        if (!isDisposed()) {
            mDisposable.dispose();
        }
        mRepository.unregister(this);
    }

}