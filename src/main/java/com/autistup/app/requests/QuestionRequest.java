package com.autistup.app.requests;

import java.util.Date;

public class QuestionRequest {


    private Date dateQuestion;

    private String libelle;

    private String auteur;

    private String role;

    private Long forumId;

    public Date getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(Date dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }
}
