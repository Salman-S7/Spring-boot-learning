package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerClassSpringJdbc implements CommandLineRunner {
    @Autowired
    private JdbcRepo jdbcRepo;
    @Override
    public void run(String... args) throws Exception {
        jdbcRepo.insert();
    }
}
