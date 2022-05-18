package ru.rtu_mirea.practice_22.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
@Slf4j
public class ServiceAspect {

    @Around("ru.rtu_mirea.practice_21.aop.Pointcuts.servicesMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object retval = joinPoint.proceed();
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        log.info("Execution of " + methodName + " took " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return retval;
    }
}
