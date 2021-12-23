package com.autistup.app.services;

import com.autistup.app.entities.Forum;
import com.autistup.app.repositories.ForumRepository;
import com.autistup.app.sharedDto.ForumDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService{
    @Autowired
    ForumRepository forumRepository;

    @Override
    public List<ForumDto> findAll() {
        List<Forum> allForums = forumRepository.findAll();
        List<ForumDto> forumDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(Forum forum : allForums ){
            ForumDto forumdto = modelMapper.map(forum, ForumDto.class);
            forumDtos.add(forumdto);
        }
        return forumDtos;
    }

    @Override
    public void addForum(ForumDto forumDto) {
        ModelMapper modelMapper=new ModelMapper();
        Forum forum = modelMapper.map(forumDto, Forum.class);
        forumRepository.save(forum);
    }
}
