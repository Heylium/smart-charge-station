package com.helium.SmartChargeStation.demo.mqtt.FactoryMode.service;

import com.helium.SmartChargeStation.demo.mqtt.FactoryMode.model.MqttConstants;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/* **********************
 *
 * @MessagingGateway的作用：
 *
 * 拦截发送的mqtt消息，然后投放到消息通道
 *
 * @IntegrationComponentScan的作用：
 *
 * 能扫描到@MessagingGateway
 *
 *
 * *********************/
@IntegrationComponentScan
@MessagingGateway(defaultRequestChannel = MqttConstants.OUT_CHANNEL)
public interface MqttService {


    // 发送消息
    void send(@Header(MqttHeaders.TOPIC)String topic, String message);
}
