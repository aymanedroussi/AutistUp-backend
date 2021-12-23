package com.autistup.app.services;

import com.autistup.app.entities.Admin;
import com.autistup.app.entities.Parent;
import com.autistup.app.entities.User;
import com.autistup.app.repositories.AdminRepository;
import com.autistup.app.repositories.UserRepository;
import com.autistup.app.sharedDto.AdminDto;
import com.autistup.app.sharedDto.ParentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        String adminDtoEmail=adminDto.getEmail();
        if(adminRepository.existsByEmail(adminDtoEmail)){
            throw new RuntimeException("Error,Admin already exists");
        };
        ModelMapper modelMapper=new ModelMapper();
        Admin admin = modelMapper.map(adminDto, Admin.class);
        admin.setRole("ROLE_ADMIN");
        admin.setActive(true);
        admin.setPasswordEncrypted(passwordEncoder.encode(adminDto.getPassword()));
        Admin adminSaved = adminRepository.save(admin);
        User user = modelMapper.map(admin, User.class);
        userRepository.save(user);
        AdminDto adminDtoCreated = modelMapper.map(adminSaved, AdminDto.class);
        return adminDtoCreated;
    }
}
