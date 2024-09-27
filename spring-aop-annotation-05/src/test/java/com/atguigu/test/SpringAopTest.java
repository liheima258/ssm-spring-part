package com.atguigu.test;

import com.atguigu.config.MyConfig;
import com.atguigu.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能：测试
 * 日期：2024/7/1313:40
 */
@SpringJUnitConfig(value = MyConfig.class)
public class SpringAopTest {


    /*
    a.  如果目标类有接口,系统会选择使用jdk动态代理
    b.  如果目标类没有接口,系统会选择cglib动态代理
    c.  如果有接口,接口接值
    d.  如果没有接口,类进行接值
    */
    @Autowired
    private Calculator calculator;

    @Test
    //测试aop==>基本使用
    public void test(){
        int add = calculator.add(1, 1);
        System.out.println(add);
    }

    @Test
    //测试aop==>在代理方法中获取目标方法（切点）的信息
    public void test_2(){
        int mul = calculator.mul(1, 2);
        System.out.println(mul);
    }

    @Test
    //测试aop==>环绕通知
    public void test_3(){
        int sub = calculator.sub(3, 2);
        System.out.println(sub);
    }
}
