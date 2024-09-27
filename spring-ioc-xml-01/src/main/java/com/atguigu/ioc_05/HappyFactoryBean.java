package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/*
    当容器看到对应类里实现了FactoryBean接口，就会执行这个类里的getObject方法，然后创建getObject方法返回的对象
    为什么要有FactoryBean接口？
    因为有些时候我们实例化对象的过程并不简单是一个new与赋值的操作，可能涉及许多步骤，因此就可以把这些步骤写在实现了FactoryBean接口的工厂类里

    xxxFactoryBean 是 Spring 中一种特殊的 bean，可以在 getObject() 工厂方法自定义的逻辑创建Bean！
    是一种能够生产其他 Bean 的 Bean。
    xxxFactoryBean 在容器启动时被创建，而在实际使用时则是通过调用 getObject() 方法来得到其所生产的 Bean。
    因此，FactoryBean 可以自定义任何所需的初始化逻辑，生产出一些定制化的 bean
 */


// 实现FactoryBean接口时需要指定泛型
// 泛型类型就是当前工厂要生产的对象的类型
public class HappyFactoryBean implements FactoryBean<HappyMachine> {
    
    private String machineName;

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
    
    @Override
    public HappyMachine getObject() throws Exception {
    
        // 方法内部模拟创建、设置一个对象的复杂过程
        HappyMachine happyMachine = new HappyMachine();
    
        happyMachine.setMachineName(this.machineName);
    
        return happyMachine;
    }

    @Override
    public Class<?> getObjectType() {

        // 返回要生产的对象的类型
        return HappyMachine.class;
    }
}