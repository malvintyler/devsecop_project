package com.devsecops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.extension.ExtendWith;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class) // Enable Spring support for JUnit 5
public class NumericApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSmallerThanOrEqualToFiftyMessage() throws Exception {
        this.mockMvc.perform(get("/compare/50"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Smaller than or equal to 50"));
    }

    @Test
    public void testGreaterThanFiftyMessage() throws Exception {
        this.mockMvc.perform(get("/compare/51"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Greater than 50"));
    }

    @Test
    public void testIncrementCheck() throws Exception {
        this.mockMvc.perform(get("/increment/99"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("100"));
    }
    
    @Test
    public void testWelcomeMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Kubernetes DevSecOps"));
    }

}
