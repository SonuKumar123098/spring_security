package com.example.spring_Seccurity.config;

import com.example.spring_Seccurity.model.Student;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDetails implements UserDetails {
    List<GrantedAuthority>authorities;
    String password;
    String username;
    public CreateUserDetails(Student student){
        this.authorities=new ArrayList<>();
        this.username=student.getUsername();
        this.password=student.getPassword();
        String roles[]=student.getRole().split(",");
        for(String role:roles){
            SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
            authorities.add(simpleGrantedAuthority);
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return true;
    }
}
