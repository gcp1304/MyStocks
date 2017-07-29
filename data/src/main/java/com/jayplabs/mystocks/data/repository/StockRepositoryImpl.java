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
    public Observable<String> createTrade(final StockDto stockDto) {
        return mDataStore.createTrade(mEntityDtoMapper.map1(stockDto));
    }

    @Override
    public Observable<Boolean> updateTrade(final StockDto stockDto) {
        return mDataStore.updateTrade(mEntityDtoMapper.map1(stockDto));
    }

    @Override
    public Observable<List<StockDto>> getAllTrades() {
        return mDataStore.getAllTrades().map(stockEntities -> mEntityDtoMapper.map2(stockEntities));
    }

    @Override
    public Observable<StockDto> retrieveTrade(final String stockId) {
        return mDataStore.retrieveTrade(stockId).map(stockEntity -> mEntityDtoMapper.map2(stockEntity));
    }

    @Override
    public Observable<Boolean> deleteTrade(final String stockId) {
        return mDataStore.deleteTrade(stockId);
    }
}
