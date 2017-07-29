package com.jayplabs.mystocks.presentation.di.module;

import com.jayplabs.mystocks.data.mapper.realm.RealmCashEntityMapper;
import com.jayplabs.mystocks.data.mapper.realm.RealmStockEntityMapper;
import com.jayplabs.mystocks.data.store.CashEntityStore;
import com.jayplabs.mystocks.data.store.StockEntityStore;
import com.jayplabs.mystocks.data.store.local.LocalCashEntityStore;
import com.jayplabs.mystocks.data.store.local.LocalStockEntityStore;
import com.jayplabs.mystocks.presentation.di.scope.AppScope;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class EntityStoreModule {

    @Provides
    @AppScope
    StockEntityStore provideStockEntityStore(Realm realm, RealmStockEntityMapper realmStockEntityMapper) {
        return new LocalStockEntityStore(realm, realmStockEntityMapper);
    }

    @Provides
    @AppScope
    CashEntityStore provideCashEntityStore(Realm realm, RealmCashEntityMapper realmCashEntityMapper) {
        return new LocalCashEntityStore(realm, realmCashEntityMapper);
    }
}
