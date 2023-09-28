package com.aop.demoPackage;

import com.aop.Dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {
    public static void main(String[] args) {
       var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDao accountDao = context.getBean(AccountDao.class);
        accountDao.addAccount();
        System.out.println("\n" +
                "\n" +
                "\n" +
                "here we are clling addAccount method again" +
                "\n" +
                "\n");
        accountDao.addAccount();

        context.close();
    }
}
