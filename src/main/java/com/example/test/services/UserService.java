package com.example.test.services;

import com.example.test.dtos.UserDto;
import com.example.test.dtos.views.UserViewModel;

import java.util.List;

public interface UserService {
    void addNewUser(UserDto userDto);
    UserViewModel getUserById(String id);
    void deleteUserById(String id);
//    List<UserViewModel> getAllUserByUsername(String username);
    List<UserViewModel> getAllUser();
    UserDto updateUserFirstName(String id, String firstName);
}
