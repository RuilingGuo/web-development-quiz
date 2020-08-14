package com.thoughtworks.quiz.ApiTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_return_order() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$",hasSize(0)))
                .andExpect(status().isOk());
    }

    @Test
    void should_add_order() throws Exception{
        //language=JSON
        String requestJson = "{\n" +
                "  \"productId\":1,\n" +
                "  \"num\": 1\n" +
                "}";

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(content().string("成功添加"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(status().isOk());

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(content().string("成功添加"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(status().isOk());
    }
}
