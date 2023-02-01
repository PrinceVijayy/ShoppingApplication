package com.ojas.Shopping;

import com.ojas.Shopping.entity.AuthorityEntity;
import com.ojas.Shopping.security.UserEntity;
import com.ojas.Shopping.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void login(){
        List<AuthorityEntity> authorityEntityList = new ArrayList<>();
        authorityEntityList.add(new AuthorityEntity("USER", "User role"));
        authorityEntityList.add(new AuthorityEntity("ADMIN", "Admin role"));

        UserEntity user = new UserEntity();
        user.setUsername("vijay123");
        user.setFirstName("vijay");
        user.setLastName("k");
        user.setPassword(passwordEncoder.encode("123"));
        user.setEnabled(true);
        userRepository.save(user);

    }

}
