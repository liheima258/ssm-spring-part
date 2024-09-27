package com.atguigu.config;

import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_03.HappyMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：学习@bean的拓展===>bean之间的依赖（调用）
 * 日期：2024/7/1014:23
 */

@Configuration
@ComponentScan({"com.atguigu.ioc_03"})
public class MyConfig3 {


    @Bean
    public HappyMachine happyMachine(){
        return new HappyMachine();
    }

    /*
       方案1：直接调用方法返回 Bean 实例
       在一个 @Bean 方法中直接调用其他 @Bean 方法来获取 Bean 实例，虽然是方法调用，也是通过IoC容器获取对应的Bean
    */

    @Bean
    public HappyComponent happyComponent(){
        HappyComponent happyComponent = new HappyComponent();
        //直接调用方法即可!
        happyComponent.setHappyMachine(happyMachine());
        return happyComponent;
    }

    /*
        方案2：通过方法参数传递 Bean 实例的引用来解决 Bean 实例之间的依赖关系
     */
    /**
     * 可以直接在形参列表接收IoC容器中的Bean!
     *    情况1: 如果要接收的bean只有一个，直接指定类型即可
     *    情况2: 如果有多个bean,(HappyMachine 形参名称 ) 形参名称需等于要指定的bean名称!
     *           例如:
     *               @Bean
     *               public Foo foo1(){
     *                   return new Foo();
     *               }
     *               @Bean
     *               public Foo foo2(){
     *                   return new Foo()
     *               }
     *               @Bean
     *               public Component component(Foo foo1 / foo2 通过此处指定引入的bean)
     */
    @Bean
    public HappyComponent happyComponent2(HappyMachine happyMachine){
        HappyComponent happyComponent = new HappyComponent();
        //赋值
        happyComponent.setHappyMachine(happyMachine);
        return happyComponent;
    }
}
