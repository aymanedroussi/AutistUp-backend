package com.autistup.app.sharedDto;

public class VilleDto {
    private Long id;
    private String ville;
    private int nbrCentres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNbrCentres() {
        return nbrCentres;
    }

    public void setNbrCentres(int nbrCentres) {
        this.nbrCentres = nbrCentres;
    }
}