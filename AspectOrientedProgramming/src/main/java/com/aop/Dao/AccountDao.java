package com.aop.Dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
    public String addAccount(int id, String name){
        System.out.println("saving data to database"+id+"..."+name);
        return id + "." + name;
    }

    public void deleteAccount(){
        System.out.println("deleting data from database");
    }

    public void removeAccount(){
        System.out.println("updating data in database");
    }
}
