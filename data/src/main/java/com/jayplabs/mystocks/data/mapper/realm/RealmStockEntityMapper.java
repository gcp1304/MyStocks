package com.jayplabs.mystocks.data.mapper.realm;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.data.entity.StockEntity;
import com.jayplabs.mystocks.data.entity.realm.RealmStockEntity;
import javax.inject.Inject;

public class RealmStockEntityMapper extends BaseMapper<RealmStockEntity, StockEntity> {

    @Inject
    public RealmStockEntityMapper() {
    }

    @Override
    public RealmStockEntity map1(StockEntity stockEntity) {
        RealmStockEntity realmStockEntity = null;
        if (stockEntity != null) {
            realmStockEntity = new RealmStockEntity();
            realmStockEntity.setStockId(stockEntity.getStockId());
            realmStockEntity.setDate(stockEntity.getDate());
            realmStockEntity.setActivity(stockEntity.getActivity());
            realmStockEntity.setQuantity(stockEntity.getQuantity());
            realmStockEntity.setSymbol(stockEntity.getSymbol());
            realmStockEntity.setDescription(stockEntity.getDescription());
            realmStockEntity.setPrice(stockEntity.getPrice());
            realmStockEntity.setCommission(stockEntity.getCommission());
            realmStockEntity.setFees(stockEntity.getFees());
            realmStockEntity.setAmount(stockEntity.getAmount());
        }
        return realmStockEntity;
    }

    @Override
    public StockEntity map2(RealmStockEntity realmStockEntity) {
        StockEntity stockEntity = null;
        if (realmStockEntity != null) {
            stockEntity = new StockEntity();
            stockEntity.setStockId(realmStockEntity.getStockId());
            stockEntity.setDate(realmStockEntity.getDate());
            stockEntity.setActivity(realmStockEntity.getActivity());
            stockEntity.setQuantity(realmStockEntity.getQuantity());
            stockEntity.setSymbol(realmStockEntity.getSymbol());
            stockEntity.setDescription(realmStockEntity.getDescription());
            stockEntity.setPrice(realmStockEntity.getPrice());
            stockEntity.setCommission(realmStockEntity.getCommission());
            stockEntity.setFees(realmStockEntity.getFees());
            stockEntity.setAmount(realmStockEntity.getAmount());
        }
        return stockEntity;
    }



}
