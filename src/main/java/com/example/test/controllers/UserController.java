package com.example.test.controllers;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.UserDto;
import com.example.test.dtos.UserRoleDto;
import com.example.test.dtos.views.UserViewModel;
import com.example.test.models.enums.Role;
import com.example.test.services.UserRoleService;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @ModelAttribute("userDto")
    public UserDto initUser() {
        return new UserDto();
    }

    @GetMapping("/add")
    public String addUser(){
        return "user-add";
    }

    @GetMapping("/all")
    String getAllUser(){
        userService.getAllUser();
        return "user-add";
    }
    @GetMapping("/{id}")
    UserViewModel getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }
    @PostMapping("/add")
    String addUserRole(@RequestBody UserDto userDto){
        userService.addNewUser(userDto);
        return "/";
    }
    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable String id){
        userService.deleteUserById(id);
        return "Client with id = " + id + " was deleted";}
//    @PutMapping("/{id}/{role}")
//    UserRoleDto updateUserRoleName(@PathVariable String id, @PathVariable  role){
//        return userService.updateUserFirstName(id, role);
//    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
