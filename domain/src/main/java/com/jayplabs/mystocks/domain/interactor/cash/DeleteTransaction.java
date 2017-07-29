package com.jayplabs.mystocks.domain.interactor.cash;

import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.repository.CashRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class DeleteTransaction extends UseCase<String, Boolean, CashRepository> {

    @Inject
    public DeleteTransaction(final CashRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<Boolean> buildObservable(final String transactionId) {
        return mRepository.deleteTransaction(transactionId);
    }
}
