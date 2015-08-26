package ua.burdyga.spring_data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.burdyga.spring_data.model.Circle;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class SpringDaoImpl {

    @Autowired
    private DataSource dataSource;

    public Circle getCircle(int circleId) {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();

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

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
