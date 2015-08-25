package ua.burdyga.spring_aop;

import ua.burdyga.spring_aop.service.FactoryService;
import ua.burdyga.spring_aop.service.ShapeService;

public class AopMain {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("ua/burdyga/spring_aop/resources/spring.xml");
//        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);

        FactoryService factoryService = new FactoryService();
        ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");

        shapeService.getCircle()/*.setName("Test name")*/;
    }

}
