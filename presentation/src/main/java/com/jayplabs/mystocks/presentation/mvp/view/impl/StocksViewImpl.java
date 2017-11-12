package com.jayplabs.mystocks.presentation.mvp.view.impl;

import com.jayplabs.mystocks.common.presentation.mvp.view.impl.ViewImpl;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.mvp.view.NewStockView;


public abstract class StocksViewImpl extends ViewImpl implements NewStockView {

    public StocksViewImpl(final BaseActivity baseActivity) {
        super(baseActivity);
    }
}
