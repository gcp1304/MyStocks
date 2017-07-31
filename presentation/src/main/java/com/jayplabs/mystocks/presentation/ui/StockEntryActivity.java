package com.jayplabs.mystocks.presentation.ui;

import android.databinding.DataBindingUtil;
import com.jayplabs.mystocks.presentation.R;
import com.jayplabs.mystocks.presentation.databinding.ActivityStockEntryBinding;
import com.jayplabs.mystocks.presentation.di.component.ViewComponent;
import com.jayplabs.mystocks.presentation.mvp.presenter.StockTradesPresenter;
import com.jayplabs.mystocks.presentation.mvp.view.StockTradesView;
import dagger.Lazy;
import javax.inject.Inject;

public class StockEntryActivity extends BaseDaggerActivity<StockTradesView, StockTradesPresenter, ActivityStockEntryBinding> {

    @Inject
    Lazy<StockTradesPresenter> mStockTradesPresenter;

    @Override
    protected StockTradesView initView() {
        return null;
    }

    @Override
    protected Lazy<StockTradesPresenter> initPresenter() {
        return mStockTradesPresenter;
    }

    @Override
    protected ActivityStockEntryBinding initBinding() {
        return DataBindingUtil.setContentView(this, R.layout.stock_entry);
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void injectViewComponent(final ViewComponent viewComponent) {
        viewComponent.inject(this);
    }
}
