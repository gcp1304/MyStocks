package com.jayplabs.mystocks.presentation;

import android.app.Application;
import com.jayplabs.mystocks.presentation.di.component.AppComponent;
import com.jayplabs.mystocks.presentation.di.component.DaggerAppComponent;
import com.jayplabs.mystocks.presentation.di.module.AppModule;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initializeInjector();
    }

    private void initRealm() {
        Realm.init(this);
        final RealmConfiguration realmConfig = new RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
