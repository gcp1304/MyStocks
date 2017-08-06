package com.jayplabs.mystocks.presentation.mvp.presenter;

import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.presentation.di.scope.ViewScope;
import com.jayplabs.mystocks.presentation.mvp.view.SplashView;
import javax.inject.Inject;

@ViewScope
public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    public SplashPresenter(final NetworkManager networkManager) {
        super(networkManager);
    }

    @Override
    public void refreshData() {
        mView.navigateToPortfolio();
    }

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        refreshData();
    }
}
