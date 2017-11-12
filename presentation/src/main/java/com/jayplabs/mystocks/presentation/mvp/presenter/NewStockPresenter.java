package com.jayplabs.mystocks.presentation.mvp.presenter;

import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.domain.interactor.stock.CreateTrade;
import com.jayplabs.mystocks.domain.interactor.stock.DeleteTrade;
import com.jayplabs.mystocks.domain.interactor.stock.GetAllTrades;
import com.jayplabs.mystocks.domain.interactor.stock.RetrieveTrade;
import com.jayplabs.mystocks.domain.interactor.stock.UpdateTrade;
import com.jayplabs.mystocks.presentation.di.scope.ViewScope;
import com.jayplabs.mystocks.presentation.mapper.StockDtoModelMapper;
import com.jayplabs.mystocks.presentation.mvp.view.NewStockView;
import java.util.UUID;
import javax.inject.Inject;

@ViewScope
public class NewStockPresenter extends BasePresenter<NewStockView> {

    private CreateTrade mCreateTrade;

    private StockDtoModelMapper mStockDtoModelMapper;

    @Inject
    public NewStockPresenter(
        final NetworkManager networkManager,
        final CreateTrade createTrade,
        final StockDtoModelMapper stockDtoModelMapper) {
        super(networkManager);
        mCreateTrade = createTrade;
        mStockDtoModelMapper = stockDtoModelMapper;
    }

    @Override
    public void refreshData() {

    }

    private String createStockID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
