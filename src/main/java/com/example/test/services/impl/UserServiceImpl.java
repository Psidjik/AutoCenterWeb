package com.example.test.services.impl;

import com.example.test.dtos.UserDto;
import com.example.test.dtos.UserRoleDto;
import com.example.test.dtos.views.OfferViewModel;
import com.example.test.dtos.views.OfferViewModelForUser;
import com.example.test.models.Offer;
import com.example.test.models.User;
import com.example.test.models.UserRole;
import com.example.test.models.enums.Role;
import com.example.test.repositories.UserRepository;
import com.example.test.repositories.UserRoleRepository;
import com.example.test.services.UserService;
import com.example.test.dtos.views.UserViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addNewUser(UserDto userDto) {

        User user = modelMapper.map(userDto, User.class);


        Optional<User> username = userRepository.findByUsername(userDto.getUsername());
        if (username.isPresent()) {
            throw new RuntimeException("username.used");
        }

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRole(userRoleRepository.findUserRoleByRole(userDto.getRole()).orElseThrow());
        user.setRole(userRoleRepository.findUserRoleByRole(Role.CLIENT));
//        passwordEncoder.encode(user.getPassword());
        user.setIs_active(true);
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserViewModel getUserById(String id) {
        return modelMapper.map(userRepository.findById(id), UserViewModel.class);
    }

    @Override
    public List<UserRole> showAllRole(){
        return userRoleRepository.findAll().stream().collect(Collectors.toList());
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
    public List<OfferViewModelForUser> getOffersByUsername(String username) {
        List<OfferViewModelForUser> offerViewModelForUser = userRepository.findOffers(username).stream().map(offer -> modelMapper.map(offer, OfferViewModelForUser.class)).collect(Collectors.toList());
        return offerViewModelForUser;
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return modelMapper.map(userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username + " not found!")), UserDto.class);
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
