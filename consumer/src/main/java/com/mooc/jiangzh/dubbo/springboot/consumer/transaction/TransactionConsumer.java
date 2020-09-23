package com.mooc.jiangzh.dubbo.springboot.consumer.transaction;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mooc.jiangzh.dubbo.springboot.ServiceAPI;
import com.mooc.jiangzh.dubbo.springboot.ServiceAPI2;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    @Autowired
    ServiceAPI serviceAPI;

    @Autowired
    ServiceAPI2 serviceAPI2;

    @Compensable(confirmMethod = "confirmSendMessage", cancelMethod = "cancelSendMessage", asyncConfirm = true)
    public void sendMessage(String message){
        System.out.println("开始执行主业务");
        System.out.println("this is consumer sendMessage message="+message);
//
//        System.out.println(serviceAPI.sendMessage(message));
        System.out.println("开始执行多个子业务");

        // 测试业务
        serviceAPI.saveOrder("001",message,"5");

        serviceAPI2.saveOrder("001",message,"5");

        throw new RuntimeException("test");

    }

    public void confirmSendMessage(String message){
        System.out.println("this is consumer confirmSendMessage message="+message);
//        System.out.println(serviceAPI.sendMessage(message));
    }

    public void cancelSendMessage(String message){
        System.out.println("this is consumer cancelSendMessage message="+message);
//        System.out.println(serviceAPI.sendMessage(message));
    }
}
