package com.atguigu.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;



@Controller
/*
    使用@Autowire注解来实现di配置，实现依赖注入
    被@Autowire标志的成员变量
    会先被ioc容器查看变量的类型是什么
    然后去ioc容器内部找对应类型的组件（对象），赋值给变量
    但是
    当有多个实现类实现一个接口时（如下例）
    ioc容器会因为找到两个实现类，而报错
    这时就需要使用@Qualifier(value="") 或者  @Resource(name="") 指定bean的id给ioc容器 实现区分
 */
public class SoldierController {

    /*
         其实可以直接写实现类的 类型 来区分
         例如：private SoldierServiceImpl soldierService;
              private NewSoldierServiceImpl soldierService2;
         不过为了实现面向接口编程思想，这里统一写接口类型
         再通过  @Autowired+ @Qualifier(value="") 或者  @Resource(name="") 来区分
     */

    @Autowired
    @Qualifier(value = "soldierServiceImpl")
    private SoldierService soldierService;

    @Resource(name = "newSoldierServiceImpl")
    private SoldierService soldierService2;

    public void show() {
        soldierService.show();
        soldierService2.show();
    }
}