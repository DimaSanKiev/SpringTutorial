package ua.burdyga.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Before("allGetters()")
    public void loggingAdvice() {
        System.out.println("Advice run. Get method called");
    }

    @Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second advice executed");
    }

    @Pointcut("execution(* get*())")
    public void allGetters() {
    }
}
