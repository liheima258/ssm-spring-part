package com.atguigu.test;

import com.atguigu.config.MyConfig3;
import com.atguigu.config.MyConfiguration;
import com.atguigu.config.MyConfig2;
import com.atguigu.ioc_01.UserController;
import com.atguigu.ioc_02.BeanOne;
import com.atguigu.ioc_03.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能：
 * 日期：2024/7/1013:27
 */
public class SpringIoTest {

    @Test
    //测试java配置类的使用
    public void test_01(){
        //方式一：
        ApplicationContext iocContainerAnnotation =
                new AnnotationConfigApplicationContext(MyConfiguration.class);
        UserController bean = iocContainerAnnotation.getBean(UserController.class);
        bean.show();
        /*
             方式二：
             ApplicationContext iocContainerAnnotation =
                new AnnotationConfigApplicationContext();
             iocContainerAnnotation.register(MyConfiguration.class);
             iocContainerAnnotation.refresh();
         */
    }

    @Test
    //测试@bean的拓展===>作用域、周期方法、bean id 重命名
    public void test_02(){
        AnnotationConfigApplicationContext iocContainerAnnotation =
                new AnnotationConfigApplicationContext(MyConfig2.class);
        iocContainerAnnotation.getBean("ttt", BeanOne.class);
        iocContainerAnnotation.close();
    }

    @Test
    //测试@bean的拓展===>bean之间的依赖（调用）
    public void test_03(){
        AnnotationConfigApplicationContext iocContainerAnnotation =
                new AnnotationConfigApplicationContext(MyConfig3.class);
        HappyComponent bean = iocContainerAnnotation.getBean("happyComponent",HappyComponent.class);
        HappyComponent bean2 = iocContainerAnnotation.getBean("happyComponent2",HappyComponent.class);
        System.out.println(bean);
        System.out.println(bean2);
    }
}
