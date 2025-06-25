package com.laolang.note.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomThread extends Thread {

    @Override
    public void run() {
        log.info("继承 Thread 的子线程:{}", getName());
    }
}
