package com.example.test.services.impl;

import com.example.test.dtos.UserDto;
import com.example.test.dtos.UserRoleDto;
import com.example.test.models.User;
import com.example.test.repositories.UserRepository;
import com.example.test.repositories.UserRoleRepository;
import com.example.test.services.UserService;
import com.example.test.dtos.views.UserViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserRoleRepository userRoleRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public UserViewModel getUserById(String id) {
        return modelMapper.map(userRepository.findById(id), UserViewModel.class);
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public List<UserViewModel> getAllUserByUsername(String username) {
//        return userRepository.findAllByUsername(username).stream().map(user -> modelMapper.map(user,UserViewModel.class)).collect(Collectors.toList());
//    }

    @Override
    public UserDto updateUserFirstName(String id, String firstName) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(firstName);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserViewModel> getAllUser() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserViewModel.class)).collect(Collectors.toList());
    }
@Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
}
