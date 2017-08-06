package com.jayplabs.mystocks.common.presentation.ui.loader;

import android.content.Context;
import android.support.v4.content.Loader;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;

public abstract class PresenterLoader<PRESENTER extends BasePresenter> extends Loader<PRESENTER> {

    private PRESENTER mPresenter;

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public PresenterLoader(final Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if (mPresenter != null) {
            deliverResult(mPresenter);
            return;
        }
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        mPresenter = initPresenter();
        deliverResult(mPresenter);
    }

    @Override
    protected void onReset() {
        super.onReset();
        mPresenter.destroy();
        mPresenter = null;
    }

    protected abstract PRESENTER initPresenter();
}
