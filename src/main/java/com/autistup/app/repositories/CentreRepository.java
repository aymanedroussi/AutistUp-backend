package com.autistup.app.repositories;

import com.autistup.app.entities.Article;
import com.autistup.app.entities.Centre;
import com.autistup.app.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentreRepository extends JpaRepository<Centre,Long> {
    public List<Centre> findAllByVilleId(Long id);
}
