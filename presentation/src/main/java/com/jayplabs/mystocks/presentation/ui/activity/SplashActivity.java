package com.jayplabs.mystocks.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.jayplabs.mystocks.common.presentation.mvp.view.impl.ViewImpl;
import com.jayplabs.mystocks.common.presentation.ui.activity.BaseActivity;
import com.jayplabs.mystocks.presentation.R;
import com.jayplabs.mystocks.presentation.databinding.ActivitySplashBinding;
import com.jayplabs.mystocks.presentation.di.component.ViewComponent;
import com.jayplabs.mystocks.presentation.mvp.presenter.SplashPresenter;
import com.jayplabs.mystocks.presentation.mvp.view.SplashView;
import com.jayplabs.mystocks.presentation.mvp.view.impl.SplashViewImpl;
import dagger.Lazy;
import javax.inject.Inject;

public class SplashActivity extends BaseDaggerActivity<SplashView, SplashPresenter, ActivitySplashBinding> {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Inject
    Lazy<SplashPresenter> mSplashPresenter;

    public static void start(final Context context) {
        Intent intent = BaseActivity.getBaseStartIntent(context, SplashActivity.class, true);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onLoadFinished() {
        super.onLoadFinished();
        initUi();
    }

    @Override
    protected SplashView initView() {
       return new SplashViewImpl(this) {
           @Override
           public void navigateToPortfolio() {
               PortfolioActivity.start(SplashActivity.this);
               finish();
           }
       };
    }

    @Override
    protected Lazy<SplashPresenter> initPresenter() {
        return mSplashPresenter;
    }

    @Override
    protected ActivitySplashBinding initBinding() {
        return DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }

    @Override
    protected void injectViewComponent(final ViewComponent viewComponent) {
        viewComponent.inject(this);
    }

    private void initUi() {
        initSwipeToRefresh();
    }

    private void initSwipeToRefresh() {
        ((ViewImpl) mView).initSwipeToRefresh(mBinding.swipeToRefresh, mPresenter);
    }
}
