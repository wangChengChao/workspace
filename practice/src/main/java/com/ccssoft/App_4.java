package com.ccssoft;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: kermit
 * @date: 2020/7/31/17:05
 */
public class App_4 {

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
                    // throw new RuntimeException("运行出错");
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                  return 3;
                })
            .exceptionally(
                (ex) -> {
                  // 如果出错会触发这里的逻辑，否则不会走这里，返回正常值
                  ex.printStackTrace();
                  return null;
                })
            .thenAccept(System.out::println);

    CompletableFuture.allOf(f1, f2, f3).join();
    System.out.println("OK");
  }
}
