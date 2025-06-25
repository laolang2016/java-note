# 多线程基础

## 创建并启动一个线程

### 继承 Thread

```java linenums="1"
package com.laolang.note.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomThread extends Thread {

    @Override
    public void run() {
        log.info("继承 Thread 的子线程:{}", getName());
    }
}
```

### 实现 Runnable 接口

```java linenums="1"
package com.laolang.note.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomRunnable implements Runnable{
    @Override
    public void run() {
        log.info("实现 Runnable 的子线程:{}",Thread.currentThread().getName());
    }
}
```

### 实现 Callable 接口

```java linenums="1"
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
```


**启动类**

```java linenums="1"
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
```