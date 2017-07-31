package com.jayplabs.mystocks.common.data.manager.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.jayplabs.mystocks.common.data.manager.NetworkManager;
import java.util.HashMap;
import java.util.Map;

public class NetworkManagerImpl extends BroadcastReceiver implements NetworkManager {

    private Context mContext;

    private IntentFilter mConnectivityIntentFilter = new IntentFilter(
        ConnectivityManager.CONNECTIVITY_ACTION);

    private Map<String, Listener> mListeners = new HashMap<>();

    public NetworkManagerImpl(final Context context) {
        mContext = context;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if (isNetworkAvailable() && !isInitialStickyBroadcast()) {
            for (Listener listener : mListeners.values()) {
                if (listener != null) {
                    listener.onNetworkAvailable();
                }
            }
        }
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) mContext
            .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
                || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        mContext.registerReceiver(this, mConnectivityIntentFilter);
    }

    @Override
    public void stop() {
        mContext.unregisterReceiver(this);
    }

    @Override
    public void add(final String tag, final Listener listener) {
        mListeners.put(tag, listener);
    }

    @Override
    public void remove(final String tag) {
        mListeners.remove(tag);
    }
}
