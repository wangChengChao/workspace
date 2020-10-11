package com.ccssoft.service;

/**
 * @author: kermit
 * @date: 2020/10/12/5:36
 */
// @Repository(不加注解.通过FactoryBean注册的HelloService,Spring容器获取HelloService的时候也可以获取到此对象的代理对象)
public interface HelloService {

  void hello();

  void say();
}
