package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepo {
    private static String INSERT_QUERY = """
            INSERT INTO courses(id,name,author) 
            values(1,'learn spring boot', 'salman');
            """;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }


}
