package com.example.spring_Seccurity.config;

import com.example.spring_Seccurity.model.Student;
import com.example.spring_Seccurity.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    public CustomUserDetailService() {
    }

    @Autowired
    private  StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentRepository.findByUsername(username);
        if(student==null)
            throw new UsernameNotFoundException("invalid username");
        return new CreateUserDetails(student);
    }
}
