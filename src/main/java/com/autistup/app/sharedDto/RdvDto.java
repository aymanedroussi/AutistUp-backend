package com.autistup.app.sharedDto;

import javax.persistence.Column;

public class RdvDto {

    private String jour;

    private String heure;

    private Long parent_id;
    private Long specialisteRdvsId;

    private String parentEmail;
    private String specialisteRdvEmail;

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getSpecialisteRdvEmail() {
        return specialisteRdvEmail;
    }

    public void setSpecialisteRdvEmail(String specialisteRdvEmail) {
        this.specialisteRdvEmail = specialisteRdvEmail;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getSpecialisteRdvsId() {
        return specialisteRdvsId;
    }

    public void setSpecialisteRdvsId(Long specialisteRdvsId) {
        this.specialisteRdvsId = specialisteRdvsId;
    }
}
