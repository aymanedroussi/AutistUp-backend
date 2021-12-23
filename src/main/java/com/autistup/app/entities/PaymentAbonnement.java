package com.autistup.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="paymentAbonnement")
public class PaymentAbonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //parent



    @Column(name="date")
    private Date date;

    @Column(name="status")
    private String status;

    //abonnement
    @ManyToOne
    @JoinColumn(name="abonnement_id")
    private Abonnement abonnement;


    @Column(name="method")
    private String method;

    @Column(name="prix")
    private float prix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
