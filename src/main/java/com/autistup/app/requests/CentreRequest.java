package com.autistup.app.requests;

import com.autistup.app.entities.Ville;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CentreRequest {
    private Long id;


    private Long ville_id;


    private String centre;


    private String adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVille_id() {
        return ville_id;
    }

    public void setVille_id(Long ville_id) {
        this.ville_id = ville_id;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
