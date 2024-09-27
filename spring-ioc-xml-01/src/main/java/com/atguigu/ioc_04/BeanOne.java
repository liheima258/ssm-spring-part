package com.atguigu.ioc_04;


/*
    ioc容器的周期方法:
    我们可以在组件类中定义方法，然后当IoC容器实例化和销毁组件对象的时候进行调用！这两个方法我们称为生命周期方法！
    类似于Servlet的init/destroy方法,我们可以在周期方法完成初始化和释放资源等工作。
 */
public class BeanOne {

    //周期方法要求： 方法命名随意，但是要求方法必须是 public void 无形参列表
    public void init() {
        // 初始化逻辑
        System.out.println("hello init!");
    }

    public void clear() {
        // 初始化逻辑
        System.out.println("hello clear!");
    }
}