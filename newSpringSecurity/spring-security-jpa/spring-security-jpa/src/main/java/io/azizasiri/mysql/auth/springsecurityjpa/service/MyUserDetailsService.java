package io.azizasiri.mysql.auth.springsecurityjpa.service;

import io.azizasiri.mysql.auth.springsecurityjpa.entity.User;
import io.azizasiri.mysql.auth.springsecurityjpa.model.MyUserDetails;
import io.azizasiri.mysql.auth.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    // Get the data from the repo

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUserName(username) ;
        user.orElseThrow(() -> new UsernameNotFoundException("User "+username+" Not Found: "));

        return user.map(MyUserDetails::new).get();
    }
}
