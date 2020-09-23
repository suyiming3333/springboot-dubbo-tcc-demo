package com.mooc.jiangzh.dubbo.springboot.privoder.quickstart;

import com.alibaba.dubbo.config.annotation.Service;
import com.mooc.jiangzh.dubbo.springboot.ServiceAPI;
import org.springframework.stereotype.Component;

//@Component
//@Service(interfaceClass = ServiceAPI.class)
public class QuickstartServiceImpl implements ServiceAPI {

    @Override
    public String sendMessage(String message) {
        return "quickstart-provider-message="+message;
    }

    @Override
    public boolean isTrueSeats(String seats) {
        return false;
    }

    @Override
    public boolean isNotSold(String seats) {
        return false;
    }

    @Override
    public String saveOrder(String fieldId, String seats, String seatsNum) {
        return null;
    }
}
