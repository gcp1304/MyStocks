package com.jayplabs.mystocks.data.repository;

import com.jayplabs.mystocks.common.data.repository.RepositoryImpl;
import com.jayplabs.mystocks.data.mapper.StockEntityDtoMapper;
import com.jayplabs.mystocks.data.store.StockEntityStore;
import com.jayplabs.mystocks.domain.objects.StockDto;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;


public class StockRepositoryImpl extends
    RepositoryImpl<StockEntityStore, StockEntityDtoMapper> implements StockRepository {

    @Inject
    public StockRepositoryImpl(StockEntityStore dataStore,
        StockEntityDtoMapper stockEntityDtoMapper) {
        super(dataStore, stockEntityDtoMapper);
    }


    @Override
    public Observable<String> createNewStockTrade(final StockDto stockDto) {
        return mDataStore.createTrade(mEntityDtoMapper.map1(stockDto));
    }

    @Override
    public Observable<Boolean> updateStockTrade(final StockDto stockDto) {
        return mDataStore.updateTrade(mEntityDtoMapper.map1(stockDto));
    }

    @Override
    public Observable<List<StockDto>> getAllStockTrades() {
        return mDataStore.getAllTrades().map(stockEntities -> mEntityDtoMapper.map2(stockEntities));
    }

    @Override
    public Observable<StockDto> getStockTrade(final String stockId) {
        return mDataStore.retrieveTrade(stockId).map(stockEntity -> mEntityDtoMapper.map2(stockEntity));
    }

    @Override
    public Observable<Boolean> deleteStockTrade(final String stockId) {
        return mDataStore.deleteTrade(stockId);
    }
}
