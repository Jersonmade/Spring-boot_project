package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
    public class UserController {
        private UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/user/all")
        public List<User> allUsers() {
            return userService.getAllUser();
        }

        @GetMapping("/{id}")
        public User getScheduleById(@PathVariable Long id) {
            return userService.getUserById(id);
        }

        @PostMapping("/add")
        public void addUser(User user) {
            userService.save(user);
        }

        @RequestMapping("/delete/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.delete(id);
        }
}
