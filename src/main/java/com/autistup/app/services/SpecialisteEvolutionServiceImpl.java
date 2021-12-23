package com.autistup.app.services;

import com.autistup.app.entities.Article;
import com.autistup.app.entities.Parent;
import com.autistup.app.entities.SpecialisteEvolution;
import com.autistup.app.entities.User;
import com.autistup.app.repositories.SpecialisteEvolutionRepository;
import com.autistup.app.repositories.UserRepository;
import com.autistup.app.sharedDto.ArticleDto;
import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.SpecialisteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialisteEvolutionServiceImpl implements SpecialisteEvolutionService {
    @Autowired
    SpecialisteEvolutionRepository specialisteEvolutionRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public SpecialisteDto createSpecialiste(SpecialisteDto specialistedto) throws Exception {
        String parentEmail=specialistedto.getEmail();
        if(specialisteEvolutionRepository.existsByEmail(parentEmail)){
            throw new RuntimeException("Error,specialist already exists");
        };
        ModelMapper modelMapper=new ModelMapper();
        SpecialisteEvolution specialisteEvolution = modelMapper.map(specialistedto, SpecialisteEvolution.class);
        specialisteEvolution.setActive(true);
        specialisteEvolution.setPasswordEncrypted(passwordEncoder.encode(specialistedto.getPassword()));
        SpecialisteEvolution specialisteEvolutionSaved = specialisteEvolutionRepository.save(specialisteEvolution);
        User user = modelMapper.map(specialisteEvolution, User.class);
        userRepository.save(user);
        SpecialisteDto specialiteCreated = modelMapper.map(specialisteEvolutionSaved, SpecialisteDto.class);
        return specialiteCreated;
    }

    @Override
    public List<SpecialisteDto> getAllSpecialiste() {
        List<SpecialisteEvolution> specialisteEvolutions = specialisteEvolutionRepository.findAll();
        List<SpecialisteDto> specialisteDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(SpecialisteEvolution specialisteEvolution : specialisteEvolutions ){
            SpecialisteDto specialisteDto = modelMapper.map(specialisteEvolution, SpecialisteDto.class);
            specialisteDtos.add(specialisteDto);
        }
        return specialisteDtos;

    }

    @Override
    public void deleteSpecialiste(String email) {
        SpecialisteEvolution specialiste = specialisteEvolutionRepository.findByEmail(email);
        specialisteEvolutionRepository.delete(specialiste);

    }

    @Override
    public void updateSpecialiste(String email) {
        SpecialisteEvolution specialiste = specialisteEvolutionRepository.findByEmail(email);
        specialiste.setActive(!specialiste.isActive());
        specialisteEvolutionRepository.save(specialiste);


    }
}

