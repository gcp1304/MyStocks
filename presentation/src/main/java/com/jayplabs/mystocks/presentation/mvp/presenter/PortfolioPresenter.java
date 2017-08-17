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
import java.util.UUID;
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
        stockModel.setStockId(createStockID());
        stockModel.setSymbol("APPL");
        stockModel.setDescription("Apple");
        stockModel.setQuantity(100);
        stockModel.setPrice(150.0f);
        stockModel.setActivity("Buy");
        stockModel.setDate(new Date());
        stockModel.setAmount(10000.0f);
        stockModel.setFees(1.5f);
        stockModel.setCommission(4.95f);
        stockModel.setAmount(25000.0f);
        mCreateTrade.execute(mStockDtoModelMapper.map1(stockModel), new DefaultObserver<String>(){

            @Override
            public void onNext(final String s) {
                super.onNext(s);
                mView.displayToast("Trade created with id: " + s);
            }
        });
    }

    private String createStockID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
