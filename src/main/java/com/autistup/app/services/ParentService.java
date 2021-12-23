package com.autistup.app.services;

import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.SpecialisteDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParentService {
    public ParentDto createUser(ParentDto parentDto) throws Exception;
    public ParentDto getUserByEmail(String email);
    public void updateParent(String email);
    public List<ParentDto> getAllParents();
    public void deleteParent(String email);
    public ParentDto getParentByEmail(String email);
}
