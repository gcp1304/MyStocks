package com.jayplabs.mystocks.data.store;

import com.jayplabs.mystocks.common.data.store.EntityStore;
import com.jayplabs.mystocks.data.entity.CashEntity;
import io.reactivex.Observable;
import java.util.List;


public interface CashEntityStore extends EntityStore {

    Observable<String> createTransaction(CashEntity cashEntity);

    Observable<Boolean> updateTransaction(CashEntity cashEntity);

    Observable<List<CashEntity>> getAllTransactions();

    Observable<CashEntity> retrieveTransaction(String transactionId);

    Observable<Boolean> deleteTransaction(String transactionId);
}
