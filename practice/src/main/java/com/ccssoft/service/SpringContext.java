package com.ccssoft.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: kermit
 * @date: 2020/10/12/5:31
 */
public class SpringContext {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(Configurer.class);
    HelloService helloService = context.getBean(HelloService.class);
    helloService.hello();
    helloService.say();
    context.close();
  }
}
