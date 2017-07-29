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
@Singleton
public class StockEntityDtoMapper extends BaseMapper<StockEntity, StockDto> {

    @Inject
    public StockEntityDtoMapper() {
    }

    @Override
    public StockEntity map1(StockDto stockDto) {
        if (stockDto == null) {
            return null;
        }
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStockId(stockDto.getStockId());
        stockEntity.setSymbol(stockDto.getSymbol());
        stockEntity.setTransactionType(stockDto.getTransactionType());
        stockEntity.setTransactionDate(stockDto.getTransactionDate());
        stockEntity.setQuantity(stockDto.getQuantity());
        stockEntity.setPrice(stockDto.getAvgPrice());
        stockEntity.setBroker(stockDto.getBroker());
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
            stockDto.setAvgPrice(stockEntity.getPrice());
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
