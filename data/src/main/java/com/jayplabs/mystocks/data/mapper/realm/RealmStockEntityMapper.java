package com.jayplabs.mystocks.data.mapper.realm;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.data.entity.StockEntity;
import com.jayplabs.mystocks.data.entity.realm.RealmStockEntity;
import javax.inject.Inject;
import javax.inject.Singleton;

public class RealmStockEntityMapper extends BaseMapper<RealmStockEntity, StockEntity> {

    @Inject
    public RealmStockEntityMapper() {
    }

    @Override
    public RealmStockEntity map1(StockEntity stockEntity) {
        RealmStockEntity realmStockEntity = null;
        if (stockEntity != null) {
            realmStockEntity = new RealmStockEntity();
            realmStockEntity.setSymbol(stockEntity.getSymbol());
            realmStockEntity.setName(stockEntity.getName());
            realmStockEntity.setTransactionType(stockEntity.getTransactionType());
            realmStockEntity.setTransactionDate(stockEntity.getTransactionDate());
            realmStockEntity.setQuantity(stockEntity.getQuantity());
            realmStockEntity.setAvgPrice(stockEntity.getPrice());
            realmStockEntity.setCost(stockEntity.getCost());
            realmStockEntity.setGrantType(stockEntity.getGrantType());
            realmStockEntity.setBroker(stockEntity.getBroker());
            realmStockEntity.setBrokerage(stockEntity.getBrokerage());
            realmStockEntity.setTax(stockEntity.getTax());
            realmStockEntity.setTotalCost(stockEntity.getTotalCost());
        }
        return realmStockEntity;
    }

    @Override
    public StockEntity map2(RealmStockEntity realmStockEntity) {
        StockEntity stockEntity = null;
        if (realmStockEntity != null) {
            stockEntity = new StockEntity();
            stockEntity.setStockId(realmStockEntity.getStockId());
            stockEntity.setSymbol(realmStockEntity.getSymbol());
            stockEntity.setName(realmStockEntity.getName());
            stockEntity.setTransactionType(realmStockEntity.getTransactionType());
            stockEntity.setTransactionDate(realmStockEntity.getTransactionDate());
            stockEntity.setQuantity(realmStockEntity.getQuantity());
            stockEntity.setPrice(realmStockEntity.getAvgPrice());
            stockEntity.setCost(realmStockEntity.getCost());
            stockEntity.setGrantType(realmStockEntity.getGrantType());
            stockEntity.setBroker(realmStockEntity.getBroker());
            stockEntity.setBrokerage(realmStockEntity.getBrokerage());
            stockEntity.setTax(realmStockEntity.getTax());
            stockEntity.setTotalCost(realmStockEntity.getTotalCost());
        }
        return stockEntity;
    }



}
