package com.ccssoft.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: kermit
 * @date: 2020/8/24/18:23
 */
public class App {
  static volatile int i = 1;

  static Lock lock = new ReentrantLock();
  static Condition c1 = lock.newCondition();
  static Condition c2 = lock.newCondition();
  static Condition c3 = lock.newCondition();

  public static void main(String[] args) throws Exception {
    new Thread(new Task1(), "T1").start();
    TimeUnit.SECONDS.sleep(1);
    new Thread(new Task2(), "T2").start();
    new Thread(new Task3(), "T3").start();
  }

  private static class Task1 implements Runnable {

    @Override
    public void run() {
      lock.lock();
      try {
        while (i <= 100) {

          System.out.println(Thread.currentThread().getName() + "--" + i++);

          c2.signal();
          c1.await();
        }
        c2.signal();
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  private static class Task2 implements Runnable {

    @Override
    public void run() {
      lock.lock();
      try {
        while (i <= 100) {
          System.out.println(Thread.currentThread().getName() + "--" + i++);

          c3.signal();
          c2.await();
        }
        c3.signal();
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  private static class Task3 implements Runnable {

    @Override
    public void run() {
      lock.lock();
      try {
        while (i <= 100) {
          System.out.println(Thread.currentThread().getName() + "--" + i++);

          c1.signal();
          c3.await();
        }
        c1.signal();
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }
}
