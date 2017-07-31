package com.jayplabs.mystocks.common.presentation.mvp.view.impl;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.jayplabs.mystocks.common.R;
import com.jayplabs.mystocks.common.presentation.mvp.presenter.BasePresenter;
import com.jayplabs.mystocks.common.presentation.util.ProgressDialogHelper;


public abstract class ViewImpl implements com.jayplabs.mystocks.common.presentation.mvp.view.View {

    private Activity mActivity;

    private Fragment mFragment;

    private View mView;

    private Service mService;

    private ProgressDialogHelper mProgressDialog;

    public ViewImpl(final Activity activity) {
        mActivity = activity;
        init();
    }

    public ViewImpl(final Fragment fragment) {
        mFragment = fragment;
        init();
    }

    public ViewImpl(final Service service) {
        mService = service;
        init();
    }

    public ViewImpl(final View view) {
        mView = view;
        init();
    }

    private void init() {
        mProgressDialog = new ProgressDialogHelper();
    }

    @Override
    public void showMessage(final String message) {
        if (getSnackBarBackground() == null) {
            return;
        }
        Snackbar.make(getSnackBarBackground(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(final int messageResId) {
        if (getContext() == null) {
            return;
        }
        showMessage(getContext().getString(messageResId));
    }

    @Override
    public void showProgress() {
        if (getContext() == null) {
            return;
        }
        mProgressDialog.showProgress(getContext(), getContext().getString(R.string.loading));
    }

    @Override
    public void showProgress(final String message) {
        mProgressDialog.showProgress(getContext(), message);
    }

    @Override
    public void showProgress(final int messageResId) {
        if (getContext() == null) {
            return;
        }
        showProgress(getContext().getString(messageResId));
    }

    @Override
    public void showProgress(final String message, final String title) {
        mProgressDialog.showProgress(getContext(), message, title);
    }

    @Override
    public void showProgress(final int messageResId, final int titleResId) {
        if (getContext() == null) {
            return;
        }
        showProgress(getContext().getString(messageResId), getContext().getString(titleResId));
    }

    @Override
    public void hideProgress() {
        mProgressDialog.hideProgress();
    }

    @Override
    public void hideKeyboard() {
        if (getContext() == null || getWindowToken() == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(getWindowToken(), 0);
    }

    public void initSwipeToRefresh(final SwipeRefreshLayout swipeRefreshLayout,
        final BasePresenter basePresenter) {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            basePresenter.refreshData();
        });
    }

    private Context getContext() {
        if (mActivity != null) {
            return mActivity;
        } else if (mFragment != null) {
            return mFragment.getContext();
        } else if (mView != null) {
            return mView.getContext();
        } else if (mService != null) {
            return mService;
        }
        return null;
    }

    private View getSnackBarBackground() {
        if (mActivity != null) {
            return mActivity.findViewById(android.R.id.content);
        } else if (mView != null) {
            return mView;
        } else if (mFragment != null) {
            return mFragment.getView();
        }
        return null;
    }

    private IBinder getWindowToken() {
        if (mActivity != null) {
            View view = mActivity.getCurrentFocus();
            return view == null ? null : view.getWindowToken();
        } else if (mFragment != null) {
            Activity activity = mFragment.getActivity();
            if (activity == null) {
                return null;
            }
            View view = activity.getCurrentFocus();
            return view == null ? null : view.getWindowToken();
        } else if (mView != null) {
            return mView.getWindowToken();
        }
        return null;
    }
}
