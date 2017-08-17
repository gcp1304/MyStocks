package com.jayplabs.mystocks.presentation.ui.viewholder;

import android.util.Log;
import com.jayplabs.mystocks.common.presentation.ui.viewholder.BaseViewHolder;
import com.jayplabs.mystocks.presentation.databinding.PortfolioItemBinding;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import com.jayplabs.mystocks.presentation.mvp.view.PortfolioView;

public class PortfolioViewHolder extends BaseViewHolder<PortfolioItemBinding, StockModel> {

    private static final String TAG = PortfolioViewHolder.class.getSimpleName();

    private PortfolioView mPortfolioView;

    public PortfolioViewHolder(
        final PortfolioItemBinding binding,
        final PortfolioView portfolioView) {
        super(binding);
        mPortfolioView = portfolioView;
    }

    @Override
    public void bind(final StockModel stockModel, final int position) {
        mBinding.getRoot().setOnClickListener(view -> mPortfolioView.displayToast(stockModel.getSymbol()));
        Log.d(TAG, "bind: StockID : " + stockModel.getStockId());
        mBinding.symbolTv.setText(stockModel.getSymbol());
        mBinding.quantityTv.setText(stockModel.getQuantity());
        mBinding.priceTv.setText(String.valueOf(stockModel.getPrice()));
    }
}
