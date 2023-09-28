package com.aop.Dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public void addAccount(){
        System.out.println("saving data to database");
    }
}
