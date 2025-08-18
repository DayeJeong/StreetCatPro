package com.streetcat.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.streetcat.mapper.LoginMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomMemberDetailsService implements UserDetailsService {
 
  private final LoginMapper loginMapper ;
  private BCryptPasswordEncoder passwordEncoder;
 
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    CustomMemberDetails members = loginMapper.membercheck(username);
    if(members == null) {
      throw new UsernameNotFoundException("username " + username + " not found");
    }
    System.out.println("**************Found user***************");
    System.out.println("   username : " + members.getUsername());
    System.out.println("***************************************");
 
    log.info(members.getUsername());
    log.info(members.getPassword());
    
    CustomMemberDetails userDetails = new CustomMemberDetails();
    userDetails.setUsername(members.getUsername());
    userDetails.setPassword(members.getPassword());
    userDetails.setEnabled(1); // 강제로 함해
    userDetails.setAuth("ROLE_USER");
    
    log.info("리턴 : {}" ,userDetails);
    
    return userDetails;
  }
}