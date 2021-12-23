package com.autistup.app.services;

import com.autistup.app.sharedDto.RdvDto;

import java.util.List;

public interface RdvService {

    public List<RdvDto> getAllRdvs();
    public void addRdv(RdvDto rdvDto);
}
