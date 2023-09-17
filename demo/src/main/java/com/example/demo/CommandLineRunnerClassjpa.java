package com.example.demo;

import com.example.demo.SpringJpa.SpringJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerClassjpa implements CommandLineRunner {
    @Autowired
    private SpringJpaRepository springJpaRepository;

    @Override
    public void run(String... args) {
        springJpaRepository.insert(new Course(1, "learn java", "salman"));
        springJpaRepository.insert(new Course(2, "learn spring", "salman1"));
        springJpaRepository.insert(new Course(3, "learn spring boot", "salman2"));
        springJpaRepository.deleteById(1);

        System.out.println(springJpaRepository.getById(3));
        System.out.println(springJpaRepository.getById(2));

    }
}
