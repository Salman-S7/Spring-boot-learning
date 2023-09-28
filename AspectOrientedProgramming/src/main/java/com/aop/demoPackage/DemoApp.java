package com.aop.demoPackage;

import com.aop.Dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApp {
    public static void main(String[] args) {
       var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDao accountDao = context.getBean(AccountDao.class);
        accountDao.addAccount(1,"salman");
        accountDao.deleteAccount();
        accountDao.removeAccount();

        context.close();
    }
}
