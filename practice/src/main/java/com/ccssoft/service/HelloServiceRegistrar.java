package com.ccssoft.service;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: kermit
 * @date: 2020/10/12/5:52
 */
public class HelloServiceRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(
      AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

    BeanDefinitionBuilder beanDefinitionBuilder =
        BeanDefinitionBuilder.genericBeanDefinition(HelloFactoryBean.class);
    beanDefinitionBuilder.addPropertyValue("targetInterface", HelloService.class);
    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
    registry.registerBeanDefinition("helloService", beanDefinition);
  }
}
