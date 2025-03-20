package com.helium.SmartChargeStation.demo.mqtt.PahoMode.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

/**
 * 监听类
 */
@Component
@Slf4j
public class MessageListener implements IMqttMessageListener {

    /**
     * 接收到订阅的主题推送的消息
     * @param topic
     * @param mqttMessage
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        String message = new String(mqttMessage.getPayload());
        log.info(">>>>>监听器收到订阅主题的消息：topic={},message={}", topic, message);
    }
}
