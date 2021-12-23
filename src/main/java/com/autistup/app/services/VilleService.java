package com.autistup.app.services;

import com.autistup.app.sharedDto.CentreDto;
import com.autistup.app.sharedDto.VilleDto;

import java.util.List;

public interface VilleService {
    public List<VilleDto> findAll();
    public List<CentreDto> findAllById(Long id);
    public List<CentreDto> findAllCentres();
    public void deleteCentre(Long id);
}
