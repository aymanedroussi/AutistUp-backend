package com.autistup.app.repositories;

import com.autistup.app.entities.VideoFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoFormation,Long> {

}
