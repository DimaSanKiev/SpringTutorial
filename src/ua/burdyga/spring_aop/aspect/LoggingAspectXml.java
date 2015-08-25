package ua.burdyga.spring_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspectXml {

    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Object returnValue = null;

        try {
            System.out.println("Before advice xml");
            returnValue = proceedingJoinPoint.proceed();
            System.out.println("After returning xml");
        } catch (Throwable throwable) {
            System.out.println("After throwing xml");
        }

        System.out.println("After finally xml");
        return returnValue;
    }

    public void loggingAdvice() {
        System.out.println("Logging from the advice");
    }

}
