package com.freedougall.demo.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DySchedule
 *
 * @author liudandan
 */
public class DySchedule {
    private static AtomicInteger line = new AtomicInteger(0);
    static ExecutorService pool = Executors.newFixedThreadPool(100);

    public static int getLine() {
        return line.addAndGet(1000);
    }

    public static void doJob() {
        for (int i = 0; i < 100; i++) {
            Thread thread = new MyThread();
            pool.execute(thread);
        }
        pool.shutdown();

    }

    public static void main(String[] args) {
        DySchedule.doJob();
    }
}

