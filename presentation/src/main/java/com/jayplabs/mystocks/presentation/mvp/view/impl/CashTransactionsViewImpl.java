package com.jayplabs.mystocks.presentation.mvp.view.impl;

import com.jayplabs.mystocks.common.presentation.mvp.view.impl.ViewImpl;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.mvp.view.CashTransactionsView;


public abstract class CashTransactionsViewImpl extends ViewImpl implements CashTransactionsView {

    public CashTransactionsViewImpl(final BaseActivity activity) {
        super(activity);
    }
}
