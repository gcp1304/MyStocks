package com.jayplabs.mystocks.presentation.mvp.view.impl;

import com.jayplabs.mystocks.common.presentation.mvp.view.impl.ViewImpl;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.mvp.view.SplashView;


public abstract class SplashViewImpl extends ViewImpl implements SplashView {

    public SplashViewImpl(final BaseActivity activity) {
        super(activity);
    }
}
