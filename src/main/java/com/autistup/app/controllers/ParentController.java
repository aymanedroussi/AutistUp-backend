package com.autistup.app.controllers;

import com.autistup.app.entities.Parent;
import com.autistup.app.requests.ParentRegisterRequest;
import com.autistup.app.responses.ParentResponse;
import com.autistup.app.responses.SpecialiteCreatedResponse;
import com.autistup.app.services.ParentService;
import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.SpecialisteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    ParentService parentService;

    @PostMapping("/create")
    public ResponseEntity<ParentResponse> createUser(@RequestBody ParentRegisterRequest parentRegisterRequest) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        ParentDto parentDto=modelMapper.map(parentRegisterRequest,ParentDto.class);
        ParentDto parentDtoCreated = parentService.createUser(parentDto);
        ParentResponse parentResponse = modelMapper.map(parentDtoCreated, ParentResponse.class);
        return new ResponseEntity<>(parentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ParentResponse>> getAllParent(){
        List<ParentDto> allParents = parentService.getAllParents();
        List<ParentResponse> parentResponses=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(ParentDto parent :  allParents){
            ParentResponse parentResponse = modelMapper.map(parent, ParentResponse.class);
            parentResponses.add(parentResponse);
        }
        return new ResponseEntity<List<ParentResponse>>(parentResponses, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{email}")
    public ResponseEntity deleteParent(@PathVariable(name="email") String email){
        parentService.deleteParent(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/update/{email}")
    public ResponseEntity desactiverParent(@PathVariable(name="email") String email){
        parentService.updateParent(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<ParentResponse> getParent(@PathVariable(name="email") String email){
        ParentDto parent = parentService.getParentByEmail(email);
        ModelMapper modelMapper=new ModelMapper();
        ParentResponse parentResponse = modelMapper.map(parent, ParentResponse.class);
        return new ResponseEntity<>(parentResponse,HttpStatus.OK);
    }

}
