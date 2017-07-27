package com.jayplabs.mystocks.domain.interactor;

import com.fernandocejas.arrow.checks.Preconditions;
import com.jayplabs.mystocks.domain.executor.PostExecutionThread;
import com.jayplabs.mystocks.domain.executor.ThreadExecutor;
import com.jayplabs.mystocks.domain.objects.Stock;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link Stock}.
 */

public class GetStockDetails extends UseCase<Stock, GetStockDetails.Params> {

    private final StockRepository mStockRepository;

    @Inject
    public GetStockDetails(ThreadExecutor threadExecutor,
        PostExecutionThread postExecutionThread,
        CompositeDisposable disposables,
        StockRepository stockRepository) {
        super(threadExecutor, postExecutionThread, disposables);
        mStockRepository = stockRepository;
    }

    @Override
    Observable<Stock> buildUseCaseObservable(Params params) {
        Preconditions.checkNotNull(params);
        return mStockRepository.stock(params.mSymbol);
    }


    public static final class Params {
        private String mSymbol;

        private Params(String symbol) {
            mSymbol = symbol;
        }

        public static Params forStock(String symbol) {
            return new Params(symbol);
        }
    }

}
