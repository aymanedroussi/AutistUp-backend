package com.autistup.app.repositories;

import com.autistup.app.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    public boolean existsByEmail(String email);

}
