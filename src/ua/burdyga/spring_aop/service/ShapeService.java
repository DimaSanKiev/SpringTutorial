package ua.burdyga.spring_aop.service;

import ua.burdyga.spring_aop.aspect.Loggable;
import ua.burdyga.spring_aop.model.Circle;
import ua.burdyga.spring_aop.model.Triangle;

public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    @Loggable
    public Circle getCircle() {
        System.out.println("Circle getter called");
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
