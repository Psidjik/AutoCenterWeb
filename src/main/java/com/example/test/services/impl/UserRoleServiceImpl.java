package com.example.test.services.impl;


import com.example.test.models.enums.Role;
import com.example.test.dtos.UserRoleDto;
import com.example.test.models.UserRole;
import com.example.test.repositories.UserRoleRepository;

import com.example.test.services.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @CacheEvict(cacheNames = "roles", allEntries = true)
    public void addNewUserRole(UserRoleDto userRoleDto) {
        UserRole userRole = modelMapper.map(userRoleDto, UserRole.class);
        userRoleRepository.saveAndFlush(userRole);
    }
    @Override
    public UserRoleDto getUserRoleById(String id){
        return modelMapper.map(userRoleRepository.findById(id), UserRoleDto.class);
    }
    @Override
    @CacheEvict(cacheNames = "roles", allEntries = true)
    public void deleteUserRoleById(String id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    @CacheEvict(cacheNames = "roles", allEntries = true)
    public UserRoleDto updateUserRoleName(String uuid, Role role) {
        UserRole userRole = userRoleRepository.findById(uuid).orElseThrow();
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        return modelMapper.map(userRole, UserRoleDto.class);
    }

    @Override
    @Cacheable("roles")
    public List<UserRoleDto> getAllUserRole() {
        return userRoleRepository.findAll().stream().map(userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDto> getAllUserRoleByName(String name) {
        return null;
    }
}
