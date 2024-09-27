package com.atguigu.ioc_02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) //单例,默认值
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例
@Component
public class BeanOne {

  @PostConstruct  //注解 指定初始化方法
  public void init() {
    // 初始化逻辑
    System.out.println("初始化");
  }

  @PreDestroy //注解 指定销毁方法
  //多例情况下销毁对象不调用销毁方法
  public void cleanup() {
    // 释放资源逻辑
    System.out.println("销毁");
  }
}