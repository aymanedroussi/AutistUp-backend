package com.autistup.app.services;

import com.autistup.app.entities.Article;
import com.autistup.app.entities.Rdv;
import com.autistup.app.entities.SpecialisteRdv;
import com.autistup.app.repositories.ParentRepository;
import com.autistup.app.repositories.RdvRepository;
import com.autistup.app.repositories.SpecialisteRdvRepository;
import com.autistup.app.sharedDto.ArticleDto;
import com.autistup.app.sharedDto.RdvDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RdvServiceImpl implements RdvService{

    @Autowired
    RdvRepository rdvRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    SpecialisteRdvRepository specialisteRdvRepository;


    @Override
    public List<RdvDto> getAllRdvs() {
        List<Rdv> rdvs = rdvRepository.findAll();
        List<RdvDto> rdvDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Rdv rdv : rdvs ){
            RdvDto rdvDto = modelMapper.map(rdv, RdvDto.class);

            rdvDtos.add(rdvDto);
        }
        return rdvDtos;
    }

    @Override
    public void addRdv(RdvDto rdvDto) {
        ModelMapper modelMapper=new ModelMapper();
        Rdv rdv = modelMapper.map(rdvDto, Rdv.class);
        rdv.setParent(parentRepository.findByEmail(rdvDto.getParentEmail()));
        rdv.setSpecialisteRdv(specialisteRdvRepository.findByEmail(rdvDto.getSpecialisteRdvEmail()));
        rdvRepository.save(rdv);

    }
}
