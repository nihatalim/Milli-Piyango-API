package com.nihatalim.millipiyango.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "bilen_kisiler", indexes = {@Index(columnList = "oid")})
public class BilenKisiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "oid", unique = true, nullable = false)
    private String oid;

    @Column(name = "kisiBasinaDusenIkramiye")
    private double kisiBasinaDusenIkramiye;

    @Column(name = "kisiSayisi")
    private int kisiSayisi;

    @Column(name = "tur")
    private String tur;

    @JsonIgnore
    @ManyToOne
    private Loto loto;

    public BilenKisiler() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public double getKisiBasinaDusenIkramiye() {
        return kisiBasinaDusenIkramiye;
    }

    public void setKisiBasinaDusenIkramiye(double kisiBasinaDusenIkramiye) {
        this.kisiBasinaDusenIkramiye = kisiBasinaDusenIkramiye;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public Loto getLoto() {
        return loto;
    }

    public void setLoto(Loto loto) {
        this.loto = loto;
    }
}
