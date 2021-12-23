package com.autistup.app.services;

import com.autistup.app.entities.Rdv;
import com.autistup.app.entities.SpecialisteRdv;
import com.autistup.app.entities.User;
import com.autistup.app.repositories.RdvRepository;
import com.autistup.app.repositories.SpecialisteRdvRepository;
import com.autistup.app.repositories.UserRepository;
import com.autistup.app.sharedDto.SpecialisteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SpecialisteRdvServiceImpl implements SpecialisteRdvService{

    @Autowired
    SpecialisteRdvRepository specialisteRdvRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;


    @Autowired
    RdvRepository rdvRepository;
    @Override
    public SpecialisteDto createSpecialiste(SpecialisteDto specialistedto) throws Exception {
        String parentEmail=specialistedto.getEmail();
        if(specialisteRdvRepository.existsByEmail(parentEmail)){
            throw new RuntimeException("Error,specialist already exists");
        };
        ModelMapper modelMapper=new ModelMapper();
        SpecialisteRdv specialisteRdv = modelMapper.map(specialistedto, SpecialisteRdv.class);
        specialisteRdv.setActive(true);
        specialisteRdv.setPasswordEncrypted(passwordEncoder.encode(specialistedto.getPassword()));
        SpecialisteRdv specialisteEvolutionSaved = specialisteRdvRepository.save(specialisteRdv);
        User user = modelMapper.map(specialisteEvolutionSaved, User.class);
        userRepository.save(user);
        SpecialisteDto specialiteCreated = modelMapper.map(specialisteEvolutionSaved, SpecialisteDto.class);
        return specialiteCreated;
    }

    @Override
    public List<SpecialisteDto> getAllSpecialiste() {
        List<SpecialisteRdv> specialisteRdvs = specialisteRdvRepository.findAll();
        List<SpecialisteDto> specialisteDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(SpecialisteRdv specialisteRdv : specialisteRdvs ){
            SpecialisteDto specialisteDto = modelMapper.map(specialisteRdv, SpecialisteDto.class);
            specialisteDtos.add(specialisteDto);
        }
        return specialisteDtos;

    }

    @Override
    public void deleteSpecialiste(String email) {
        SpecialisteRdv specialiste = specialisteRdvRepository.findByEmail(email);
        specialisteRdvRepository.delete(specialiste);

    }

    @Override
    public void updateSpecialiste(String email) {
        SpecialisteRdv specialiste = specialisteRdvRepository.findByEmail(email);
        specialiste.setActive(!specialiste.isActive());
        specialisteRdvRepository.save(specialiste);


    }

    @Override
    public List<Rdv> getAllRdvs(String email) {
        List<Rdv> rdvs = specialisteRdvRepository.findByEmail(email).getRdvs();
        return rdvs;
    }
}
