package com.autistup.app.repositories;

import com.autistup.app.entities.SpecialisteEvolution;
import com.autistup.app.entities.SpecialisteRdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisteRdvRepository extends JpaRepository<SpecialisteRdv,Long> {
    public boolean  existsByEmail(String email);
    public void deleteByEmail(String email);
    public SpecialisteRdv findByEmail(String email);
}
