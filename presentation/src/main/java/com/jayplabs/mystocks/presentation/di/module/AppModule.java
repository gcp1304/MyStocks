package com.jayplabs.mystocks.presentation.di.module;

import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.data.manager.impl.NetworkManagerImpl;
import com.jayplabs.mystocks.presentation.App;
import com.jayplabs.mystocks.presentation.di.scope.AppScope;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import javax.inject.Named;

@Module
public class AppModule {

    private App mApp;

    public AppModule(final App app) {
        mApp = app;
    }

    @Provides
    @AppScope
    App provideAppContext() {
        return mApp;
    }

    @Provides
    @Named("Thread")
    @AppScope
    Scheduler provideThreadScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Named("PostExecution")
    @AppScope
    Scheduler providePostExecutionScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @AppScope
    Realm provideRealmInstance() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @AppScope
    NetworkManager providesNetworkManager() {
        return new NetworkManagerImpl(mApp);
    }


}
