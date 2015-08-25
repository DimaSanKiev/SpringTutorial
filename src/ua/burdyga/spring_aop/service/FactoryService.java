package ua.burdyga.spring_aop.service;

import ua.burdyga.spring_aop.model.Circle;
import ua.burdyga.spring_aop.model.Triangle;

public class FactoryService {

    public Object getBean(String beanType) {
        if (beanType.equals("shapeService")) return new ShapeServiceProxy();
        if (beanType.equals("circle")) return new Circle();
        if (beanType.equals("triangle")) return new Triangle();
        return null;
    }
}
