package com.atguigu.test;


import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_05.HappyFactoryBean;
import com.atguigu.ioc_05.HappyMachine;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：创建IoC容器对象，读取配置文件，实例化组件
 * 日期：2024/7/6/15:40
 */
public class SpringIoTest {

    //创建IoC容器对象，读取配置文件
    public void creatIoc(){
        //方式1:实例化并且指定配置文件
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean-03.xml");
        /*
            方式2:先实例化，再指定配置文件，最后刷新容器触发Bean实例化动作
                ClassPathXmlApplicationContext context =
                        new ClassPathXmlApplicationContext();
            context.setConfigLocations(".xml",".xml");
            context.refresh();
         */
    }

    //Bean对象读取
    @Test
    public void getBeanFormIoc(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean-03.xml");
        //方式1: 根据id获取,没有指定类型,返回为Object,需要类型转化!
        HappyComponent happyComponent1 =
                (HappyComponent) context.getBean("happyComponent");
        happyComponent1.doWork();

        //方式2: 根据类型获取
        //根据类型获取,但是同类型只能有一个对象交给IoC容器管理
        //配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
        HappyComponent happyComponent2 = context.getBean(HappyComponent.class);
        happyComponent2.doWork();

        //方式3: 根据id和类型获取
        HappyComponent happyComponent3 = context.getBean("happyComponent", HappyComponent.class);
        happyComponent3.doWork();
    }


    @Test
    //测试周期方法
    public void test_04(){
        //注意：(当scope值为默认值 单例 时)，创建完ioc对象，就会实例化组件,就会触发init方法
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean-04.xml");
        context.close();
    }

    @Test
    //测试FactoryBean接口
    public void test_05(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean-05.xml");
        System.out.println("bean = "+context.getBean("happyMachine", HappyMachine.class));
        //如果想要获取FactoryBean对象, 直接在id前添加&符号即可!  例如&happyMachine 这是一种固定的约束
        HappyFactoryBean bean = context.getBean("&happyMachine", HappyFactoryBean.class);
        System.out.println("bean = " + bean);
    }
}
