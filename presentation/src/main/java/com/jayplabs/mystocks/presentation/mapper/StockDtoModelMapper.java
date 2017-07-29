package com.jayplabs.mystocks.presentation.mapper;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.domain.objects.StockDto;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import javax.inject.Inject;

public class StockDtoModelMapper extends BaseMapper<StockDto, StockModel> {

    @Inject
    public StockDtoModelMapper() {
    }

    @Override
    public StockDto map1(final StockModel stockModel) {
        StockDto stockDto = null;
        if (stockModel != null) {
            stockDto = new StockDto(stockModel.getStockId());
            stockDto.setSymbol(stockModel.getSymbol());
            stockDto.setName(stockModel.getName());
            stockDto.setTransactionType(stockModel.getTransactionType());
            stockDto.setTransactionDate(stockModel.getTransactionDate());
            stockDto.setQuantity(stockModel.getQuantity());
            stockDto.setPrice(stockModel.getPrice());
            stockDto.setCost(stockModel.getCost());
            stockDto.setGrantType(stockModel.getGrantType());
            stockDto.setBroker(stockModel.getBroker());
            stockDto.setBrokerage(stockModel.getBrokerage());
            stockDto.setTax(stockModel.getTax());
            stockDto.setTotalCost(stockModel.getTotalCost());
        }
        return stockDto;
    }

    @Override
    public StockModel map2(final StockDto stockDto) {
        StockModel stockModel = null;
        if (stockDto != null) {
            stockModel = new StockModel(stockDto.getStockId());
            stockModel.setSymbol(stockDto.getSymbol());
            stockModel.setName(stockDto.getName());
            stockModel.setTransactionType(stockDto.getTransactionType());
            stockModel.setTransactionDate(stockDto.getTransactionDate());
            stockModel.setQuantity(stockDto.getQuantity());
            stockModel.setPrice(stockDto.getPrice());
            stockModel.setCost(stockDto.getCost());
            stockModel.setGrantType(stockDto.getGrantType());
            stockModel.setBroker(stockDto.getBroker());
            stockModel.setBrokerage(stockDto.getBrokerage());
            stockModel.setTax(stockDto.getTax());
            stockModel.setTotalCost(stockDto.getTotalCost());
        }
        return stockModel;

    }
}
