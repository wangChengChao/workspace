package com.ccssoft.multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * {@link BlockingQueue}
 *
 * @see #main(String[])
 * @author: kermit
 * @date: 2020/8/22/15:27
 */
public class App1 {

  static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

  static ExecutorService executorService =
      new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 1000; i++) {

      executorService.submit(
          () -> {
            try {
              queue.put(11);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          });
    }
    executorService.shutdown();
    executorService.awaitTermination(10, TimeUnit.SECONDS);
    System.out.println(queue.size());
  }
}
