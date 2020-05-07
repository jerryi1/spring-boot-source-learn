package com.lhq.boot.demo.stop_watch;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * 这边是一个启动观察器，观察的是数据的开始到结束。
 */
public class StopWatchTest {

    /**
     * 启停器的测试(在一个stopWatch启动的时候，是没办法停止的。)
     */
    @Test
    public void stopWatchTest() {

        StopWatch stopwatch = new StopWatch("1");
        stopwatch.setKeepTaskList(true);
        new Thread(() -> {
            stopwatch.start("defaultTask");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopwatch.stop();
        }).run();

        new Thread(() -> {
            stopwatch.start("simpleTask");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopwatch.stop();
        }).run();
        System.out.println(stopwatch.prettyPrint());
    }
}
