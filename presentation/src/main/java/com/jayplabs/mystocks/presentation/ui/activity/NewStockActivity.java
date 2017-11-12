package com.jayplabs.mystocks.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.Toolbar;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.R;
import com.jayplabs.mystocks.presentation.databinding.ActivityStockEntryBinding;
import com.jayplabs.mystocks.presentation.databinding.StockEntryBinding;
import com.jayplabs.mystocks.presentation.di.component.ViewComponent;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import com.jayplabs.mystocks.presentation.mvp.presenter.StockTradesPresenter;
import com.jayplabs.mystocks.presentation.mvp.view.NewStockView;
import com.jayplabs.mystocks.presentation.mvp.view.impl.StocksViewImpl;
import dagger.Lazy;
import javax.inject.Inject;

public class NewStockActivity extends BaseDaggerActivity<NewStockView, StockTradesPresenter, ActivityStockEntryBinding> {

    @Inject
    Lazy<StockTradesPresenter> mStockTradesPresenter;

    public static void start(final Context context) {
        Intent intent = BaseActivity.getBaseStartIntent(context, NewStockActivity.class, false);
        context.startActivity(intent);
    }

    @Override
    protected NewStockView initView() {
        return new StocksViewImpl(this) {

        };
    }

    @Override
    public void onLoadFinished() {
        super.onLoadFinished();
        initUi();
    }

    @Override
    protected Lazy<StockTradesPresenter> initPresenter() {
        return mStockTradesPresenter;
    }

    @Override
    protected ActivityStockEntryBinding initBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_stock_entry);
    }

    protected void initUi() {
    }

    @Override
    protected void injectViewComponent(final ViewComponent viewComponent) {
        viewComponent.inject(this);
    }
}
