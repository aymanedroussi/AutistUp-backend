package com.autistup.app.controllers;

import com.autistup.app.responses.CentreResponse;
import com.autistup.app.responses.QuestionResponse;
import com.autistup.app.responses.VilleResponse;
import com.autistup.app.services.VilleService;
import com.autistup.app.sharedDto.CentreDto;
import com.autistup.app.sharedDto.QuestionDto;
import com.autistup.app.sharedDto.VilleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ville")
public class VilleController {

    @Autowired
    VilleService villeService;

    @GetMapping(path="/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<VilleResponse>> getAllVilles() {

        List<VilleDto> villes = villeService.findAll();

        List<VilleDto> villeDtos = villeService.findAll();
        List<VilleResponse> villeResponses = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (VilleDto ville : villeDtos) {
            VilleResponse VilleResponse = modelMapper.map(ville, VilleResponse.class);
            villeResponses.add(VilleResponse);
        }
        return new ResponseEntity<List<VilleResponse>>(villeResponses, HttpStatus.OK);


    }

    @GetMapping(path="/getAllCentres/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CentreResponse>> getAllQuestions(@PathVariable(name="id") String id) {

        List<CentreDto> centreDtos = villeService.findAllById(new Long(id));


        List<CentreResponse> centreResponses = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (CentreDto centreDto : centreDtos) {
            CentreResponse centreResponse= modelMapper.map(centreDto, CentreResponse.class);
            centreResponses.add(centreResponse);
        }
        return new ResponseEntity<List<CentreResponse>>(centreResponses, HttpStatus.OK);


    }
    @GetMapping(path="/getAllCentres",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CentreResponse>> getAllCentres() {

        List<CentreDto> centreDtos = villeService.findAllCentres();

        List<CentreResponse> centreResponses = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (CentreDto centre : centreDtos) {
            CentreResponse centreResponse = modelMapper.map(centre, CentreResponse.class);
            centreResponses.add(centreResponse);
        }
        return new ResponseEntity<List<CentreResponse>>(centreResponses, HttpStatus.OK);


    }

    @GetMapping(path="/deleteCentre/{id}")
    public void deleteCentre(@PathVariable(name="id") String id){
        villeService.deleteCentre(new Long(id));
    }

}
