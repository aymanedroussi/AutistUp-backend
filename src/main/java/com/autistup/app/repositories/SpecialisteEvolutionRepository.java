package com.autistup.app.repositories;

import com.autistup.app.entities.Parent;
import com.autistup.app.entities.SpecialisteEvolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisteEvolutionRepository extends JpaRepository<SpecialisteEvolution,Long> {
    public boolean  existsByEmail(String email);
    public void deleteByEmail(String email);
    public SpecialisteEvolution findByEmail(String email);

}
