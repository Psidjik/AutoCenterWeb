package com.example.test.services;

import com.example.test.models.enums.Role;
import com.example.test.dtos.UserRoleDto;

import java.util.List;

public interface UserRoleService {
    UserRoleDto addNewUserRole(UserRoleDto userRoleDto);
    UserRoleDto getUserRoleById(String id);
    void deleteUserRoleById(String id);
    List<UserRoleDto> getAllUserRole();
    List<UserRoleDto> getAllUserRoleByName(String name);
    UserRoleDto updateUserRoleName(String id, Role role);


}
