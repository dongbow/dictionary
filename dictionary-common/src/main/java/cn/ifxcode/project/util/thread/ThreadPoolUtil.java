package cn.ifxcode.project.util.thread;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Base64
 *
 * @author dongbo
 * @date 2017/10/30
 */
@Slf4j
public class ThreadPoolUtil {

    public static ThreadPoolUtil threadPoolUtil = null;

    public static ThreadPoolUtil getInstance() {
        if (threadPoolUtil == null) {
            synchronized (ThreadPoolUtil.class) {
                if (threadPoolUtil == null) {
                    threadPoolUtil = new ThreadPoolUtil();
                }
            }
        }
        return threadPoolUtil;
    }

    /**
     * 主线程数
     */
    private int corePoolSize = 10;

    /**
     * 最大线程数
     */
    private int maximumPoolSize = 20;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private long keepAliveTime = 2000;

    /**
     * 单例的线程池类
     */
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 线程池所使用的缓冲队列的大小
     */
    private int queueSize = 200;
    private volatile boolean inited = false;

    public void init() {
        if (inited) {
            return;
        }
        synchronized (this) {
            if (inited) {
                return;
            }
            inited = true;
        }
        this.threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize), new BlockingQueuePut());
    }

    public void addTask(Runnable task) {
        addTask(task, "");
    }

    public void addTask(Runnable task, Object businessInfo) {
        log.info("ThreadPoolService add task: thread hashCode: {},  businessInfo: {}", task.hashCode(),
                JSON.toJSON(businessInfo));
        if (!inited) {
            init();
        }
        log.info("start execute task: {}", task.hashCode());
        threadPoolExecutor.execute(task);
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    private static class BlockingQueuePut implements RejectedExecutionHandler {
        /**
         * define the reject policy when executor queue is full
         *
         * @see RejectedExecutionHandler
         * #rejectedExecution(java.lang.Runnable, java.util.concurrent.ThreadPoolExecutor)
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getActiveCount() {
        return threadPoolExecutor.getActiveCount();
    }

    public void stop() {
        threadPoolExecutor.shutdownNow();
    }
}
