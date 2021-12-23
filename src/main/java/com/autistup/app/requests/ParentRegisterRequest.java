package com.autistup.app.requests;

import com.autistup.app.entities.Abonnement;
import com.autistup.app.entities.PaymentAbonnement;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

public class ParentRegisterRequest {

    private String nom;
    private int age;
    private String email;
    private String password;
    private String mobile;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}
