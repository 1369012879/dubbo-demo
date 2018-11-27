package com.leon.consumer;

import com.leon.api.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * TestServiceConsumer 服务消费方
 *
 * @author leon
 * @date 2018/11/27
 */
public class TestServiceConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(TestServiceConsumer.class);

    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:spring-mvc.xml"});
        context.start();
        // get remote service proxy
        TestService testService = (TestService) context.getBean("testService");
        while (true){
            try {
                Thread.sleep(1000);
                LOG.info("testService consumer");
                // call remote method
                String hello = testService.sayHello("Leon");
                // get result
                System.out.println(hello);
            } catch (Throwable throwable){
                throwable.printStackTrace();
            }
        }
    }

}
