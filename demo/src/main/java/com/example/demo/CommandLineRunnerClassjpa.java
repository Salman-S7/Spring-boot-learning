package com.example.demo;

import com.example.demo.SpringdataJpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerClassjpa implements CommandLineRunner {
    @Autowired
    private SpringDataJpaRepository springDataJpaRepository;

    @Override
    public void run(String... args) {
        springDataJpaRepository.save(new Course(1, "learn java", "salman"));
        springDataJpaRepository.save(new Course(2, "learn spring", "salman1"));
        springDataJpaRepository.save(new Course(3, "learn spring boot", "salman2"));
        springDataJpaRepository.deleteById(1l);

        System.out.println(springDataJpaRepository.findById(3l));
        System.out.println(springDataJpaRepository.findById(2l));
        System.out.println(springDataJpaRepository.findAll());
        System.out.println(springDataJpaRepository.findByName("learn spring"));

    }
}
