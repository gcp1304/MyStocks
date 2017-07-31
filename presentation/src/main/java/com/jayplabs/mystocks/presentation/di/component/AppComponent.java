package com.jayplabs.mystocks.presentation.di.component;

import com.jayplabs.mystocks.presentation.App;
import com.jayplabs.mystocks.presentation.di.module.AppModule;
import com.jayplabs.mystocks.presentation.di.module.EntityStoreModule;
import com.jayplabs.mystocks.presentation.di.module.RepositoryModule;
import com.jayplabs.mystocks.presentation.di.module.ViewModule;
import com.jayplabs.mystocks.presentation.di.scope.AppScope;
import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, EntityStoreModule.class, RepositoryModule.class})
public interface AppComponent {

    ViewComponent plus(ViewModule viewModule);

    void inject(App app);
}
