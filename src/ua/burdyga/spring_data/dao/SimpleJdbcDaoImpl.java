package ua.burdyga.spring_data.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

    public int getCircleCount() {
        String sql = "SELECT COUNT(*) FROM circle";
        return this.getJdbcTemplate().queryForInt(sql);
    }
}
