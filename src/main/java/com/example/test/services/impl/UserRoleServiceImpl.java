package com.example.test.services.impl;


import com.example.test.models.enums.Role;
import com.example.test.dtos.UserRoleDto;
import com.example.test.models.UserRole;
import com.example.test.repositories.UserRoleRepository;

import com.example.test.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserRoleDto addNewUserRole(UserRoleDto userRoleDto) {
        //TODO начинаем с юзер роли и после делаем юзера

        return modelMapper.map(userRoleRepository.save(modelMapper.map(userRoleDto, UserRole.class)), UserRoleDto.class);
//        return null;
    }
    @Override
    public UserRoleDto getUserRoleById(String id){
        return modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class);
    }
    @Override
    public void deleteUserRoleById(String id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public UserRoleDto updateUserRoleName(String uuid, Role role) {
        UserRole userRole = userRoleRepository.findById(uuid).orElseThrow();
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        return modelMapper.map(userRole, UserRoleDto.class);
    }

    @Override
    public List<UserRoleDto> getAllUserRole() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDto> getAllUserRoleByName(String name) {
        return null;
    }
}
