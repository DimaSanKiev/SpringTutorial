package ua.burdyga.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Before(value = "allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
//        Circle circle = (Circle) joinPoint.getTarget();
//        System.out.println(circle);
    }

    @AfterReturning(pointcut = "args(name)", returning = "returnString")
    public void stringArgumentMethods(String name, Object returnString) {
        System.out.println("A method that takes String arguments has been called. Value is: " + name + ". The output value is: " + returnString);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void exceptionAdvice(String name, Exception ex) {
        System.out.println("An exception has been thrown " + ex);
    }

    /*@Before("allGetters()")
    public void secondAdvice() {
        System.out.println("Second advice executed");
    }*/

    @Pointcut(value = "execution(* get*())")
    public void allGetters() {
    }

    @Pointcut(value = "within(ua.burdyga.spring_aop.model.Circle)")
    public void allCircleMethods() {
    }

}
