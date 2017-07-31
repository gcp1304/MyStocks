package com.jayplabs.mystocks.common.presentation.mvp.presenter;

import android.support.annotation.NonNull;
import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.presentation.mvp.view.View;

public abstract class BasePresenter<VIEW extends View> {

    protected NetworkManager mNetworkManager;

    public BasePresenter(final NetworkManager networkManager) {
        mNetworkManager = networkManager;
    }

    protected VIEW mView;

    public void attachView(@NonNull final VIEW view) {
        mView = view;
        onViewAttached();
        mNetworkManager.add(toString(), this::refreshData);
    }

    public void detachView() {
        mNetworkManager.remove(toString());
        onViewDetached();
        mView = null;
    }

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
        onDestroyed();
    }

    public abstract void refreshData();

    protected void onViewAttached() {
    }

    protected void onViewDetached() {
    }

    protected void onDestroyed() {
    }
}
