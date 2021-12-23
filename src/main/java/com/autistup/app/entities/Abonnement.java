package com.autistup.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="active")
    private boolean active;

    // parent one to one
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Parent parent;


    @Column(name="dateDebut")
    private Date dateDebut;

    @Column(name="dateFin")
    private Date dateFin;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
