package com.omersolutions.mvcinterfacehttp.controllerTest;

import com.omersolutions.mvcinterfacehttp.user.User;
import com.omersolutions.mvcinterfacehttp.user.UserController;
import com.omersolutions.mvcinterfacehttp.user.UserHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserHttpClient userHttpClient;

    @Test
    public void shouldReturnUsers() throws Exception {
        // Arrange
        User user = new User(1,
                "John Doe",
                "",
                "",
                null,
                "",
                "",
                null);
        when(userHttpClient.findAll()).thenReturn(Collections.singletonList(user));

        // Act and Assert
        mockMvc.perform(get("/users/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value(""));
    }

    @Test
    public void shouldReturnUserById() throws Exception {
        // Arrange
        int id = 1;
        User user = new User(id,
                "Leanne Graham",
                "",
                "Sincere@april.biz",
                null,
                "",
                "",
                null);
        when(userHttpClient.findById(id)).thenReturn(user);

        // Act and Assert
        mockMvc.perform(get("/users/" + 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("Leanne Graham"))
                .andExpect(jsonPath("$.email").value("Sincere@april.biz"));
    }
}