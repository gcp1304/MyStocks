package com.jayplabs.mystocks.presentation.mapper;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.domain.objects.CashDto;
import com.jayplabs.mystocks.presentation.mvp.model.CashModel;
import javax.inject.Inject;

public class CashDtoModelMapper extends BaseMapper<CashDto, CashModel> {

    @Inject
    public CashDtoModelMapper() {
    }

    @Override
    public CashDto map1(final CashModel cashModel) {
        CashDto cashDto = null;
        if (cashModel != null) {
            cashDto = new CashDto(cashModel.getTransactionId());
            cashDto.setTransactionType(cashModel.getTransactionType());
            cashDto.setTransactionDate(cashModel.getTransactionDate());
            cashDto.setAmount(cashModel.getAmount());
        }
        return cashDto;
    }

    @Override
    public CashModel map2(final CashDto cashDto) {
        CashModel cashModel = null;
        if (cashDto != null) {
            cashModel = new CashModel(cashDto.getTransactionId());
            cashModel.setTransactionType(cashDto.getTransactionType());
            cashModel.setTransactionDate(cashDto.getTransactionDate());
            cashModel.setAmount(cashDto.getAmount());
        }
        return cashModel;
    }
}
