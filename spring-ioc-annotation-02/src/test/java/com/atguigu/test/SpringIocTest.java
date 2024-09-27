package com.atguigu.test;

import com.atguigu.ioc_01.CommonComponent;
import com.atguigu.ioc_02.BeanOne;
import com.atguigu.ioc_03.SoldierController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能：
 * 日期：2024/7/816:48
 */
public class SpringIocTest {

    @Test
    //测试注解配置方式
    public void test_01() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-01.xml");
        System.out.println("bean = " + context.getBean(CommonComponent.class));
    }

    @Test
    //测试周期方法和作用域
    public void test_02() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-02.xml");
        BeanOne bean = context.getBean(BeanOne.class);
        BeanOne bean1 = context.getBean(BeanOne.class);
        System.out.println(bean == bean1);
        context.close();
    }

    @Test
    //测试di配置===>@Autowired  @Qualifie  @Resource
    public void test_03() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-03.xml");
        SoldierController soldierController = context.getBean(SoldierController.class);
        soldierController.show();
    }
}
