package com.jayplabs.mystocks.domain.interactor.cash;

import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.objects.CashDto;
import com.jayplabs.mystocks.domain.repository.CashRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class RetrieveTransaction extends UseCase<String, CashDto, CashRepository> {

    @Inject
    public RetrieveTransaction(final CashRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<CashDto> buildObservable(final String transactionId) {
        return mRepository.retrieveTransaction(transactionId);
    }
}
