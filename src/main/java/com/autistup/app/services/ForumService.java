package com.autistup.app.services;

import com.autistup.app.sharedDto.ForumDto;

import java.util.List;

public interface ForumService {
    public List<ForumDto> findAll();
    public void addForum(ForumDto forumDto);
}
