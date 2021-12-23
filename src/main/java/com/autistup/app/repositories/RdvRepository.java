package com.autistup.app.repositories;

import com.autistup.app.entities.Question;
import com.autistup.app.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepository extends JpaRepository<Rdv,Long> {



}
