package com.jayplabs.mystocks.domain.interactor.stock;

import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class DeleteTrade extends UseCase<String, Boolean, StockRepository> {

    @Inject
    public DeleteTrade(final StockRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<Boolean> buildObservable(final String stockId) {
        return mRepository.deleteTrade(stockId);
    }
}
