package com.autistup.app.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="parent")
public class Parent  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email",unique = true)
    private String email;

    @Column(name="passwordEncrypted")
    private String passwordEncrypted;

    @Column(name="nom")
    private String nom;

    @Column(name="age")
    private int age;

    @Column(name="mobile")
    private String mobile;

    @Column(name="active")
    private boolean active;

    @Column
    private String role;



    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private List<Abonnement> abonnements;

    @OneToMany(mappedBy = "parent")
    private List<Rdv> rdv;

    public List<Rdv> getRdv() {
        return rdv;
    }




    public void setRdv(List<Rdv> rdv) {
        this.rdv = rdv;
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

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
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



    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
