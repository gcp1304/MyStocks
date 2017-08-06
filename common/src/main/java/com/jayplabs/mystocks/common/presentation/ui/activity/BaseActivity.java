package com.jayplabs.mystocks.common.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import com.jayplabs.mystocks.common.presentation.ui.loader.PresenterLoader;
import dagger.Lazy;

public abstract class BaseActivity<VIEW extends View,
    PRESENTER extends BasePresenter,
    BINDING extends ViewDataBinding> extends AppCompatActivity
    implements LoaderManager.LoaderCallbacks<PRESENTER> {

    private static final int LOADER_ID = 101;

    protected PRESENTER mPresenter;

    protected VIEW mView;

    protected BINDING mBinding;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = initBinding();
        mView = initView();

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter = null;
    }

    @Override
    public Loader<PRESENTER> onCreateLoader(final int id, final Bundle args) {
        return new PresenterLoader<PRESENTER>(this) {
            @Override
            protected PRESENTER initPresenter() {

                return BaseActivity.this.initPresenter().get();
            }
        };
    }

    @Override
    public final void onLoadFinished(final Loader<PRESENTER> loader, final PRESENTER presenter) {
        mPresenter = presenter;
        onLoadFinished();
        mPresenter.attachView(mView);
    }

    public void onLoadFinished() {
    }

    @Override
    public final void onLoaderReset(final Loader<PRESENTER> loader) {
        onLoadReset();
    }

    public void onLoadReset() {
    }

    public VIEW getView() {
        return mView;
    }

    protected abstract VIEW initView();

    protected abstract Lazy<PRESENTER> initPresenter();

    protected abstract BINDING initBinding();

    protected static Intent getBaseStartIntent(Context context,
        Class<? extends BaseActivity> activityClass, boolean clearStack) {
        Intent intent = new Intent(context, activityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (clearStack) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        return intent;
    }
}
