package com.jayplabs.mystocks.presentation.mvp.presenter;

import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.domain.interactor.DefaultObserver;
import com.jayplabs.mystocks.domain.interactor.stock.CreateTrade;
import com.jayplabs.mystocks.domain.interactor.stock.DeleteTrade;
import com.jayplabs.mystocks.domain.interactor.stock.GetAllTrades;
import com.jayplabs.mystocks.domain.interactor.stock.RetrieveTrade;
import com.jayplabs.mystocks.domain.interactor.stock.UpdateTrade;
import com.jayplabs.mystocks.domain.objects.StockDto;
import com.jayplabs.mystocks.presentation.di.scope.ViewScope;
import com.jayplabs.mystocks.presentation.mapper.StockDtoModelMapper;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import com.jayplabs.mystocks.presentation.mvp.view.StockTradesView;
import java.util.List;
import javax.inject.Inject;

@ViewScope
public class StockTradesPresenter extends BasePresenter<StockTradesView> {


    private GetAllTrades mGetAllTrades;

    private RetrieveTrade mRetrieveTrade;

    private CreateTrade mCreateTrade;

    private UpdateTrade mUpdateTrade;

    private DeleteTrade mDeleteTrade;

    private StockDtoModelMapper mStockDtoModelMapper;

    private StockModel mStockModel;

    @Inject
    public StockTradesPresenter(
        final NetworkManager networkManager,
        final GetAllTrades getAllTrades,
        final RetrieveTrade retrieveTrade,
        final CreateTrade createTrade, final UpdateTrade updateTrade,
        final DeleteTrade deleteTrade,
        final StockDtoModelMapper stockDtoModelMapper,
        final StockModel stockModel) {
        super(networkManager);
        mGetAllTrades = getAllTrades;
        mRetrieveTrade = retrieveTrade;
        mCreateTrade = createTrade;
        mUpdateTrade = updateTrade;
        mDeleteTrade = deleteTrade;
        mStockDtoModelMapper = stockDtoModelMapper;
        mStockModel = stockModel;
    }

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        refreshData();
    }

    @Override
    protected void onViewDetached() {
        super.onViewDetached();
        mGetAllTrades.dispose();
        mCreateTrade.dispose();
        mRetrieveTrade.dispose();
        mDeleteTrade.dispose();
        mUpdateTrade.dispose();
    }

    @Override
    public void refreshData() {
        retrieveAllTrades();
    }

    private void retrieveAllTrades() {
        mView.showProgress();;
        mGetAllTrades.execute(new DefaultObserver<List<StockDto>>() {
            @Override
            public void onNext(final List<StockDto> stockDtos) {
                super.onNext(stockDtos);
                mView.listAllStocks(mStockDtoModelMapper.map2(stockDtos));
                mView.hideProgress();
            }

            @Override
            public void onError(final Throwable exception) {
                super.onError(exception);
                mView.showMessage(exception.getMessage());
                mView.hideProgress();
            }
        });
    }

    private void retrieveCurrentTrade(String stockId) {
        mView.showProgress();

        DefaultObserver<StockDto> retrieveTradeObserver = new DefaultObserver<StockDto>() {
            @Override
            public void onNext(final StockDto stockDto) {
                super.onNext(stockDto);
                mStockModel = mStockDtoModelMapper.map2(stockDto);
                mView.hideProgress();
            }

            @Override
            public void onError(final Throwable exception) {
                super.onError(exception);
                mView.showMessage(exception.getMessage());
                mView.hideProgress();
            }
        };
        mRetrieveTrade.execute(stockId, retrieveTradeObserver);
    }
}
