package com.jayplabs.mystocks.presentation.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.jayplabs.mystocks.presentation.R;
import com.jayplabs.mystocks.presentation.databinding.PortfolioItemBinding;
import com.jayplabs.mystocks.presentation.mvp.model.StockModel;
import com.jayplabs.mystocks.presentation.mvp.view.PortfolioView;
import com.jayplabs.mystocks.presentation.ui.viewholder.PortfolioViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioViewHolder> {

    private List<StockModel> stocks = new ArrayList<>();

    private PortfolioView mPortfolioView;

    public PortfolioAdapter(final PortfolioView portfolioView) {
        mPortfolioView = portfolioView;
    }

    @Override
    public PortfolioViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        PortfolioItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.portfolio_item, parent, false);
        return new PortfolioViewHolder(binding, mPortfolioView);
    }

    @Override
    public void onBindViewHolder(final PortfolioViewHolder holder, final int position) {
        holder.bind(stocks.get(position), position);
    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    public void setStocks(final List<StockModel> stocks) {
        this.stocks.clear();
        this.stocks.addAll(stocks);
        notifyDataSetChanged();

    }
}
