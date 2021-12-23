package com.autistup.app.controllers;

import com.autistup.app.entities.VideoFormation;
import com.autistup.app.requests.VideoRequest;
import com.autistup.app.responses.VideoResponse;
import com.autistup.app.services.VideoService;
import com.autistup.app.sharedDto.VideoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/formation/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(path="/getAll",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<VideoResponse>> getVideos(){
        List<VideoDto> videoDtos = videoService.getAllVideos();
        List<VideoResponse> videoResponses=new ArrayList<>();
        ModelMapper modelMapper=new ModelMapper();
        for(VideoDto video : videoDtos ){
            VideoResponse videoResponse = modelMapper.map(video, VideoResponse.class);
            videoResponses.add(videoResponse);
        }
        return new ResponseEntity<List<VideoResponse>>(videoResponses, HttpStatus.OK);
    }

    @PostMapping(path="/add",consumes ={MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<VideoResponse> addVideo(@RequestBody VideoRequest videoRequest){

        return new ResponseEntity(new VideoResponse(),HttpStatus.CREATED);
    }
}
