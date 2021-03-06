package ua.burdyga.spring_data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.burdyga.spring_data.dao.HibernateDaoImpl;

public class JdbcDemo {

    public static void main(String[] args) {
//        JdbcDaoImpl dao = new JdbcDaoImpl();
//        Circle circle = dao.getCircle(1);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ua/burdyga/spring_data/resources/spring.xml");
//        SpringDaoImpl dao = ctx.getBean("springDaoImpl", SpringDaoImpl.class);

//        Circle circle = dao.getCircle(1);
//        System.out.println(circle.getName());

//        dao.insertCircle(new Circle(5, "Fifth Circle"));
//        System.out.println(dao.getAllCircles().size());

//        dao.createTriangleTable();

//        SimpleJdbcDaoImpl dao= ctx.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
//        System.out.println(dao.getCircleCount());

        HibernateDaoImpl dao= ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
        System.out.println(dao.getCircleCount());

    }
}
