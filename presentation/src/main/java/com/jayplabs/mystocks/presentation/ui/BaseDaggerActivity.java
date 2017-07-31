package com.jayplabs.mystocks.presentation.ui;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.App;
import com.jayplabs.mystocks.presentation.di.component.ViewComponent;
import com.jayplabs.mystocks.presentation.di.module.ViewModule;

public abstract class BaseDaggerActivity<VIEW extends View,
    PRESENTER extends BasePresenter,
    BINDING extends ViewDataBinding> extends BaseActivity<VIEW, PRESENTER, BINDING> {

    private ViewComponent mViewComponent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        initViewComponent();
        super.onCreate(savedInstanceState);

    }

    protected abstract void injectViewComponent(ViewComponent viewComponent);

    private void initViewComponent() {
        mViewComponent = ((App) getApplication()).getAppComponent().plus(new ViewModule(mView));
        injectViewComponent(mViewComponent);
    }

}
