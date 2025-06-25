package com.laolang.note.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateStartApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("主线程");

        CustomThread t1 = new CustomThread();
        t1.start();

        Thread t2 = new Thread(new CustomRunnable());
        t2.start();

        FutureTask<Integer> futureTask = new FutureTask<>(new CustomCallable());
        Thread t3 = new Thread(futureTask);
        t3.start();
        while (futureTask.isDone()) {
            log.info("futureTask 结果:{}", futureTask.get());
        }
    }
}
