package com.autistup.app.controllers;

import com.autistup.app.requests.ParentRegisterRequest;
import com.autistup.app.requests.SpecialisteAddRequest;
import com.autistup.app.responses.ParentResponse;
import com.autistup.app.responses.SpecialiteCreatedResponse;
import com.autistup.app.responses.VideoResponse;
import com.autistup.app.services.ParentService;
import com.autistup.app.services.SpecialisteEvolutionService;
import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.SpecialisteDto;
import com.autistup.app.sharedDto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/specialisteEvolution")
public class SpecialisteEvolutionController {

    @Autowired
    SpecialisteEvolutionService specialisteEvolutionService;

    @PostMapping("/create")
    public ResponseEntity<SpecialiteCreatedResponse> createSpecialiste(@RequestBody SpecialisteAddRequest specialisteAddRequest) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        SpecialisteDto specialisteDto=modelMapper.map(specialisteAddRequest,SpecialisteDto.class);
        SpecialisteDto specialisteDtoCreated = specialisteEvolutionService.createSpecialiste(specialisteDto);
        SpecialiteCreatedResponse specialiteCreatedResponse = modelMapper.map(specialisteDtoCreated, SpecialiteCreatedResponse.class);
        return new ResponseEntity<>(specialiteCreatedResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SpecialiteCreatedResponse>> getAllSpecialiste(){
        List<SpecialisteDto> allSpecialiste = specialisteEvolutionService.getAllSpecialiste();
        List<SpecialiteCreatedResponse> specialiteCreatedResponses=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(SpecialisteDto specialiste : allSpecialiste ){
            SpecialiteCreatedResponse specialiteCreatedResponse = modelMapper.map(specialiste, SpecialiteCreatedResponse.class);
            specialiteCreatedResponses.add(specialiteCreatedResponse);
        }
        return new ResponseEntity<List<SpecialiteCreatedResponse>>(specialiteCreatedResponses, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{email}")
    public ResponseEntity deleteSpecialiste(@PathVariable(name="email") String email){
        specialisteEvolutionService.deleteSpecialiste(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/update/{email}")
    public ResponseEntity desactiverSpecialiste(@PathVariable(name="email") String email){
        specialisteEvolutionService.updateSpecialiste(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
