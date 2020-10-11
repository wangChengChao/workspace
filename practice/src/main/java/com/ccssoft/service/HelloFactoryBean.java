package com.ccssoft.service;

import java.lang.reflect.Proxy;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: kermit
 * @date: 2020/10/12/5:37
 */
public class HelloFactoryBean<T> implements FactoryBean<T> {

  private Class<T> targetInterface;

  public HelloFactoryBean() {}

  @Override
  public T getObject() throws Exception {
    return (T)
        Proxy.newProxyInstance(
            targetInterface.getClassLoader(), new Class[] {targetInterface}, new HelloInvoke());
  }

  @Override
  public Class<T> getObjectType() {
    return this.targetInterface;
  }

  public Class<T> getTargetInterface() {
    return targetInterface;
  }

  public void setTargetInterface(Class<T> targetInterface) {
    this.targetInterface = targetInterface;
  }
}
