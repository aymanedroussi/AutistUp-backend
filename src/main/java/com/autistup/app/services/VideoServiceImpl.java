package com.autistup.app.services;

import com.autistup.app.entities.VideoFormation;
import com.autistup.app.repositories.VideoRepository;
import com.autistup.app.sharedDto.ParentDto;
import com.autistup.app.sharedDto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    VideoRepository videoRepository;

    @Override
    public List<VideoDto> getAllVideos() {
        List<VideoFormation> videos = videoRepository.findAll();
        List<VideoDto> videoDtos=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(VideoFormation video : videos ){
            VideoDto videoDto = modelMapper.map(video, VideoDto.class);
            videoDtos.add(videoDto);
        }
        return videoDtos;
    }
}
