package ua.burdyga.spring_data.dao;

import ua.burdyga.spring_data.model.Circle;

import java.sql.*;

public class JdbcDaoImpl {

    public Circle getCircle(int circleId) {
        Connection conn = null;

        try {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection("jdbc:derby:SpringDB");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM CIRCLE WHERE ID= ?");
            ps.setInt(1, circleId);

            Circle circle = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();
            return circle;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert conn != null;
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
