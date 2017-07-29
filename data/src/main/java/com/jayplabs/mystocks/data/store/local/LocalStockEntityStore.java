package com.jayplabs.mystocks.data.store.local;

import com.jayplabs.mystocks.data.entity.StockEntity;
import com.jayplabs.mystocks.data.entity.realm.RealmStockEntity;
import com.jayplabs.mystocks.data.mapper.realm.RealmStockEntityMapper;
import com.jayplabs.mystocks.data.store.StockEntityStore;
import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocalStockEntityStore implements StockEntityStore {

    private Realm mRealm;

    private RealmStockEntityMapper mRealmStockEntityMapper;


    @Inject // TODO: 7/28/17 insert Realm.getDefaultInstance() from DI
    public LocalStockEntityStore(Realm realm,
        RealmStockEntityMapper realmStockEntityMapper) {
        mRealm = realm;
        mRealmStockEntityMapper = realmStockEntityMapper;
    }

    @Override
    public Observable<String> createTrade(final StockEntity stockEntity) {
        RealmStockEntity realmStockEntity = mRealmStockEntityMapper.map1(stockEntity);
        mRealm.executeTransaction(realm -> realm.copyFromRealm(realmStockEntity));
        return Observable.just(realmStockEntity.getStockId());
    }

    @Override
    public Observable<Boolean> updateTrade(final StockEntity stockEntity) {
        // TODO: 7/28/17 Need to implement later
        return null;
    }

    @Override
    public Observable<List<StockEntity>> getAllTrades() {
        List<StockEntity> stockEntities = mRealmStockEntityMapper
            .map2(mRealm.where(RealmStockEntity.class).findAll());
        return Observable.just(stockEntities);
    }

    @Override
    public Observable<StockEntity> retrieveTrade(final String stockId) {
        // TODO: 7/28/17 Check for null condition on query
        RealmStockEntity realmStockEntity = mRealm.where(RealmStockEntity.class)
            .equalTo("mStockId", stockId).findFirst();
        return Observable.just(mRealmStockEntityMapper.map2(realmStockEntity));
    }

    @Override
    public Observable<Boolean> deleteTrade(final String stockId) {
        RealmResults<RealmStockEntity> results = mRealm.where(RealmStockEntity.class)
            .equalTo("mStockId", stockId).findAll();
        mRealm.executeTransaction(realm -> results.deleteAllFromRealm());
        return Observable.just(mRealm.where(RealmStockEntity.class)
            .equalTo("mStockId", stockId).findFirst() == null);
    }
}
