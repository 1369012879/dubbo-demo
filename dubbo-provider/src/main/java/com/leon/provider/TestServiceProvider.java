package com.leon.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestServiceProvider {

    private static final Logger LOG = LoggerFactory.getLogger(TestServiceProvider.class);

    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-mvc.xml"});
        context.start();
        try {
            LOG.info("testService provider");
            // 按任意键退出
            System.in.read();
        } catch (IOException e){
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
