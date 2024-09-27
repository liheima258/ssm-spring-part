package com.atguigu.PointCut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 功能：将切点表达式统一存储到一个类中进行集中管理和维护！
 * 日期：2024/7/1313:37
 */

@Component
public class AtguiguPointCut {
    
    @Pointcut(value = "execution(public int com.atguigu.service.impl.CalculatorPureImpl.add(int,int))")
    public void atguiguPointCut(){}
}