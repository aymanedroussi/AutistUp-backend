package com.autistup.app.services;

import com.autistup.app.entities.SpecialisteEvolution;
import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.SpecialisteDto;

import java.util.List;

public interface SpecialisteEvolutionService {
    public SpecialisteDto createSpecialiste(SpecialisteDto specialistedto) throws Exception;
    public void updateSpecialiste(String email);
    public List<SpecialisteDto> getAllSpecialiste();
    public void deleteSpecialiste(String email);

}
