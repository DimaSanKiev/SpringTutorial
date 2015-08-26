package ua.burdyga.spring_data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.burdyga.spring_data.dao.SpringDaoImpl;
import ua.burdyga.spring_data.model.Circle;

public class JdbcDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ua/burdyga/spring_data/resources/spring.xml");
        SpringDaoImpl dao = ctx.getBean("springDaoImpl", SpringDaoImpl.class);

        Circle circle = dao.getCircle(1);
        System.out.println(circle.getName());
    }
}
