package com.autistup.app.controllers;

import com.autistup.app.entities.Rdv;
import com.autistup.app.requests.RdvRequest;
import com.autistup.app.requests.SpecialisteAddRequest;
import com.autistup.app.responses.RdvResponse;
import com.autistup.app.responses.SpecialiteCreatedResponse;
import com.autistup.app.services.RdvService;
import com.autistup.app.services.SpecialisteEvolutionService;
import com.autistup.app.services.SpecialisteRdvService;
import com.autistup.app.sharedDto.RdvDto;
import com.autistup.app.sharedDto.SpecialisteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/specialisteRdv")
public class SpecialisteRdvController {
    @Autowired
    SpecialisteRdvService specialisteRdvService;

    @Autowired
    RdvService rdvService;


    @PostMapping("/create")
    public ResponseEntity<SpecialiteCreatedResponse> createSpecialiste(@RequestBody SpecialisteAddRequest specialisteAddRequest) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        SpecialisteDto specialisteDto=modelMapper.map(specialisteAddRequest,SpecialisteDto.class);
        SpecialisteDto specialisteDtoCreated = specialisteRdvService.createSpecialiste(specialisteDto);
        SpecialiteCreatedResponse specialiteCreatedResponse = modelMapper.map(specialisteDtoCreated, SpecialiteCreatedResponse.class);
        return new ResponseEntity<>(specialiteCreatedResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SpecialiteCreatedResponse>> getAllSpecialiste(){
        List<SpecialisteDto> allSpecialiste = specialisteRdvService.getAllSpecialiste();
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
        specialisteRdvService.deleteSpecialiste(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/update/{email}")
    public ResponseEntity desactiverSpecialiste(@PathVariable(name="email") String email){
        specialisteRdvService.updateSpecialiste(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/addRdv")
    public void addRdv(@RequestBody RdvRequest rdvRequest)  {
        ModelMapper modelMapper=new ModelMapper();
        RdvDto rdvDto=modelMapper.map(rdvRequest,RdvDto.class);
        rdvService.addRdv(rdvDto);
    }


    @GetMapping("/getAllRdvs/{email}")
    public ResponseEntity<List<RdvResponse>> getAllRdvs(@PathVariable(name="email") String email){
        List<Rdv> allRdvs = specialisteRdvService.getAllRdvs(email);
        List<RdvResponse> rdvResponses=new ArrayList<>();
        for(Rdv rdv:allRdvs){
            RdvResponse rdvResponse = new RdvResponse();
            rdvResponse.setHeure(rdv.getHeure());
            rdvResponse.setJour(rdv.getJour());
            rdvResponse.setParentEmail(rdv.getParent().getEmail());
            rdvResponses.add(rdvResponse);
        }
        return new ResponseEntity<List<RdvResponse>>(rdvResponses, HttpStatus.OK);
    }
}
