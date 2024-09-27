package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 功能：学习aop==>基本使用
 * 日期：2024/7/1313:37
 */

// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
// Order的值决定切面的执行顺序 ==> Order值越小的切面优先级越高，即先执行Order值小的切面的before（因此会后执行Order值小的切面的after）
// 即优先级高的切面包裹住优先级低的切面
@Order(24)
public class LogAspect {

    // 切入点表达式重用==>方法一:同一类内部引用（如下列declarPointCut） 方法二：定义外部类（如AtguiguPointCut类）
    // 注意：提取切点注解使用@Pointcut(切点表达式) ， 需要添加到一个无参数无返回值方法上即可！
    @Pointcut("execution(public int com.atguigu.service.impl.CalculatorPureImpl.add(int,int))")
    public void declarPointCut() {}
        
    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    @Before(value = "declarPointCut()")
    public void printLogBeforeCore() {
        System.out.println("[AOP前置通知] 方法开始了");
    }
    
    @AfterReturning(value = "declarPointCut()")
    public void printLogAfterSuccess() {
        System.out.println("[AOP返回通知] 方法成功返回了");
    }
    
    @AfterThrowing(value = "com.atguigu.PointCut.AtguiguPointCut.atguiguPointCut()")
    public void printLogAfterException() {
        System.out.println("[AOP异常通知] 方法抛异常了");
    }
    
    @After(value = "com.atguigu.PointCut.AtguiguPointCut.atguiguPointCut()")
    public void printLogFinallyEnd() {
        System.out.println("[AOP后置通知] 方法最终结束了");
    }

    /*
        切点表达式总结
            第一位：execution( ) 固定开头
            第二位：方法访问修饰符
            public private 直接描述对应修饰符即可
            第三位：方法返回值
            int String void 直接描述返回值类型
            注意：
            特殊情况 不考虑 访问修饰符和返回值
            execution(* * ) 这是错误语法
            execution(*) == 你只要不考虑返回值 或者 不考虑访问修饰符 相当于全部不考虑了
            第四位：指定包的地址
             固定的包: com.atguigu.api | service | dao
             单层的任意命名: com.atguigu.*  = com.atguigu.api  com.atguigu.dao   * = 任意一层的任意命名
             任意层任意命名: com.. = com.atguigu.api.erdaye com.a.a.a.a.a.a.a    ..任意层,任意命名 用在包上!
             注意: ..不能用作包开头   public int .. 错误语法  com..
             找到任何包下: *..
            第五位：指定类名称
            固定名称: UserService
            任意类名: *
            部分任意: com..service.impl.*Impl
            任意包任意类: *..*
            第六位：指定方法名称
            语法和类名一致
            任意访问修饰符,任意类的任意方法: * *..*.*
            第七位：方法名
            第八位: 方法的参数描述
                   具体值: (String,int) != (int,String) 没有参数 ()
                   模糊值: 任意参数 (..)  ..任意参数的意识
                   部分具体和模糊:
                     第一个参数是字符串的方法 (String..)
                     最后一个参数是字符串 (..String)
                     字符串开头,int结尾 (String..int)
                     包含int类型(..int..)
     */
    
}