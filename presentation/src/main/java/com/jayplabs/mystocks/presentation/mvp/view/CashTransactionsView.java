package com.jayplabs.mystocks.presentation.mvp.view;

import com.jayplabs.mystocks.common.presentation.mvp.view.View;
import com.jayplabs.mystocks.presentation.mvp.model.CashModel;
import java.util.List;


public interface CashTransactionsView extends View {

    void displayTransaction(CashModel transaction);

    void listAllTransactions(List<CashModel> transactions);
}
