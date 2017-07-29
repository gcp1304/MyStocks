package com.jayplabs.mystocks.data.store;

import com.jayplabs.mystocks.common.data.store.EntityStore;
import com.jayplabs.mystocks.data.entity.StockEntity;
import io.reactivex.Observable;
import java.util.List;

public interface StockEntityStore extends EntityStore {

    Observable<String> createTrade(StockEntity stockEntity);

    Observable<Boolean> updateTrade(StockEntity stockEntity);

    Observable<List<StockEntity>> getAllTrades();

    Observable<StockEntity> retrieveTrade(String stockId);

    Observable<Boolean> deleteTrade(String stockId);
}
