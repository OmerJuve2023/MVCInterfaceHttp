package com.omersolutions.mvcinterfacehttp.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserHttpClient userRestClient;

    public UserController(UserHttpClient userRestClient) {
        this.userRestClient = userRestClient;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userRestClient.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userRestClient.findById(id);
    }

}
