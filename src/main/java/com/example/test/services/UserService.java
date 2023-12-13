package com.example.test.services;

import com.example.test.dtos.UserDto;
import com.example.test.dtos.UserRoleDto;
import com.example.test.dtos.views.OfferViewModel;
import com.example.test.dtos.views.OfferViewModelForUser;
import com.example.test.dtos.views.UserViewModel;
import com.example.test.models.UserRole;

import java.util.List;

public interface UserService {
    void addNewUser(UserDto userDto);
    List<UserRole> showAllRole();
    UserViewModel getUserById(String id);
    void deleteUserById(String id);
//    List<UserViewModel> getAllUserByUsername(String username);
    List<UserViewModel> getAllUser();
    UserDto updateUserFirstName(String id, String firstName);

    List<OfferViewModelForUser> getOffersByUsername(String username);

    UserDto getUserByUsername(String username);
}
