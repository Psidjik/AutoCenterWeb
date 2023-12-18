package com.example.test.controllers;

import com.example.test.models.enums.Role;
import com.example.test.dtos.UserRoleDto;
import com.example.test.services.UserRoleService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/userrole")
public class UserRoleController {
    private UserRoleService userRoleService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @ModelAttribute("userRoleDto")
    public UserRoleDto initBrand(){
        return new UserRoleDto();
    }

    @GetMapping("/add")
    String addUserRole(){
        return "userrole-add";
    }

    @PostMapping("/add")
    String addUserRole(@Valid UserRoleDto userRoleDto){
        userRoleService.addNewUserRole(userRoleDto);
        return "redirect:/";
    }

    @GetMapping("/all")
    List<UserRoleDto> getAllUserRole(){
        return userRoleService.getAllUserRole();
    }
    @GetMapping("/{id}")
    UserRoleDto getUserRoleById(@PathVariable String id){
        return userRoleService.getUserRoleById(id);
    }

    @DeleteMapping("/delete/{id}")
    String deleteUserRole(@PathVariable String id){
        userRoleService.deleteUserRoleById(id);
        return "Client with id = " + id + " was deleted";}
    @PutMapping("/{id}/{role}")
    UserRoleDto updateUserRoleName(@PathVariable String id, @PathVariable Role role){
        return userRoleService.updateUserRoleName(id, role);
    }
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
