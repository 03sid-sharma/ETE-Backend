package com.ete.DataCollection.controller;

import com.ete.DataCollection.model.User;
import com.ete.DataCollection.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/add",method =RequestMethod.POST)
    public String adduser(@RequestBody String data) throws JsonProcessingException {
        User user = new ObjectMapper().readValue(data, User.class);
        if(userService.adduser(user))
            return "true";
        return "false";
    }

    @RequestMapping("/getAllUsers")
    public List<User> getUsers()  {
        List<User> userList=userService.getAllUsers();
        System.out.println(userList);
        return userList;
    }

}
