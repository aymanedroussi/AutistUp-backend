package com.autistup.app.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="rdv")
public class Rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String jour;

    @Column
    private String heure;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;


    @ManyToOne
    @JoinColumn(name = "specialisteRdv_id")
    private SpecialisteRdv specialisteRdv;

    public SpecialisteRdv getSpecialisteRdv() {
        return specialisteRdv;
    }

    public void setSpecialisteRdv(SpecialisteRdv specialisteRdv) {
        this.specialisteRdv = specialisteRdv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }


}
