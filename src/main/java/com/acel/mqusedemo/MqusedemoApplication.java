package com.acel.mqusedemo;

import com.acel.mqusedemo.producer.DemoMsg;
import com.acel.mqusedemo.producer.DemoProducer;
import com.efun.starter.rocketmq.annotation.EnableMQConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableMQConfiguration
public class MqusedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqusedemoApplication.class, args);
	}

	@Autowired
	DemoProducer producer;

	@RequestMapping(value = {"/sendMsg"}, method = RequestMethod.GET)
	public Object sendMsg(String topic, String tag, String msg){
		DemoMsg demoMsg = new DemoMsg();
		demoMsg.setMsg(msg);
		producer.syncSend(topic,tag,demoMsg);
		return "ok";
	}

}
