package com.dhananjay.expenseapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExpenseControllerIntegrationTest {
    @Autowired MockMvc mvc;

    @Test
    void createsAndReadsExpense() throws Exception {
        String body = """
          {"title":"Internet bill","amount":799.00,"category":"UTILITIES","expenseDate":"2026-10-20","notes":"Home"}
          """;
        mvc.perform(post("/api/expenses").contentType(MediaType.APPLICATION_JSON).content(body))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.title").value("Internet bill"));
        mvc.perform(get("/api/expenses"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].category").value("UTILITIES"));
    }

    @Test
    void rejectsInvalidExpense() throws Exception {
        mvc.perform(post("/api/expenses").contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\":\"\",\"amount\":0,\"category\":\"\",\"expenseDate\":\"2026-10-20\"}"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.error").value("Validation failed"));
    }

    @Test
    void missingExpenseReturns404() throws Exception {
        mvc.perform(get("/api/expenses/999999"))
            .andExpect(status().isNotFound());
    }
}