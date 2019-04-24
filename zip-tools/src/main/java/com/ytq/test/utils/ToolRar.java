package com.ytq.test.utils;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.junrar.io.InputStreamReadOnlyAccessFile;
import com.github.junrar.io.RandomAccessStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author yuantongqin
 * 2019/4/11
 */
@Component
public class ToolRar {
    private static Logger LOGGER = LoggerFactory.getLogger(ToolRar.class);

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void ss(){

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        executorService.shutdown();
        // 检测当前executorservice是否关闭，如果关闭返回true
        while (!executorService.isTerminated()) {
            LOGGER.warn("image upload executorService not isTerminated...fileKey");
            try {
                // 如果没有关闭则等待五秒后关闭
                executorService.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("image upload executorService awaitTermination exception...fileKey");
            }
        }
        executorService.shutdown();

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        executorService.shutdown();
    }

}
