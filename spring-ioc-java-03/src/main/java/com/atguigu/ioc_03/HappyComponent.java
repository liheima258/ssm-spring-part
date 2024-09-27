package com.atguigu.ioc_03;

public class HappyComponent {
    //引用新组件
    private HappyMachine happyMachine;

    public HappyMachine getHappyMachine() {
        return happyMachine;
    }

    public void setHappyMachine(HappyMachine happyMachine) {
        this.happyMachine = happyMachine;
    }

    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }

    @Override
    public String toString() {
        return "HappyComponent{" +
                "happyMachine=" + happyMachine +
                '}';
    }
}