package com.jayplabs.mystocks.common.presentation.util;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogHelper {

    private ProgressDialog mProgressDialog;

    private volatile int mProgressCount = 0;

    public void showProgress(final Context context) {
        showProgress(context, null);
    }

    public void showProgress(final Context context, final String message) {
        showProgress(context, message, null);
    }

    public void showProgress(final Context context, final String message, final String title) {
        if (context == null) {
            return;
        }

        if (!inProgress()) {
            mProgressDialog = new ProgressDialog(context);
            if (message != null) mProgressDialog.setMessage(message);
            if (title != null) mProgressDialog.setTitle(title);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.show();
        }
        mProgressCount++;
    }

    public void hideProgress() {
        mProgressCount--;
        if (mProgressCount <= 0) {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
            mProgressCount = 0;
        }
    }

    private boolean inProgress() {
        return mProgressDialog != null && mProgressDialog.isShowing();
    }
}
