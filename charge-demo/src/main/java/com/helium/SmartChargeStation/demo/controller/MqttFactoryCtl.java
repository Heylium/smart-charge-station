package com.helium.SmartChargeStation.demo.controller;

import com.helium.SmartChargeStation.demo.mqtt.FactoryMode.service.MqttService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MqttFactoryCtl {

    @Resource
    private MqttService service;


    @RequestMapping(value = "/factory/pub")
    public void pahoPub(
            @RequestParam("topic") String topic,
            @RequestParam("message") String message
    ) {
        service.send(topic, message);
    }
}
