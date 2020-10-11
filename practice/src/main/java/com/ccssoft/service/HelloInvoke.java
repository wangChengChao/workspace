package com.ccssoft.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: kermit
 * @date: 2020/10/12/6:00
 */
public class HelloInvoke implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    System.out.println(
        this.getClass().getCanonicalName() + "====目标对象的方法(" + method.getName() + ")被调用");
    return 1;
  }
}
