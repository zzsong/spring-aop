package com.zss.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppAspect {

    /**
     * execution ： 用于指定方法的执行
     * 表达式：execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
     *     修饰符匹配（modifier-pattern?）
     *     返回值匹配（ret-type-pattern）可以为*表示任何返回值,全路径的类名等
     *     类路径匹配（declaring-type-pattern?）
     *     方法名匹配（name-pattern）可以指定方法名 或者 代表所有, set 代表以set开头的所有方法
     *     参数匹配（(param-pattern)）可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用“”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型；可以用(…)表示零个或多个任意参数
     *     异常类型匹配（throws-pattern?）
     *     其中后面跟着“?”的是可选项
     */
    /**
     * bean： 这是Spring增加的一种方法，spring独有
     *
     * bean用于匹配当调用的是指定的Spring的某个bean的方法时。
     *  1、“bean(abc)”匹配Spring Bean容器中id或name为abc的bean的方法调用。
     *  2、“bean(user*)”匹配所有id或name为以user开头的bean的方法调用。
     *
     */

    /**
     * 类型匹配语法
     *
     * *：匹配任何数量字符；
     *  …：匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数。
     *  +：匹配指定类型的子类型；仅能作为后缀放在类型模式后边。
     */

    /**
     * 正常是可以代理父类子类方法调用
     * 代理以analysis开头的方法
     */
    @Pointcut("execution(* analysis*(..))")
    public void cutAnalysis(){
        //内部方法调用，增强失败，代理上下文，强行使用代理来调用
        //解决方案：@EnableAspectJAutoProxy(exposeProxy = true)
        // ((IModelService) AopContext.currentProxy()).analysis(reportDate, 1);
    };

    @Before("cutAnalysis()")
    public void beforeAnalysis(JoinPoint jp){
        String clazzName = jp.getTarget().getClass().getSimpleName();
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        String method = methodSignature.getMethod().getName();

        System.out.println("************aspect====>"+clazzName+"===method=>"+method);
    }
}
