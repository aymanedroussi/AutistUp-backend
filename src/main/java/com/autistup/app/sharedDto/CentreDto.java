package com.autistup.app.sharedDto;

import com.autistup.app.entities.Ville;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CentreDto {

    private Long id;

    private String centre;

    private String adresse;
    private String villeName;

    public String getVilleName() {
        return villeName;
    }

    public void setVilleName(String villeName) {
        this.villeName = villeName;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
