package com.project.springandreact;

import com.project.springandreact.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringandreactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringandreactApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
    }

}
