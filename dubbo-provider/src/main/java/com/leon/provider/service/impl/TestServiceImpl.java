package com.leon.provider.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.leon.api.service.TestService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TestServiceImpl
 * @author
 * @date
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }

}
