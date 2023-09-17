package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepo {
    private static String INSERT_QUERY = """
            INSERT INTO courses(id,name,author) 
            values(?,?,?);
            """;
    private static String DELETE_QUERY = """
            delete from courses where id = ?;
            """;
    private static String GET_QUERY = """
            select * from courses where id = ?;
            """;
    private static String UPDATE_QUERY = """
            update courses set name = ? , author = ? where id = ?;
            """;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(int id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course getById(int id) {
        Course course = null;
        try {
            course = jdbcTemplate.queryForObject(GET_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return course;

    }

    /**
     * @param id
     */
    public void updateById(int id) {
        jdbcTemplate.update(UPDATE_QUERY, "learn ai and ml", "salman shaikh", id);
    }


}
