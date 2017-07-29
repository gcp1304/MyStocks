package com.jayplabs.mystocks.domain.interactor;

import com.jayplabs.mystocks.domain.repository.Repository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Named;

public abstract class UseCaseForAllData<RESPONSE_DATA, REPOSITORY extends Repository> extends UseCase<Void, RESPONSE_DATA, REPOSITORY> {

    public UseCaseForAllData(final REPOSITORY repository, @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecution") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<RESPONSE_DATA> buildObservable(final Void aVoid) {
        return buildObservable();
    }

    protected abstract Observable<RESPONSE_DATA> buildObservable();

    public void execute(final DefaultObserver<RESPONSE_DATA> observer) {
        super.execute(null, observer);
    }
}
