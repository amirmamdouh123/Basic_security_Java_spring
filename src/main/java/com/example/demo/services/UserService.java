package com.example.demo.services;

import com.example.demo.base.BaseService;
import com.example.demo.entities.AppUser;
import com.example.demo.repos.UserRepo;
//import com.example.demo.security.UserDetailsExtended;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

@Primary
public class UserService extends BaseService<AppUser, UserRepo> implements UserDetailsService {
    public UserService(UserRepo repo) {
        super(repo);
    }
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Override
    public void createObject (AppUser object){
       object.setPassword(passwordEncoder.encode(object.getPassword()));
        repo.save(object);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> x= Optional.of(repo.getByName(username));
        if (!x.isPresent()){
        throw new UsernameNotFoundException("Username is not Found");
        }
    return x.get();  //AppUser is implements UserDetails
    }


    public AppUser getByName (String object){
        Optional<AppUser> x= Optional.of(repo.getByName(object));
        if(x.isPresent())
        return x.get();
        throw new UsernameNotFoundException("Sorry");
    }
}
