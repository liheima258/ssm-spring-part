package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 功能：学习aop==>在代理方法中获取目标方法（切点）的信息
 * 日期：2024/7/1313:37
 */

@Aspect
@Component
public class MyLogAspect {


    // 在前置通知方法形参位置声明一个JoinPoint类型的参数，Spring给这个JoinPoint对象赋值，这个对象就是目标方法对应的对象
    // 根据JoinPoint对象就可以获取目标方法名称、实际参数列表
    @Before(value = "execution(public int com.atguigu.service.impl.CalculatorPureImpl.mul(int,int))")
    public void printLogBeforeCore(JoinPoint joinPoint) {

        // 1.通过JoinPoint对象获取目标方法签名对象
        // 方法的签名对象：包含一个方法的全部声明信息
        Signature signature = joinPoint.getSignature();

        // 2.通过方法的签名对象获取目标方法的详细信息
        String methodName = signature.getName();    //方法名
        System.out.println("methodName = " + methodName);

        int modifiers = signature.getModifiers();    //修饰符
        System.out.println("modifiers = " + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();  //返回值类型
        System.out.println("declaringTypeName = " + declaringTypeName);

        // 3.通过JoinPoint对象获取外界调用目标方法时传入的实参列表
        Object[] args = joinPoint.getArgs();

        // 4.由于数组直接打印看不到具体数据，所以转换为List集合
        List<Object> argList = Arrays.asList(args);

        System.out.println("[AOP前置通知] " + methodName + "方法开始了，参数列表：" + argList);
    }


    // 返回值只能在AfterReturning中获取
    // 在返回通知中获取目标方法返回值分两步：
    // 第一步：在@AfterReturning注解中通过returning属性设置一个名称
    // 第二步：使用returning属性设置的名称在通知方法中声明一个对应的形参
    @AfterReturning(
            value = "execution(public int com.atguigu.service.impl.CalculatorPureImpl.mul(int,int))",
            returning = "targetMethodReturnValue"
    )
    public void printLogAfterCoreSuccess(JoinPoint joinPoint, Object targetMethodReturnValue) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP返回通知] "+methodName+"方法成功结束了，返回值是：" + targetMethodReturnValue);
    }


    // 在异常通知中获取目标方法抛出的异常分两步：
    // 第一步：在@AfterThrowing注解中声明一个throwing属性设定形参名称
    // 第二步：使用throwing属性指定的名称在通知方法声明形参，Spring会将目标方法抛出的异常对象从这里传给我们
    @AfterThrowing(
            value = "execution(public int com.atguigu.service.impl.CalculatorPureImpl.mul(int,int))",
            throwing = "targetMethodException"
    )
    public void printLogAfterCoreException(JoinPoint joinPoint, Throwable targetMethodException) {

        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP异常通知] "+methodName+"方法抛异常了，异常类型是：" + targetMethodException.getClass().getName());
    }
    
}