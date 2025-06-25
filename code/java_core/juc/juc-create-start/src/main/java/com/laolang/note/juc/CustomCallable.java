package com.laolang.note.juc;

import java.util.concurrent.Callable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int ret = 1;
        log.info("实现 Callable 的子线程:{}, 返回值为:{}", Thread.currentThread().getName(), 1);
        return ret;
    }
}
