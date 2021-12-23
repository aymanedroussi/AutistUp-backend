package com.autistup.app.sharedDto;

import com.autistup.app.entities.Abonnement;
import com.autistup.app.entities.PaymentAbonnement;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

public class ParentDto {

    private Long id;

    private String email;

    private String password;

    private String nom;

    private int age;

    private String mobile;

    private boolean active;

    private String role;

   
 

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
