package io.azizasiri.speingsecurityjpa.security.security;

import io.azizasiri.speingsecurityjpa.security.controller.MyUserDetails;
import io.azizasiri.speingsecurityjpa.security.model.User;
import io.azizasiri.speingsecurityjpa.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//        System.out.println("user passed is "+userName);
        Optional<User> user = this.userRepository.findByUserName(userName); // The username we used to authenticate
        user.orElseThrow(() -> new UsernameNotFoundException("User not Found "+userName));
        return user.map(MyUserDetails::new).get();
    }
}
