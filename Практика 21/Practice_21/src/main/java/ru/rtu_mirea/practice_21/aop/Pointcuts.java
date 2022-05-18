package ru.rtu_mirea.practice_21.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.rtu_mirea.practice_21.service.*.*(..))")
    public void servicesMethods(){}

}