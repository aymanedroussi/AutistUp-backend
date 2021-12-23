package com.autistup.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @Column(name="dateQuestion")
    private Date dateQuestion;

    @Column(name="Question")
    private String libelle;

    @Column
    private String auteur;

    @Column
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Date getDateQuestion() {
        return dateQuestion;
    }

    public void setDateQuestion(Date dateQuestion) {
        this.dateQuestion = dateQuestion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Question() {
    }
}
