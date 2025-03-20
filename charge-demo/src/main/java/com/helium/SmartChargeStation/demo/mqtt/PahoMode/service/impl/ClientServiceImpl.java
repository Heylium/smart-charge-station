package com.helium.SmartChargeStation.demo.mqtt.PahoMode.service.impl;

import com.helium.SmartChargeStation.demo.mqtt.PahoMode.service.ClientService;
import com.helium.SmartChargeStation.demo.mqtt.PahoMode.utils.MqttClientUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 业务实现类
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private MqttClientUtils utils;

    @Override
    public void publish(String topic, String message) {
        utils.publish(topic, message);
    }

    @Override
    public void subscribe(String topic) {
        utils.subscribe(topic);
    }

    @Override
    public void disconnect() {
        utils.disconnect();
    }
}
