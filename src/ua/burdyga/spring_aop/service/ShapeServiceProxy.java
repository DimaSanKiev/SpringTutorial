package ua.burdyga.spring_aop.service;

import ua.burdyga.spring_aop.aspect.LoggingAspectXml;
import ua.burdyga.spring_aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

    @Override
    public Circle getCircle() {
        new LoggingAspectXml().loggingAdvice();
        return super.getCircle();
    }
}
