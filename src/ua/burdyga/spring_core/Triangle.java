package ua.burdyga.spring_core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

public class Triangle implements Shape, InitializingBean, DisposableBean {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext context = null;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
        System.out.println("Point A = (" + getPointA().getX() + ", " + getPointA().getY() + ")");
        System.out.println("Point B = (" + getPointB().getX() + ", " + getPointB().getY() + ")");
        System.out.println("Point C = (" + getPointC().getX() + ", " + getPointC().getY() + ")");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeans init method called for Triangle");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBeans destroy method called for the Triangle");
    }

    public void myInit() {
        System.out.println("My init method called for Triangle");
    }

    public void cleanUp() {
        System.out.println("My cleanup method called for the Triangle");
    }
}
