package com.atguigu.config;

import com.atguigu.ioc_02.BeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * 功能：学习@bean的拓展===>作用域、周期方法、bean id 重命名
 * 日期：2024/7/1014:12
 */

@Configuration
@ComponentScan({"com.atguigu.ioc_02"})
public class MyConfig2 {


    @Bean(value = "ttt",initMethod = "init",destroyMethod = "cleanup")
    @Scope("singleton") //默认为单例 singleton 多例是 prototype
    public BeanOne beanOne() {
        return new BeanOne();
    }


}
