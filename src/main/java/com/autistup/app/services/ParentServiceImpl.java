package com.autistup.app.services;

import com.autistup.app.entities.Parent;
import com.autistup.app.entities.SpecialisteEvolution;
import com.autistup.app.entities.User;
import com.autistup.app.repositories.ParentRepository;
import com.autistup.app.repositories.UserRepository;
import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.SpecialisteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService{

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public ParentDto createUser(ParentDto parentDto) throws Exception {
        String parentEmail=parentDto.getEmail();
        if(parentRepository.existsByEmail(parentEmail)){
            throw new RuntimeException("Error,parent already exists");
        };
        ModelMapper modelMapper=new ModelMapper();
        Parent parent = modelMapper.map(parentDto, Parent.class);
        parent.setActive(true);
        parent.setPasswordEncrypted(passwordEncoder.encode(parentDto.getPassword()));
        Parent parentSaved = parentRepository.save(parent);
        User user = modelMapper.map(parent, User.class);
        userRepository.save(user);
        ParentDto parentDtoCreated = modelMapper.map(parentSaved, ParentDto.class);
        return parentDtoCreated;
    }


    @Override
    public ParentDto getUserByEmail(String email) {
        Parent parent = parentRepository.findByEmail(email);

        if (parent==null){
            throw new RuntimeException("Parent Not Exist");
        }

        ParentDto parentDto=new ParentDto();
        BeanUtils.copyProperties(parent,parentDto);
        return parentDto;

    }

    @Override
    public List<ParentDto> getAllParents() {
        List<Parent> parents = parentRepository.findAll();
        List<ParentDto> parentDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Parent parent : parents ){
            ParentDto parentDto = modelMapper.map(parent, ParentDto.class);
            parentDtos.add(parentDto);
        }
        return parentDtos;

    }

    @Override
    public void deleteParent(String email) {
        Parent parent = parentRepository.findByEmail(email);
        parentRepository.delete(parent);
    }

    @Override
    public void updateParent(String email) {
        Parent parent = parentRepository.findByEmail(email);
        parent.setActive(!parent.isActive());
        parentRepository.save(parent);


    }

    @Override
    public ParentDto getParentByEmail(String email) {
        Parent parent = parentRepository.findByEmail(email);
        ModelMapper modelMapper=new ModelMapper();
        ParentDto parentDto = modelMapper.map(parent, ParentDto.class);
        return parentDto;
    }
}
