package com.atguigu.test;

import com.atguigu.components.A;
import com.atguigu.components.B;
import com.atguigu.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 功能：测试spring5-test5的整合环境
 * 日期：2024/7/1210:52
 */

//@SpringJUnitConfig(locations = {"classpath:xxx.xml"})  //指定配置文件xml
@SpringJUnitConfig(value = {MyConfig.class})  //指定配置类
public class SpringIoTest {

    /*
        添加了SpringJUnitConfig注释的类，会帮你自动创建ioc容器对象，以及实例化对象放到容器内部
        这里可以直接用需要用的对象，只需加Autowired注释即可
     */
    @Autowired
    private A a;
    @Autowired
    private B b;

    @Test
    public void test(){
        a.show();
        b.show();
    }
}
