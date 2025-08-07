package com.streetcat.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CustomMemberDetails implements UserDetails {
 
  private String username;
  private String password;
  private String auth;
  private int enabled;
 
  @Override
  public Collection getAuthorities() {
    ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
    authList.add(new SimpleGrantedAuthority(auth));
    return authList;
  }
 
  @Override
  public String getPassword() {
    return password;
  }
 
  @Override
  public String getUsername() {
    return username;
  }
 
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
 
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
 
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
 
  @Override
  public boolean isEnabled() {
    return enabled == 1;
  }
 
}
