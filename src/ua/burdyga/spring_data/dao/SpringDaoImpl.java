package ua.burdyga.spring_data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import ua.burdyga.spring_data.model.Circle;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SpringDaoImpl {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public int getCircleCount() {
        String sql = "SELECT COUNT(*) FROM circle";
        return jdbcTemplate.queryForInt(sql);
    }

    public String getCircleName(int circleId) {
        String sql = "SELECT name FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
    }

    public Circle getCircleForId(int circleId) {
        String sql = "SELECT * FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
    }

    public List<Circle> getAllCircles() {
        String sql = "SELECT * FROM circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

    /*public void insertCircle(Circle circle) {
        String sql = "INSERT INTO circle (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, circle.getId(), circle.getName());
    }*/

    public void insertCircle(Circle circle) {
        String sql = "INSERT INTO circle (id, name) VALUES (:id, :name)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void createTriangleTable() {
        String sql = "CREATE TABLE triangle (id INTEGER, name VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("id"));
            circle.setName(resultSet.getString("name"));
            return circle;
        }
    }
}
