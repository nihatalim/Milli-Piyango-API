package com.nihatalim.millipiyango.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "yerler")
public class Yerler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "il")
    private String il;

    @Column(name = "ilView")
    private String ilView;

    @Column(name = "ilce")
    private String ilce;

    @Column(name = "ilceView")
    private String ilceView;

    @JsonIgnore
    @ManyToOne
    private Loto loto;

    public Yerler() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlView() {
        return ilView;
    }

    public void setIlView(String ilView) {
        this.ilView = ilView;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getIlceView() {
        return ilceView;
    }

    public void setIlceView(String ilceView) {
        this.ilceView = ilceView;
    }

    public Loto getLoto() {
        return loto;
    }

    public void setLoto(Loto loto) {
        this.loto = loto;
    }
}
