package com.ojas.Shopping.service;

import com.ojas.Shopping.entity.User;
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
        User user= userRepository.findByUserName(username);
        if(null==user){
            throw new UsernameNotFoundException("User Not Found With The Given Username : "+username);
        }
        return user;
    }
}
