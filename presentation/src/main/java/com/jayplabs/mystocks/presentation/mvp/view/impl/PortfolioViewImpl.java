package com.jayplabs.mystocks.presentation.mvp.view.impl;

import com.jayplabs.mystocks.common.presentation.mvp.view.impl.ViewImpl;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.mvp.view.PortfolioView;

public abstract class PortfolioViewImpl extends ViewImpl implements PortfolioView {

    public PortfolioViewImpl(final BaseActivity activity) {
        super(activity);
    }
}
