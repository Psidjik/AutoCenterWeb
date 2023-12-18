package com.example.test.controllers;

import com.example.test.dtos.BrandDto;
import com.example.test.dtos.ModelDto;
import com.example.test.dtos.UserDto;
import com.example.test.dtos.UserRoleDto;
import com.example.test.dtos.views.OfferViewModel;
import com.example.test.dtos.views.OfferViewModelForUser;
import com.example.test.dtos.views.UserViewModel;
import com.example.test.models.User;
import com.example.test.models.enums.Role;
import com.example.test.services.UserRoleService;
import com.example.test.services.UserService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);
    @ModelAttribute("userDto")
    public UserDto initUser() {
        return new UserDto();
    }

    @GetMapping("/add")
    public String addUser(){
//        model.addAttribute("availableRoles", userService.showAllRole());
        return "user-add";
    }
    @PostMapping("/add")
    String addUser(@Valid UserDto userDto, RedirectAttributes redirectAttributes, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userDto", userDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDto",
                    bindingResult);
            return "redirect:/user/add";
        }
        userService.addNewUser(userDto);
        return "redirect:/user/login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/user/login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String username = principal.getName();
        UserDto user = userService.getUserByUsername(username);
        List<OfferViewModelForUser> offers = userService.getOffersByUsername(username);
        model.addAttribute("userDetail", user);
        model.addAttribute("offers", offers);
        return "user-details";
    }
    @GetMapping("/all")
    String getAllUser(Model model){
        model.addAttribute("allUsers", userService.getAllUser());
        return "user-all";
    }
    @GetMapping("/details/{username}")
    String getUserByUsername(@PathVariable String username, Model model){
        model.addAttribute("userDetail", userService.getUserByUsername(username));
        model.addAttribute("offers", userService.getOffersByUsername(username));
        return "user-details";
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
