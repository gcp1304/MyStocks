package com.jayplabs.mystocks.data.executor;

import android.support.annotation.NonNull;
import com.jayplabs.mystocks.domain.executor.ThreadExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Decorated {@link java.util.concurrent.ThreadPoolExecutor}
 */
@Singleton
public class JobExecutor implements ThreadExecutor {
    private final ThreadPoolExecutor mThreadPoolExecutor;

    @Inject
    public JobExecutor() {
        mThreadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new JobThreadFactory());
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    private static class JobThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable);
        }
    }
}
