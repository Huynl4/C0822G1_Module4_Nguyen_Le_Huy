package com.example.exercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public aspect LogAspect {
    @Pointcut("within(com.example.exercise.*)")
    public void callMethod(){}

    @Before("callMethod()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("Đang vào phương thức" + joinPoint.getSignature().getName() + "Vào thời gian: "+ LocalDateTime.now());
    }
}
