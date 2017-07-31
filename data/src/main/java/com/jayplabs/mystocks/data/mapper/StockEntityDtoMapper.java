package com.jayplabs.mystocks.data.mapper;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.data.entity.StockEntity;
import com.jayplabs.mystocks.domain.objects.StockDto;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link StockEntity} (in the data layer) to {@link StockDto} in the
 * domain layer.
 */
public class StockEntityDtoMapper extends BaseMapper<StockEntity, StockDto> {

    @Inject
    public StockEntityDtoMapper() {
    }

    @Override
    public StockEntity map1(StockDto stockDto) {
        StockEntity stockEntity = null;
        if (stockDto != null) {
            stockEntity = new StockEntity();
            stockEntity.setStockId(stockDto.getStockId());
            stockEntity.setSymbol(stockDto.getSymbol());
            stockEntity.setName(stockDto.getName());
            stockEntity.setTransactionType(stockDto.getTransactionType());
            stockEntity.setTransactionDate(stockDto.getTransactionDate());
            stockEntity.setQuantity(stockDto.getQuantity());
            stockEntity.setPrice(stockDto.getPrice());
            stockEntity.setCost(stockDto.getCost());
            stockEntity.setGrantType(stockDto.getGrantType());
            stockEntity.setBroker(stockDto.getBroker());
            stockEntity.setBrokerage(stockDto.getBrokerage());
            stockEntity.setTax(stockDto.getTax());
            stockEntity.setTotalCost(stockDto.getTotalCost());
        }
        return stockEntity;
    }

    /**
     * Transform a {@link StockEntity} into an {@link StockDto}.
     *
     * @param stockEntity Object to be transformed.
     * @return {@link StockDto} if valid {@link StockEntity} otherwise null.
     */
    public StockDto map2(final StockEntity stockEntity) {
        StockDto stockDto = null;
        if (stockEntity != null) {
            stockDto = new StockDto(stockEntity.getStockId());
            stockDto.setSymbol(stockEntity.getSymbol());
            stockDto.setName(stockEntity.getName());
            stockDto.setTransactionType(stockEntity.getTransactionType());
            stockDto.setTransactionDate(stockEntity.getTransactionDate());
            stockDto.setQuantity(stockEntity.getQuantity());
            stockDto.setPrice(stockEntity.getPrice());
            stockDto.setCost(stockEntity.getCost());
            stockDto.setGrantType(stockEntity.getGrantType());
            stockDto.setBroker(stockEntity.getBroker());
            stockDto.setBrokerage(stockEntity.getBrokerage());
            stockDto.setTax(stockEntity.getTax());
            stockDto.setTotalCost(stockEntity.getTotalCost());
        }
        return stockDto;
    }
}
