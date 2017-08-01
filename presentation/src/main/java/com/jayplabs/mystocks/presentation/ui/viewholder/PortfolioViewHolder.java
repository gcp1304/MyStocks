package com.jayplabs.mystocks.presentation.ui.viewholder;

import com.jayplabs.mystocks.common.presentation.ui.viewholder.BaseViewHolder;
import com.jayplabs.mystocks.presentation.databinding.PortfolioItemBinding;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;

public class PortfolioViewHolder extends BaseViewHolder<PortfolioItemBinding, StockModel> {


    public PortfolioViewHolder(
        final PortfolioItemBinding binding) {
        super(binding);
    }

    @Override
    public void bind(final StockModel stockModel, final int position) {
        mBinding.symbolTv.setText(stockModel.getSymbol());
        mBinding.quantityTv.setText(stockModel.getQuantity());
        mBinding.priceTv.setText(stockModel.getPrice());
    }
}
