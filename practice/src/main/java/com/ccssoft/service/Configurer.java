package com.ccssoft.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: kermit
 * @date: 2020/10/12/5:42
 */
@Configuration
@Import(HelloServiceRegistrar.class)
@ComponentScan(value = {"com.ccssoft.service"})
public class Configurer {}
