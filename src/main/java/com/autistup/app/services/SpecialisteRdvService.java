package com.autistup.app.services;

import com.autistup.app.entities.Rdv;
import com.autistup.app.sharedDto.SpecialisteDto;

import java.util.List;
import java.util.Set;

public interface SpecialisteRdvService {
    public SpecialisteDto createSpecialiste(SpecialisteDto specialistedto) throws Exception;
    public void updateSpecialiste(String email);
    public List<SpecialisteDto> getAllSpecialiste();
    public void deleteSpecialiste(String email);
    public List<Rdv> getAllRdvs(String email);
}
