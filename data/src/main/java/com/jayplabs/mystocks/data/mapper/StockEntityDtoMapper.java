package com.jayplabs.mystocks.data.mapper;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.data.entity.StockEntity;
import com.jayplabs.mystocks.domain.objects.StockDto;
import javax.inject.Inject;

public class StockEntityDtoMapper extends BaseMapper<StockEntity, StockDto> {

    @Inject
    public StockEntityDtoMapper() {
    }

    @Override
    public StockEntity map1(final StockDto stockDto) {
        StockEntity stockEntity = null;

        if (stockDto != null) {
            stockEntity = new StockEntity();
            stockEntity.setDate(stockDto.getDate());
            stockEntity.setActivity(stockDto.getActivity());
            stockEntity.setQuantity(stockDto.getQuantity());
            stockEntity.setSymbol(stockDto.getSymbol());
            stockEntity.setDescription(stockDto.getDescription());
            stockEntity.setPrice(stockDto.getPrice());
            stockEntity.setCommission(stockDto.getCommission());
            stockEntity.setFees(stockDto.getFees());
            stockEntity.setAmount(stockDto.getAmount());
        }
        return stockEntity;
    }

    @Override
    public StockDto map2(final StockEntity stockEntity) {
        StockDto stockDto = null;
        if (stockEntity != null) {
            stockDto = new StockDto();
            stockDto.setStockId(stockEntity.getStockId());
            stockDto.setDate(stockEntity.getDate());
            stockDto.setActivity(stockEntity.getActivity());
            stockDto.setQuantity(stockEntity.getQuantity());
            stockDto.setSymbol(stockEntity.getSymbol());
            stockDto.setDescription(stockEntity.getDescription());
            stockDto.setPrice(stockEntity.getPrice());
            stockDto.setCommission(stockEntity.getCommission());
            stockDto.setFees(stockEntity.getFees());
            stockDto.setAmount(stockEntity.getAmount());
        }
        return stockDto;
    }


}
