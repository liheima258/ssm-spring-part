package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 功能：学习aop==>环绕通知
 * 日期：2024/7/1413:17
 */
@Component
@Aspect

// 环绕通知对应整个 try...catch...finally 结构，包括前面四种通知的所有功能。
public class AroundAspect {

    // 使用@Around注解标明环绕通知方法
    @Around(value = "execution(public int com.atguigu.service.impl.CalculatorPureImpl.sub(int,int))")
    public Object manageTransaction(

            // 通过在通知方法形参位置声明ProceedingJoinPoint类型的形参，
            // Spring会将这个类型的对象传给我们
            ProceedingJoinPoint joinPoint) {

        // 通过ProceedingJoinPoint对象获取外界调用目标方法时传入的实参数组
        Object[] args = joinPoint.getArgs();

        // 通过ProceedingJoinPoint对象获取目标方法的签名对象
        Signature signature = joinPoint.getSignature();

        // 通过签名对象获取目标方法的方法名
        String methodName = signature.getName();

        // 声明变量用来存储目标方法的返回值
        Object targetMethodReturnValue = null;

        try {

            // 在目标方法执行前：开启事务（模拟）
            System.out.println("[AOP 环绕通知] 开启事务，方法名：" + methodName + "，参数列表：" + Arrays.asList(args));

            // 通过ProceedingJoinPoint对象调用目标方法
            // 目标方法的返回值一定要返回给外界调用者
            targetMethodReturnValue = joinPoint.proceed(args);

            // 在目标方法成功返回后：提交事务（模拟）
            System.out.println("[AOP 环绕通知] 提交事务，方法名：" + methodName + "，方法返回值：" + targetMethodReturnValue);

        }catch (Throwable e){

            // 在目标方法抛异常后：回滚事务（模拟）
            System.out.println("[AOP 环绕通知] 回滚事务，方法名：" + methodName + "，异常：" + e.getClass().getName());

        }finally {

            // 在目标方法最终结束后：释放数据库连接
            System.out.println("[AOP 环绕通知] 释放数据库连接，方法名：" + methodName);

        }

        return targetMethodReturnValue;
    }
}
