package ua.burdyga.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point center;
    private ApplicationEventPublisher publisher;
    @Autowired
    private MessageSource messageSource;

    public Point getCenter() {
        return center;
    }

    @Autowired
    @Qualifier("circleRelated")
    @Resource(name = "pointC")
    public void setCenter(Point center) {
        this.center = center;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "Default Point Message", null));
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostConstruct
    public void initializeCircle() {
        System.out.println("Init of Circle");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Destroy of Circle");
    }
}