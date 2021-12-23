package com.autistup.app.requests;

public class RdvRequest {

    private String jour;
    private String heure;
    private String parentEmail;
    private String specialisteRdvEmail;


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
}
