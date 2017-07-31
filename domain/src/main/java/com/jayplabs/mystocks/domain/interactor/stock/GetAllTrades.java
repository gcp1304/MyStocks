package com.jayplabs.mystocks.domain.interactor.stock;

import com.jayplabs.mystocks.domain.interactor.UseCaseForAllData;
import com.jayplabs.mystocks.domain.objects.StockDto;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class GetAllTrades extends UseCaseForAllData<List<StockDto>, StockRepository> {

    @Inject
    public GetAllTrades(final StockRepository repository,
        @Named("Thread") final Scheduler threadScheduler,
        @Named("PostExecutionThread") final Scheduler postExecutionScheduler) {
        super(repository, threadScheduler, postExecutionScheduler);
    }

    @Override
    protected Observable<List<StockDto>> buildObservable() {
        return mRepository.getAllTrades();
    }
}
