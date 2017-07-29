package com.jayplabs.mystocks.data.mapper;

import com.jayplabs.mystocks.common.data.mapper.BaseMapper;
import com.jayplabs.mystocks.data.entity.CashEntity;
import com.jayplabs.mystocks.domain.objects.CashDto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link CashEntity} (in the data layer) to {@link CashDto} in the
 * domain layer.
 */
@Singleton
public class CashEntityDtoMapper extends BaseMapper<CashEntity, CashDto> {

    @Inject
    public CashEntityDtoMapper() {
    }

    @Override
    public CashEntity map1(CashDto cashDto) {
        if (cashDto == null) {
            return null;
        }

        CashEntity cashEntity = new CashEntity();
        cashEntity.setTransactionType(cashDto.getTransactionType());
        cashEntity.setTransactionDate(cashDto.getTransactionDate());
        cashEntity.setAmount(cashDto.getAmount());
        return cashEntity;
    }

    /**
     * Transform a {@link CashEntity} into an {@link CashDto}.
     *
     * @param cashEntity Object to be transformed.
     * @return {@link CashDto} if valid {@link CashEntity} otherwise null.
     */
    public CashDto map2(final CashEntity cashEntity) {
        CashDto cashDto = null;
        if (cashEntity != null) {
            cashDto = new CashDto(cashEntity.getTransactionId());
            cashDto.setTransactionType(cashEntity.getTransactionType());
            cashDto.setTransactionDate(cashEntity.getTransactionDate());
            cashDto.setAmount(cashEntity.getAmount());
        }
        return cashDto;
    }
}
