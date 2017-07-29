package com.jayplabs.mystocks.presentation.di.module;

import com.jayplabs.mystocks.data.mapper.CashEntityDtoMapper;
import com.jayplabs.mystocks.data.mapper.StockEntityDtoMapper;
import com.jayplabs.mystocks.data.repository.CashRepositoryImpl;
import com.jayplabs.mystocks.data.repository.StockRepositoryImpl;
import com.jayplabs.mystocks.data.store.CashEntityStore;
import com.jayplabs.mystocks.data.store.StockEntityStore;
import com.jayplabs.mystocks.domain.repository.CashRepository;
import com.jayplabs.mystocks.domain.repository.StockRepository;
import com.jayplabs.mystocks.presentation.di.scope.AppScope;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @AppScope
    StockRepository provideStockRepository(StockEntityStore stockEntityStore, StockEntityDtoMapper stockEntityDtoMapper) {
        return new StockRepositoryImpl(stockEntityStore, stockEntityDtoMapper);
    }

    @Provides
    @AppScope
    CashRepository provideCashRepository(CashEntityStore cashEntityStore, CashEntityDtoMapper cashEntityDtoMapper) {
        return new CashRepositoryImpl(cashEntityStore, cashEntityDtoMapper);
    }
}
