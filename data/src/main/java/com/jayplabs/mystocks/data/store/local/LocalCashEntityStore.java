package com.jayplabs.mystocks.data.store.local;

import com.jayplabs.mystocks.data.entity.CashEntity;
import com.jayplabs.mystocks.data.entity.realm.RealmCashEntity;
import com.jayplabs.mystocks.data.mapper.realm.RealmCashEntityMapper;
import com.jayplabs.mystocks.data.store.CashEntityStore;
import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocalCashEntityStore implements CashEntityStore {

    private Realm mRealm;
    private RealmCashEntityMapper mRealmCashEntityMapper;

    @Inject // TODO: 7/28/17 insert Realm.getDefaultInstance() from DI
    public LocalCashEntityStore(Realm realm,
        RealmCashEntityMapper realmCashEntityMapper) {
        mRealm = realm;
        mRealmCashEntityMapper = realmCashEntityMapper;
    }

    @Override
    public Observable<String> createTransaction(final CashEntity cashEntity) {
        RealmCashEntity realmCashEntity = mRealmCashEntityMapper.map1(cashEntity);
        mRealm.executeTransaction(realm -> realm.copyFromRealm(realmCashEntity));
        return Observable.just(realmCashEntity.getTransactionId());
    }

    @Override
    public Observable<Boolean> updateTransaction(final CashEntity cashEntity) {
        // TODO: 7/28/17 Need to implement later
        return null;
    }

    @Override
    public Observable<List<CashEntity>> getAllTransactions() {
        List<CashEntity> cashEntities = mRealmCashEntityMapper.map2(mRealm.where(RealmCashEntity.class).findAll());
        return Observable.just(cashEntities);
    }

    @Override
    public Observable<CashEntity> retrieveTransaction(final String transactionId) {
        RealmCashEntity realmCashEntity = mRealm.where(RealmCashEntity.class).equalTo("mTransactionId", transactionId).findFirst();
        return Observable.just(mRealmCashEntityMapper.map2(realmCashEntity));
    }

    @Override
    public Observable<Boolean> deleteTransaction(final String transactionId) {
        RealmResults<RealmCashEntity> results = mRealm.where(RealmCashEntity.class).equalTo("mTransactionId", transactionId).findAll();
        mRealm.executeTransaction(realm -> results.deleteAllFromRealm());
        return Observable.just(mRealm.where(RealmCashEntity.class).equalTo("mTransactionId", transactionId).findFirst() == null);
    }
}
