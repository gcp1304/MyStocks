package com.jayplabs.mystocks.domain.interactor;

import com.jayplabs.mystocks.domain.executor.PostExecutionThread;
import com.jayplabs.mystocks.domain.executor.ThreadExecutor;
import com.jayplabs.mystocks.domain.objects.Stock;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Stock}.
 */
public class GetStockList extends UseCase<List<Stock>, Void> {

    private final StockRepository mStockRepository;

    @Inject
    public GetStockList(ThreadExecutor threadExecutor,
        PostExecutionThread postExecutionThread,
        CompositeDisposable disposables,
        StockRepository stockRepository) {
        super(threadExecutor, postExecutionThread, disposables);
        mStockRepository = stockRepository;
    }

    @Override
    Observable<List<Stock>> buildUseCaseObservable(Void aVoid) {
        return mStockRepository.stocks();
    }
}
