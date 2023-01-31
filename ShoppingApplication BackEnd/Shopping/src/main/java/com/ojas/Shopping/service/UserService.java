package com.ojas.Shopping.service;

import com.ojas.Shopping.entity.UserEntity;
import com.ojas.Shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        if(null== userEntity){
            throw new UsernameNotFoundException("User Not Found With The Given Username : "+username);
        }
        return userEntity;
    }
}
