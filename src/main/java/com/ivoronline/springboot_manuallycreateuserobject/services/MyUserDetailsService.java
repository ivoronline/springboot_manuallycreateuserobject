package com.ivoronline.springboot_manuallycreateuserobject.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String enteredUsername) throws UsernameNotFoundException {

    //HARD CODED USER
    String username = "myuser";
    String password = "mypassword";
    String role     = "ROLE_USER";

    //CHECK USERNAME
    if (!username.equals(enteredUsername)) {
      throw new UsernameNotFoundException(enteredUsername);
    }

    //CREATE AUTHORITIES
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                           authorities.add(new SimpleGrantedAuthority(role));

    //CREATE USER OBJECT
    User user = new User(username, password, authorities);

    //RETURN USER
    return user;

  }

}



