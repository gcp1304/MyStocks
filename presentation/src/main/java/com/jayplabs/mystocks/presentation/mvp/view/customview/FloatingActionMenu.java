package com.jayplabs.mystocks.presentation.mvp.view.customview;

import android.content.Context;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jayplabs.mystocks.presentation.R;


public class FloatingActionMenu extends RelativeLayout {


    private static final String TAG = FloatingActionMenu.class.getSimpleName();

    @BindView(R.id.fab_stock)
    ImageView mFabStock;
    @BindView(R.id.fab_option)
    ImageView mFabOption;
    @BindView(R.id.fab_dividend)
    ImageView mFabDividend;
    @BindView(R.id.fab_cash)
    ImageView mFabCash;
    @BindView(R.id.fab_menu)
    ImageView mFabMenu;

    private boolean isOpenMenu;

    private OnFabButtonsClickListener mFabButtonsClickListener;
    private OnFabButtonMenuClickListener mFabButtonMenuClickListener;

    public FloatingActionMenu(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    private void create(final Context context) {
        inflate(context, R.layout.view_acion_buttom_menu, this);
        ButterKnife.bind(this, this);
        LayoutParams paramsFabMenu = (LayoutParams) mFabMenu.getLayoutParams();
        paramsFabMenu.addRule(ALIGN_PARENT_BOTTOM);
        paramsFabMenu.addRule(ALIGN_PARENT_RIGHT);
        paramsFabMenu.setMargins(0, 25, 0, 0);
        mFabMenu.setLayoutParams(paramsFabMenu);

        LayoutParams paramsFabCash = (LayoutParams) mFabCash.getLayoutParams();
        paramsFabCash.addRule(ALIGN_PARENT_BOTTOM);
        paramsFabCash.addRule(ALIGN_PARENT_RIGHT);
        mFabCash.setLayoutParams(paramsFabCash);
        mFabDividend.setLayoutParams(paramsFabCash);
        mFabOption.setLayoutParams(paramsFabCash);
        mFabStock.setLayoutParams(paramsFabCash);
    }

    public void setOnFabButtonsClickListener(final OnFabButtonsClickListener listener) {
        mFabButtonsClickListener = listener;
    }

    public void setOnFabButtonMenuClickListener(final OnFabButtonMenuClickListener listener) {
        mFabButtonMenuClickListener = listener;
    }

    public boolean isOpenMenu() {
        return isOpenMenu;
    }

    @OnClick(R.id.fab_menu)
    void clickFabMenu() {
        mFabButtonMenuClickListener.onFabButtonMenuClick();
        if (isOpenMenu) {
            hideFabs();
            Log.d(TAG, "hide");
        } else {
            showFabs();
            Log.d(TAG, "show");
        }
    }

    private void showFabs() {
        isOpenMenu = true;

        Animation animation = new RotateAnimation(0, 45, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setFillEnabled(true);
        mFabMenu.startAnimation(animation);
        TransitionManager.beginDelayedTransition(this);
        RelativeLayout.LayoutParams paramsFabStock = (RelativeLayout.LayoutParams) mFabStock
            .getLayoutParams();
        paramsFabStock.removeRule(ALIGN_PARENT_BOTTOM);
        paramsFabStock.addRule(ABOVE, R.id.fab_menu);
        paramsFabStock.addRule(ALIGN_PARENT_RIGHT);
        paramsFabStock.setMargins(0, 25, 0, 0);
        mFabStock.setLayoutParams(paramsFabStock);
        RelativeLayout.LayoutParams paramsFabOption = (RelativeLayout.LayoutParams) mFabOption
            .getLayoutParams();
        paramsFabOption.removeRule(ALIGN_PARENT_BOTTOM);
        paramsFabOption.addRule(ABOVE, R.id.fab_option);
        paramsFabOption.addRule(ALIGN_PARENT_RIGHT);
        mFabOption.setLayoutParams(paramsFabOption);
        mFabCash.setLayoutParams(paramsFabOption);
        mFabDividend.setLayoutParams(paramsFabOption);
    }

    private void hideFabs() {
        isOpenMenu = false;
        Animation animation = new RotateAnimation(45, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setFillEnabled(true);
        mFabMenu.startAnimation(animation);
        TransitionManager.beginDelayedTransition(this);
        RelativeLayout.LayoutParams paramsFabStock = (RelativeLayout.LayoutParams) mFabStock
            .getLayoutParams();
        paramsFabStock.removeRule(ABOVE);
        paramsFabStock.addRule(ALIGN_PARENT_BOTTOM);
        paramsFabStock.addRule(ALIGN_PARENT_RIGHT);
        paramsFabStock.setMargins(0, 25, 0, 0);
        mFabStock.setLayoutParams(paramsFabStock);
        RelativeLayout.LayoutParams paramsFabOption = (RelativeLayout.LayoutParams) mFabOption
            .getLayoutParams();
        paramsFabOption.removeRule(ABOVE);
        paramsFabOption.addRule(ALIGN_PARENT_BOTTOM);
        paramsFabOption.addRule(ALIGN_PARENT_RIGHT);
        mFabOption.setLayoutParams(paramsFabOption);
        mFabCash.setLayoutParams(paramsFabOption);
        mFabDividend.setLayoutParams(paramsFabOption);
    }

    @OnClick(R.id.fab_stock)
    void clickFabStock() {
        if (mFabButtonsClickListener != null) mFabButtonsClickListener.onFabButtonStockClick();
    }

    @OnClick(R.id.fab_option)
    void clickFabOption() {
        if (mFabButtonsClickListener != null) mFabButtonsClickListener.onFabButtonOptionClick();
    }

    @OnClick(R.id.fab_cash)
    void clickFabCash() {
        if (mFabButtonsClickListener != null) mFabButtonsClickListener.onFabButtonCashClick();
    }

    @OnClick(R.id.fab_dividend)
    void clickFabDividend() {
        if (mFabButtonsClickListener != null) mFabButtonsClickListener.onFabButtonDividendClick();
    }

    public interface OnFabButtonsClickListener {

        void onFabButtonStockClick();

        void onFabButtonOptionClick();

        void onFabButtonCashClick();

        void onFabButtonDividendClick();

    }

    public interface OnFabButtonMenuClickListener {

        void onFabButtonMenuClick();

    }
}
