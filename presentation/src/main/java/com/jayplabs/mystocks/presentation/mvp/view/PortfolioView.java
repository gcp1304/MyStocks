package com.jayplabs.mystocks.presentation.mvp.view;

import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import java.util.List;

public interface PortfolioView extends View {

    void listAllStocks(List<StockModel> stocks);

    void displayToast(String message);

}
