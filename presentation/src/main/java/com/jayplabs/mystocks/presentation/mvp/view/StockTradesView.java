package com.jayplabs.mystocks.presentation.mvp.view;

import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;


public interface StockTradesView extends View {

    void displayStockDetail(StockModel stockModel);
}
