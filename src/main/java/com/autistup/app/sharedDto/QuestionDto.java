package com.autistup.app.sharedDto;

import java.util.Date;

public class QuestionDto {
    private Long id;

    private Date dateQuestion;

    private String libelle;

    private String auteur;

    private String role;

    private Long forumId;

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

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
