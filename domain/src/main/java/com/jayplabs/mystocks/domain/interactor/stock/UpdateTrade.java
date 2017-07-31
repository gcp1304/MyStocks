package com.jayplabs.mystocks.domain.interactor.stock;

import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.objects.StockDto;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;


public class UpdateTrade extends UseCase<StockDto, Boolean, StockRepository> {

    @Inject
    public UpdateTrade(final StockRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<Boolean> buildObservable(final StockDto stockDto) {
        return mRepository.updateTrade(stockDto);
    }
}
