package com.jayplabs.mystocks.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.R;
import com.jayplabs.mystocks.presentation.databinding.ActivityPortfolioBinding;
import com.jayplabs.mystocks.presentation.di.component.ViewComponent;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import com.jayplabs.mystocks.presentation.mvp.presenter.PortfolioPresenter;
import com.jayplabs.mystocks.presentation.mvp.view.PortfolioView;
import com.jayplabs.mystocks.presentation.mvp.view.impl.PortfolioViewImpl;
import com.jayplabs.mystocks.presentation.ui.adapter.PortfolioAdapter;
import dagger.Lazy;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class PortfolioActivity extends
    BaseDaggerActivity<PortfolioView, PortfolioPresenter, ActivityPortfolioBinding> {

    @Inject
    Lazy<PortfolioPresenter> mPortfolioPresenter;

    private PortfolioAdapter mPortfolioAdapter;

    public static void start(final Context context) {
        Intent intent = BaseActivity.getBaseStartIntent(context, PortfolioActivity.class, false);
        context.startActivity(intent);
    }

    @Override
    public void onLoadFinished() {
        super.onLoadFinished();
        initUi();
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add_trade:
                Toast.makeText(this, "Adding Trade", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected PortfolioView initView() {
        return new PortfolioViewImpl(this) {
            @Override
            public void listAllStocks(final List<StockModel> stocks) {
                mPortfolioAdapter.setStocks(stocks);
            }

            @Override
            public void displayToast(final String message) {
                Toast.makeText(PortfolioActivity.this, message, Toast.LENGTH_SHORT).show();
            }


        };
    }

    @Override
    protected Lazy<PortfolioPresenter> initPresenter() {
        return mPortfolioPresenter;
    }

    @Override
    protected ActivityPortfolioBinding initBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_portfolio);
    }

    @Override
    protected void injectViewComponent(final ViewComponent viewComponent) {
        viewComponent.inject(this);
    }

    private void initUi() {
        initToolbar();
        initPortfolioList();
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //insertDummyData();
    }

    private void insertDummyData() {
        mPresenter.createDummyStockApple();
        mPresenter.createDummyStockGoogle();
    }

    private void initToolbar() {
        // setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initPortfolioList() {
        mPortfolioAdapter = new PortfolioAdapter(mView);
        mBinding.portfolioList.setAdapter(mPortfolioAdapter);
        mBinding.portfolioList.setLayoutManager(new LinearLayoutManager(this));
    }


}
