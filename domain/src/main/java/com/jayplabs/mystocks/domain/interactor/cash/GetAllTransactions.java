package com.jayplabs.mystocks.domain.interactor.cash;

import com.jayplabs.mystocks.domain.interactor.UseCaseForAllData;
import com.jayplabs.mystocks.domain.objects.CashDto;
import com.jayplabs.mystocks.domain.repository.CashRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class GetAllTransactions extends UseCaseForAllData<List<CashDto>, CashRepository> {

    @Inject
    public GetAllTransactions(final CashRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<List<CashDto>> buildObservable() {
        return mRepository.getAllTransactions();
    }
}
