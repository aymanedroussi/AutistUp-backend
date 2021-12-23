package com.autistup.app.services;

import com.autistup.app.entities.Parent;
import com.autistup.app.entities.User;
import com.autistup.app.entities.UserEntityDetails;
import com.autistup.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    SpecialisteRdvRepository specialisteRdvRepository;

    @Autowired
    SpecialisteEvolutionRepository specialisteEvolutionRepository;

    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);


        if(user==null){
            throw new UsernameNotFoundException("Sorry, User Not exist");
        }
        String role=user.getRole();
        boolean valid=false;
        if(role.equals("ROLE_ADMIN")) {
            if (adminRepository.existsByEmail(email)){
                valid = true;}
        }
        else if(role.equals("ROLE_PARENT")){
            if (parentRepository.existsByEmail(email)){
                valid = true;}
        }

        else if(role.equals("ROLE_SPECIALISTE_EVOLUTION")){
            if (specialisteEvolutionRepository.existsByEmail(email)){
            valid = true;}}
        else if(role.equals("ROLE_SPECIALISTE_RDV")){
            if (specialisteRdvRepository.existsByEmail(email)){
                valid = true;}
        }

        if(valid){
            return new UserEntityDetails(user);

        }
        else {
            throw new UsernameNotFoundException("Sorry, User Not exist");
        }
    }
}
