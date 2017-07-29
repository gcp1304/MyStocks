package com.jayplabs.mystocks.data.repository;

import com.jayplabs.mystocks.common.data.repository.RepositoryImpl;
import com.jayplabs.mystocks.data.mapper.CashEntityDtoMapper;
import com.jayplabs.mystocks.data.store.CashEntityStore;
import com.jayplabs.mystocks.domain.objects.CashDto;
import com.jayplabs.mystocks.domain.repository.CashRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

public class CashRepositoryImpl extends
    RepositoryImpl<CashEntityStore, CashEntityDtoMapper> implements CashRepository {

    @Inject
    public CashRepositoryImpl(final CashEntityStore dataStore,
        final CashEntityDtoMapper cashEntityDtoMapper) {
        super(dataStore, cashEntityDtoMapper);
    }

    @Override
    public Observable<String> createTransaction(final CashDto cashDto) {
        return mDataStore.createTransaction(mEntityDtoMapper.map1(cashDto));
    }

    @Override
    public Observable<Boolean> updateTransaction(final CashDto cashDto) {
        return mDataStore.updateTransaction(mEntityDtoMapper.map1(cashDto));
    }

    @Override
    public Observable<List<CashDto>> getAllTransactions() {
        return mDataStore.getAllTransactions().map(cashEntities -> mEntityDtoMapper.map2(cashEntities));
    }

    @Override
    public Observable<CashDto> retrieveTransaction(final String transactionId) {
        return mDataStore.retrieveTransaction(transactionId).map(cashEntity -> mEntityDtoMapper.map2(cashEntity));
    }

    @Override
    public Observable<Boolean> deleteTransaction(final String transactionId) {
        return mDataStore.deleteTransaction(transactionId);
    }
}
