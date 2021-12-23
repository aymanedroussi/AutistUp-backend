package com.autistup.app.entities;


import javax.persistence.*;

@Entity
@Table(name="Centre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @Column(name="Centre")
    private String centre;

    @Column(name="Adresse")
    private String adresse;


    @Column(name="villeName")
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
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
