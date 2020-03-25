package com.ytq.fault.hundred.pool;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yuantongqin
 * description:
 * 2020/3/17
 */
public class CustomPolicy implements RejectedExecutionHandler {

    public CustomPolicy() {
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 当执行拒绝策略是，才讲任务添加到队列，判断队列长度不要超了集合长度
//        BlockingQueue<Runnable> queue = executor.getQueue();
//        if(queue instanceof CustomBlockingQueue){
//            CustomBlockingQueue c = (CustomBlockingQueue) queue;
//            c.setFlag(2);
//        }
//        queue.offer(r);

        try {
            // This does the actual put into the queue. Once the max threads
            //  have been reached, the tasks will then queue up.
            executor.getQueue().put(r);
            // we do this after the put() to stop race conditions
            if (executor.isShutdown()) {
                throw new RejectedExecutionException(
                        "Task " + r + " rejected from ");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
