package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 功能：学习aop的使用==> 切面 === 代理 在其内部方法中写增强代码(非核心代码)
 * 日期：2024/7/1313:37
 */
@Configuration
@ComponentScan(value = "com.atguigu")
// 允许aspect的注释生效
@EnableAspectJAutoProxy
public class MyConfig {
}
