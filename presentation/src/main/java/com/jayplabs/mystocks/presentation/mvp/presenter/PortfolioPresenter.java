package com.jayplabs.mystocks.presentation.mvp.presenter;

import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.domain.interactor.stock.GetAllTrades;
import com.jayplabs.mystocks.presentation.mvp.view.PortfolioView;
import javax.inject.Inject;

public class PortfolioPresenter extends BasePresenter<PortfolioView> {

    private GetAllTrades mGetAllTrades;

    @Inject
    public PortfolioPresenter(
        final NetworkManager networkManager,
        final GetAllTrades getAllTrades) {
        super(networkManager);
        mGetAllTrades = getAllTrades;
    }

    @Override
    public void refreshData() {

    }
}
