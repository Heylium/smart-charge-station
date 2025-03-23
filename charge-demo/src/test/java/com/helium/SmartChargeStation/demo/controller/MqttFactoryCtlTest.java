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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MqttApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MqttFactoryCtlTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("测试基于Spring Integration 发送信息")
    @Test
    public void testIntegrationPub() throws Exception {
        MvcResult result = mockMvc.perform(
                post("/factory/pub")
                        .contentType(MediaType.APPLICATION_JSON) //设置内容类型
                        .accept(MediaType.APPLICATION_JSON)
                        .param("topic", "io_test")
                        .param("message", "hello Spring Integration from IDEA")
        )
                .andExpect(status().isOk()) // 断言
                .andDo(print()) // 打印请求信息
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
