package com.jayplabs.mystocks.domain.interactor.stock;

import com.jayplabs.mystocks.domain.interactor.UseCase;
import com.jayplabs.mystocks.domain.objects.StockDto;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class CreateTrade extends UseCase<StockDto, String, StockRepository> {

    @Inject
    public CreateTrade(final StockRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<String> buildObservable(final StockDto stockDto) {
        return mRepository.createNewStockTrade(stockDto);
    }
}
