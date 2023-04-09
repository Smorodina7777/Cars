package org.example;

import org.example.dao.InstanceDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        InstanceDao instanceDao = context.getBean(InstanceDao.class);


    }
}
