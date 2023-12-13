package com.example.test;

import com.example.test.models.User;
import com.example.test.models.UserRole;
import com.example.test.models.enums.Role;
import com.example.test.repositories.UserRepository;
import com.example.test.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class Init implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword;

    public Init(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, @Value("${app.default.password}") String defaultPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void run(String... args) throws Exception {
        initRoles();
        initAdmin();
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var admin = new UserRole(Role.ADMIN);
            var user = new UserRole(Role.CLIENT);
            userRoleRepository.save(admin);
            userRoleRepository.save(user);
        }
    }

    private void initAdmin(){
       UserRole admin = userRoleRepository.findUserRoleByRole(Role.ADMIN);

       User adminUser = new User(LocalDateTime.now(), LocalDateTime.now(), admin, true, "admin", "1234567", "adminka",  passwordEncoder.encode("admin"),"admin");

       userRepository.save(adminUser);
    }

}
