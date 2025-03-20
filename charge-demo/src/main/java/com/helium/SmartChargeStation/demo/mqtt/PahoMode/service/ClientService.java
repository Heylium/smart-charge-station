package com.helium.SmartChargeStation.demo.mqtt.PahoMode.service;

/**
 * 业务接口
 */
public interface ClientService {

    // 发送
    public void publish(String topic, String message);

    // 订阅
    public void subscribe(String topic);

    public void disconnect();
}
