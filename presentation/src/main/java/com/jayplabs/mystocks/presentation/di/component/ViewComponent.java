package com.jayplabs.mystocks.presentation.di.component;

import com.jayplabs.mystocks.presentation.di.module.ViewModule;
import com.jayplabs.mystocks.presentation.di.scope.ViewScope;
import com.jayplabs.mystocks.presentation.ui.StockEntryActivity;
import dagger.Subcomponent;

@ViewScope
@Subcomponent(modules = {ViewModule.class})
public interface ViewComponent {

    void inject(StockEntryActivity stockEntryActivity);

}