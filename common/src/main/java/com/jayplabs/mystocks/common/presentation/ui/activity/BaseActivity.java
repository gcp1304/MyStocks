package com.jayplabs.mystocks.common.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import dagger.Lazy;

public abstract class BaseActivity<VIEW extends View,
    PRESENTER extends BasePresenter,
    BINDING extends ViewDataBinding> extends AppCompatActivity {

    protected PRESENTER mPresenter;

    protected VIEW mView;

    protected BINDING mBinding;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = initBinding();
        mView = initView();
        initUi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    protected void onPause() {
        mPresenter.pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter = null;
    }



    public VIEW getView() {
        return mView;
    }

    protected abstract VIEW initView();

    protected abstract Lazy<PRESENTER> initPresenter();

    protected abstract BINDING initBinding();

    protected abstract void initUi();

    protected static Intent getBaseStartIntent(Context context, Class<? extends BaseActivity> activityClass, boolean clearStack) {
        Intent intent = new Intent(context, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (clearStack) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        return intent;
    }
}
