package com.helium.SmartChargeStation.demo.mqtt.PahoMode.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * 回调类
 */
@Slf4j
public class Callback implements MqttCallback {

    /**
     * 连接丢失会调用
     * @param throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        log.info(">>>>>连接断开，原因：{}", throwable.getMessage());
    }

    /**
     * 接收到订阅的消息后调用
     * @param topic
     * @param mqttMessage
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        log.info(">>>>>接收主题{}的消息：{}", topic, mqttMessage.toString());
    }

    /**
     * 发送消息成功调用的方法
     * @param iMqttDeliveryToken
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info(">>>>>消息发送是否成功：{}", iMqttDeliveryToken.isComplete());
    }
}
