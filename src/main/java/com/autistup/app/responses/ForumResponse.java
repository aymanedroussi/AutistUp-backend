package com.autistup.app.responses;

import java.util.Date;

public class ForumResponse {
    private Long id;
    private Date dateDebut;
    private String sujet;
    private int nbrQuestions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getNbrQuestions() {
        return nbrQuestions;
    }

    public void setNbrQuestions(int nbrQuestions) {
        this.nbrQuestions = nbrQuestions;
    }



}