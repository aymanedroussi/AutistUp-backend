package com.autistup.app.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="forum")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dateDebut")
    private Date dateDebut;

    @Column(name="Sujet")
    private String sujet;

    @Column(name="nbrQuestions")
    private int nbrQuestions=0;

    @OneToMany(mappedBy = "forum")
    private List<Question> question;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getNbrQuestions() {
        return nbrQuestions;
    }

    public void setNbrQuestions(int nbrQuestions) {
        this.nbrQuestions = nbrQuestions;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}
