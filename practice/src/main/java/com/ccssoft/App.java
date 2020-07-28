package com.ccssoft;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: kermit
 * @date: 2020/7/28/8:07
 */
public class App {

  public static void main(String[] args) throws InterruptedException{
  
    CompletableFuture.supplyAsync(
        () -> {
          try {
            TimeUnit.SECONDS.sleep(4);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("异步执行");
          return "OK";
        })
        .thenAccept(
            ret -> {
              System.out.println(ret);
            });
    Thread.currentThread().join();
  }
}
