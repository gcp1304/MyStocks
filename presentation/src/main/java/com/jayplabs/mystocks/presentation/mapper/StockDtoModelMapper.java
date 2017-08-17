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
            stockDto = new StockDto();
            stockDto.setStockId(stockModel.getStockId());
            stockDto.setDate(stockModel.getDate());
            stockDto.setActivity(stockModel.getActivity());
            stockDto.setQuantity(stockModel.getQuantity());
            stockDto.setSymbol(stockModel.getSymbol());
            stockDto.setDescription(stockModel.getDescription());
            stockDto.setPrice(stockModel.getPrice());
            stockDto.setCommission(stockModel.getCommission());
            stockDto.setFees(stockModel.getFees());
            stockDto.setAmount(stockModel.getAmount());
        }
        return stockDto;
    }

    @Override
    public StockModel map2(final StockDto stockDto) {
        StockModel stockModel = null;
        if (stockDto != null) {
            stockModel = new StockModel();
            stockModel.setStockId(stockDto.getStockId());
            stockModel.setDate(stockDto.getDate());
            stockModel.setActivity(stockDto.getActivity());
            stockModel.setQuantity(stockDto.getQuantity());
            stockModel.setSymbol(stockDto.getSymbol());
            stockModel.setDescription(stockDto.getDescription());
            stockModel.setPrice(stockDto.getPrice());
            stockModel.setFees(stockDto.getFees());
            stockModel.setAmount(stockDto.getAmount());
        }
        return stockModel;
    }
}
