package ua.burdyga.spring_data;

import ua.burdyga.spring_data.dao.JdbcDaoImpl;
import ua.burdyga.spring_data.model.Circle;

public class JdbcDemo {

    public static void main(String[] args) {
        Circle circle = new JdbcDaoImpl().getCircle(1);
        System.out.println(circle.getName());
    }
}
