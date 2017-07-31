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
import com.jayplabs.mystocks.presentation.mvp.view.StockTradesView;
import javax.inject.Inject;

@ViewScope
public class CreateStockTradePresenter extends BasePresenter<StockTradesView> {

    private CreateTrade mCreateTrade;

    private DeleteTrade mDeleteTrade;

    private GetAllTrades mGetAllTrades;

    private RetrieveTrade mRetrieveTrade;

    private UpdateTrade mUpdateTrade;

    private StockDtoModelMapper mStockDtoModelMapper;

    @Inject
    public CreateStockTradePresenter(
        final NetworkManager networkManager,
        final CreateTrade createTrade, final DeleteTrade deleteTrade,
        final GetAllTrades getAllTrades,
        final RetrieveTrade retrieveTrade,
        final UpdateTrade updateTrade,
        final StockDtoModelMapper stockDtoModelMapper) {
        super(networkManager);
        mCreateTrade = createTrade;
        mDeleteTrade = deleteTrade;
        mGetAllTrades = getAllTrades;
        mRetrieveTrade = retrieveTrade;
        mUpdateTrade = updateTrade;
        mStockDtoModelMapper = stockDtoModelMapper;
    }

    @Override
    public void refreshData() {

    }
}
