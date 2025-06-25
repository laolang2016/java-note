package com.laolang.note.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomRunnable implements Runnable{
    @Override
    public void run() {
        log.info("实现 Runnable 的子线程:{}",Thread.currentThread().getName());
    }
}
