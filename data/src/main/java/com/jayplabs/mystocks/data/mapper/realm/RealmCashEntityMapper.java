package com.jayplabs.mystocks.data.mapper.realm;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.data.entity.CashEntity;
import com.jayplabs.mystocks.data.entity.realm.RealmCashEntity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RealmCashEntityMapper extends BaseMapper<RealmCashEntity, CashEntity> {

    @Inject
    public RealmCashEntityMapper() {
    }

    @Override
    public RealmCashEntity map1(CashEntity cashEntity) {
        RealmCashEntity realmCashEntity = null;
        if (cashEntity != null) {
            realmCashEntity = new RealmCashEntity(cashEntity.getTransactionId());
            realmCashEntity.setTransactionType(cashEntity.getTransactionType());
            realmCashEntity.setTransactionDate(cashEntity.getTransactionDate());
            realmCashEntity.setAmount(cashEntity.getAmount());
        }
        return realmCashEntity;
    }

    @Override
    public CashEntity map2(RealmCashEntity realmCashEntity) {
        CashEntity cashEntity = null;
        if (realmCashEntity != null) {
            cashEntity = new CashEntity();
            cashEntity.setTransactionId(realmCashEntity.getTransactionId());
            cashEntity.setTransactionType(realmCashEntity.getTransactionType());
            cashEntity.setTransactionDate(realmCashEntity.getTransactionDate());
            cashEntity.setAmount(realmCashEntity.getAmount());
        }
        return cashEntity;
    }
}
