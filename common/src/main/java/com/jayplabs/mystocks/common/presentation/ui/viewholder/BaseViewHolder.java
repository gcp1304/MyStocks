package com.jayplabs.mystocks.common.presentation.ui.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<BINDING extends ViewDataBinding, MODEL> extends RecyclerView.ViewHolder {

    protected BINDING mBinding;

    public BaseViewHolder(final BINDING binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public abstract void bind(MODEL model, int position);
}
