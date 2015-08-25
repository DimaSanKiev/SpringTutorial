package ua.burdyga.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import ua.burdyga.spring_aop.model.Circle;

@Aspect
public class LoggingAspect {

    @Before(value = "allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint) {
        Circle circle = (Circle) joinPoint.getTarget();
        System.out.println(circle);
    }

    @Before("args(name)")
    public void stringArgumentMethods(String name) {
        System.out.println("A method that takes String arguments has been called. Name is: " + name);
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
