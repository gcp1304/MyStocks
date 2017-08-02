package com.jayplabs.mystocks.presentation.mvp.presenter;

import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.domain.interactor.DefaultObserver;
import com.jayplabs.mystocks.domain.interactor.stock.CreateTrade;
import com.jayplabs.mystocks.domain.interactor.stock.GetAllTrades;
import com.jayplabs.mystocks.presentation.mapper.StockDtoModelMapper;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import com.jayplabs.mystocks.presentation.mvp.view.PortfolioView;
import java.util.Date;
import javax.inject.Inject;

public class PortfolioPresenter extends BasePresenter<PortfolioView> {

    private GetAllTrades mGetAllTrades;
    private CreateTrade mCreateTrade;
    private StockDtoModelMapper mStockDtoModelMapper;

    @Inject
    public PortfolioPresenter(
        final NetworkManager networkManager,
        final GetAllTrades getAllTrades,
        final CreateTrade createTrade,
        final StockDtoModelMapper stockDtoModelMapper) {
        super(networkManager);
        mGetAllTrades = getAllTrades;
        mCreateTrade = createTrade;
        mStockDtoModelMapper = stockDtoModelMapper;
    }

    @Override
    public void refreshData() {

    }

    public void createDummyStockApple() {
        StockModel stockModel = new StockModel();
        stockModel.setSymbol("APPL");
        stockModel.setQuantity(100);
        stockModel.setPrice("150");
        stockModel.setTransactionType("Buy");
        stockModel.setTransactionDate(new Date());
        mCreateTrade.execute(mStockDtoModelMapper.map1(stockModel), new DefaultObserver<String>(){

            @Override
            public void onNext(final String s) {
                super.onNext(s);
                mView.displayToast("Trade created with id: " + s);
            }
        });
    }

    public void createDummyStockGoogle() {
        StockModel stockModel = new StockModel();
        stockModel.setSymbol("GOOG");
        stockModel.setQuantity(100);
        stockModel.setPrice("150");
        stockModel.setTransactionType("Buy");
        stockModel.setTransactionDate(new Date());
        mCreateTrade.execute(mStockDtoModelMapper.map1(stockModel), new DefaultObserver<String>(){

            @Override
            public void onNext(final String s) {
                super.onNext(s);
                mView.displayToast("Trade created with id: " + s);
            }
        });
    }
}
