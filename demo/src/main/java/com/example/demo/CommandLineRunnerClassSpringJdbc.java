package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerClassSpringJdbc implements CommandLineRunner {
    @Autowired
    private JdbcRepo jdbcRepo;

    @Override
    public void run(String... args) {
        jdbcRepo.insert(new Course(1, "learn java", "salman"));
        jdbcRepo.insert(new Course(2, "learn spring", "salman1"));
        jdbcRepo.insert(new Course(3, "learn spring boot", "salman2"));
        jdbcRepo.delete(1);
        jdbcRepo.updateById(2);
        System.out.println(jdbcRepo.getById(3));
        System.out.println(jdbcRepo.getById(2));

    }
}
