package com.eyalmiz.password_manager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PasswordManagerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PasswordManagerApplication.class, args);
        Object data = context.getBean("dataSource");
        System.out.println(data);
    }

}
