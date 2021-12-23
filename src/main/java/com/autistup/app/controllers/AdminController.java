package com.autistup.app.controllers;


import com.autistup.app.requests.AdminRegisterRequest;
import com.autistup.app.requests.ParentRegisterRequest;
import com.autistup.app.responses.AdminRegisterResponse;
import com.autistup.app.responses.ParentResponse;
import com.autistup.app.services.AdminService;
import com.autistup.app.sharedDto.AdminDto;
import com.autistup.app.sharedDto.ParentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<AdminRegisterResponse> createUser(@RequestBody AdminRegisterRequest adminRegisterRequest) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        AdminDto adminDto=modelMapper.map(adminRegisterRequest, AdminDto.class);
        AdminDto adminDtocreated = adminService.createAdmin(adminDto);
        AdminRegisterResponse adminRegisterResponse = modelMapper.map(adminDtocreated, AdminRegisterResponse.class);
        return new ResponseEntity<>(adminRegisterResponse, HttpStatus.CREATED);
    }
}
