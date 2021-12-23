package com.autistup.app.responses;

import com.autistup.app.entities.Forum;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class QuestionResponse {

    private Long id;

    private Date dateQuestion;

    private String libelle;

    private String auteur;

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(Date dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
