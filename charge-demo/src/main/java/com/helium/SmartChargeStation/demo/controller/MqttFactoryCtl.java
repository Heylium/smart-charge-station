package com.helium.SmartChargeStation.demo.controller;

import com.helium.SmartChargeStation.demo.mqtt.FactoryMode.service.MqttService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqttFactoryCtl {

    @Resource
    private MqttService service;


    //mqtt客户端发送消息
    @RequestMapping(value = "/factory/pub")
    public void pahoPub(
            @RequestParam("topic") String topic,
            @RequestParam("message") String message) {

        service.send(topic,message);
    }
}
