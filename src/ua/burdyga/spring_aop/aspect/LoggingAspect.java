package ua.burdyga.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Before(value = "allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
//        Circle circle = (Circle) joinPoint.getTarget();
//        System.out.println(circle);
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnString", argNames = "name, returnString")
    public void stringArgumentMethods(String name, Object returnString) {
        System.out.println("A method that takes String arguments has been called. Value is: " + name + ". The output value is: " + returnString);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void exceptionAdvice(String name, Exception ex) {
        System.out.println("An exception has been thrown " + ex);
    }

    @Around("@annotation(ua.burdyga.spring_aop.aspect.Loggable)")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue = null;

        try {
            System.out.println("Before advice");
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("After returning");
        } catch (Throwable throwable) {
            System.out.println("After throwing");
        }

        System.out.println("After finally");
        return returnValue;
    }

    /*@Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second advice executed");
    }*/

    @Pointcut(value = "execution(* get*())")
    public void allGetters() {
    }

    @Pointcut(value = "execution(* ua.burdyga.spring_aop.service.*Service.*(..))")
    public void allServiceClasses() {
    }

    @Pointcut(value = "within(ua.burdyga.spring_aop.model.Circle)")
    public void allCircleMethods() {
    }

}
