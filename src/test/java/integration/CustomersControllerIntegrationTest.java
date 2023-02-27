package integration;

import kz.iitu.itse1910.nurlan.MainApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        classes = MainApplication.class)
@AutoConfigureMockMvc
public class CustomersControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/deleteCustomerById/{id}", 1))
                .andExpect(status().is4xxClientError());
    }

}
