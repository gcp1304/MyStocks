package com.jayplabs.mystocks.presentation.di.module;

import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import dagger.Module;

@Module
public class ViewModule {

    private View mView;

    public ViewModule(final View view) {
        mView = view;
    }


}

