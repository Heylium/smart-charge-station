package com.helium.SmartChargeStation.demo.controller;

import com.helium.SmartChargeStation.demo.MqttApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MqttApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MqttPahoCtlTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("测试基于eclipse paho mqttV3发送信息")
    @Test
    public void testPahoPub() throws Exception {
        // 构造Request
        MvcResult result = mockMvc.perform(
                        post("/paho/pub")
                                // 设置内容类型
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("topic", "io_test")
                                .param("message", "hello MQTT")
                )
                .andExpect(status().isOk())
                // 打印请求信息
                .andDo(print())
                .andReturn();

        // 打印接口返回信息
        System.out.println(result.getResponse().getContentAsString());
    }

    @DisplayName("测试基于eclipse paho mqttV3订阅主题")
    @Test
    public void testPahoSub() throws Exception {
        // 构造Request
        MvcResult result = mockMvc.perform(
                post("/paho/sub")
                        // 设置内容格式
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .param("topic", "io_test")
        )
                .andExpect(status().isOk()) //断言
                .andDo(print()) //打印请求信息
                .andReturn();

        // 打印接口返回信息
        System.out.println(result.getResponse().getContentAsString());
    }
}
