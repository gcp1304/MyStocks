package com.jayplabs.mystocks.presentation.mvp.view;

import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import java.util.List;


public interface StockTradesView extends View {

    void displayStockDetail(StockModel stockModel);

    void listAllStocks(List<StockModel> stocks);
}
