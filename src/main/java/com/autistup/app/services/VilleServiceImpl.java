package com.autistup.app.services;

import com.autistup.app.entities.Centre;
import com.autistup.app.entities.Question;
import com.autistup.app.entities.Ville;
import com.autistup.app.repositories.CentreRepository;
import com.autistup.app.repositories.VilleRepository;
import com.autistup.app.sharedDto.CentreDto;
import com.autistup.app.sharedDto.QuestionDto;
import com.autistup.app.sharedDto.VilleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VilleServiceImpl implements VilleService{

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    CentreRepository centreRepository;
    @Override
    public List<VilleDto> findAll() {
        List<Ville> allvilles = villeRepository.findAll();
        List<VilleDto> villeDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Ville ville : allvilles ){
            VilleDto villedto = modelMapper.map(ville, VilleDto.class);
            villeDtos.add(villedto);
        }
        return villeDtos;
    }

    @Override
    public List<CentreDto> findAllById(Long id) {
        List<Centre> centres = centreRepository.findAllByVilleId(id);
        List<CentreDto> centreDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Centre centre : centres ){
            CentreDto centreDto = modelMapper.map(centre, CentreDto.class);

            centreDtos.add(centreDto);
        }
        return centreDtos;

    }

    @Override
    public List<CentreDto> findAllCentres() {
        List<Centre> allCentres = centreRepository.findAll();
        List<CentreDto> centreDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Centre centre : allCentres ){
            CentreDto centreDto = modelMapper.map(centre, CentreDto.class);
            centreDtos.add(centreDto);
        }
        return centreDtos;
    }

    @Override
    public void deleteCentre(Long id) {
        Centre centre = centreRepository.findById(id).get();
        centreRepository.delete(centre);
    }
}
