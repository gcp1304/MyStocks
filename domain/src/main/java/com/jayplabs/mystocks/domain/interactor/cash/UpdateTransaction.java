package com.jayplabs.mystocks.domain.interactor.cash;

import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.objects.CashDto;
import com.jayplabs.mystocks.domain.repository.CashRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class UpdateTransaction extends UseCase<CashDto, Boolean, CashRepository> {

    @Inject
    public UpdateTransaction(final CashRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<Boolean> buildObservable(final CashDto cashDto) {
        return mRepository.updateTransaction(cashDto);
    }
}
