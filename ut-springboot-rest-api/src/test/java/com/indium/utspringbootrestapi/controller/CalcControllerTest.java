package com.indium.utspringbootrestapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indium.utspringbootrestapi.dto.CalcOperationDto;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


//Treat it as postman to access your API
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(SpringExtension.class)// Enable DI, load the context
@WebMvcTest(CalcController.class)
public class CalcControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc; // like a browser handle where you type in your endpoint address

    @Test
    void add_two_numbers() throws Exception {
        String url = "/calc/sum/10/20";
        String result = "30";
        mockMvc
                .perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

    @Test
    void multiply_two_numbers() throws Exception {
        String url = "/calc/product?num1=10&num2=20";
        String result = "200";
        mockMvc
                .perform(post(url))
                .andExpect(status().isOk())
                .andExpect(content().string(result));

    }

    @Test
    void subtract_two_numbers() throws Exception {
        String url = "/calc/difference";
        String result = "10";
        CalcOperationDto calcOperationDto = new CalcOperationDto(20, 10);
        String jsonRequest = objectMapper.writeValueAsString(calcOperationDto);
        mockMvc
                .perform(post(url)
                        .contentType("application/json")
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

    @Test
    void divide_two_numbers() throws Exception {
        String url = "/calc/quotient/20/10";
        String result = """
                {
                    "num1": 20,
                    "num2": 10,
                    "quotient": 2
                }
                """;
        mockMvc
                .perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content().json(result));
    }

}
