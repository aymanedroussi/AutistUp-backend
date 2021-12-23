package com.autistup.app.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ville")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Ville")
    private String ville;

    @Column(name="nbrCentres")
    private int nbrCentres;

    @OneToMany(mappedBy = "ville")
    private List<Centre> centres;

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
