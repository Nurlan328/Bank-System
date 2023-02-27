package integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.iitu.itse1910.nurlan.MainApplication;
import kz.iitu.itse1910.nurlan.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        classes = MainApplication.class)
@AutoConfigureMockMvc
public class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void addAccount() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/accountController/addAccount")
                        .content(asJsonString(new Account()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/accountController/deleteAccountById/{id}", 2))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllAccounts() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/accountController/getAccounts")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateEmployeeAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .put("/accountController/updateAccount", 2)
                        .content(asJsonString(new Account()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
