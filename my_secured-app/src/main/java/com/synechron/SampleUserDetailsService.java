package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SampleUserDetailsService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //IDEALLY YOU WILL GO TO DATABASE AND load SampleUserDetails using username
        SampleUserDetails userDetails = new SampleUserDetails();
        if("mary".equalsIgnoreCase(username)) {
            //return userDetailsRepository.findByUserName(username);
            userDetails.setUsername(username);
            userDetails.setId(1234L);
            userDetails.setPassword(bCryptPasswordEncoder.encode("12345"));
            return userDetails;
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
