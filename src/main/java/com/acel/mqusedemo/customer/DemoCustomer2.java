package com.acel.mqusedemo.customer;

import com.acel.mqusedemo.producer.DemoMsg;
import com.efun.starter.rocketmq.annotation.MQConsumer;
import com.efun.starter.rocketmq.base.AbstractMQPushConsumer;

import java.util.Map;

/**
 * @author Acel
 * @since 2018/1/8
 */
@MQConsumer(consumerGroup = "pf-member-customerT3", topic = "01-08T3")
public class DemoCustomer2 extends AbstractMQPushConsumer<DemoMsg>{
    @Override
    public boolean process(DemoMsg demoMsg, Map<String, Object> map){
        System.out.println("进入消费方法~~~~~");
        String msg = new String(demoMsg.getMsg());
        System.out.println(new String(demoMsg.getMsg()));
        if("testFalse".equalsIgnoreCase(msg)){
            return false;
        }
        if("testExecption".equalsIgnoreCase(msg)){
            int i = 1%0;
        }
        return true;
    }
}
