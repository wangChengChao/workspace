package com.ccssoft;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: kermit
 * @date: 2020/7/31/16:59
 */
public class App_1 {

  public static void main(String[] args) {

    CompletableFuture<Void> f1 =
        CompletableFuture.supplyAsync(
                () -> {
                  try {
                    TimeUnit.SECONDS.sleep(3);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  return 1;
                })
            .thenAccept(
                ret -> {
                  System.out.println("f1->" + ret);
                });
    CompletableFuture<Void> f2 =
        CompletableFuture.supplyAsync(
                () -> {
                  try {
                    TimeUnit.SECONDS.sleep(4);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  return 2;
                })
            .thenAccept(
                ret -> {
                  System.out.println("f2->" + ret);
                });
    CompletableFuture<Void> f3 =
        CompletableFuture.supplyAsync(
                () -> {
                  try {
                    TimeUnit.SECONDS.sleep(5);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  return 3;
                })
            .thenAccept(
                ret -> {
                  System.out.println("f3->" + ret);
                });
    CompletableFuture.allOf(f1, f2, f3).join();
    System.out.println("OK");
  }
}
