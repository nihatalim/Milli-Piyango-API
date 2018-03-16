package com.nihatalim.millipiyango.api.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "loto", indexes = {@Index(columnList = "oid")})
public class Loto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "oid", unique = true, nullable = false)
    private String oid;

    @Column(name = "hafta")
    private int hafta;

    @Column(name = "buyukIkramiyeKazananIl")
    private String buyukIkramiyeKazananIl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cekilisTarihi")
    private Date cekilisTarihi;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "cekilisTuru")
    private LotoType cekilisTuru;

    @Column(name = "rakamlar")
    private String rakamlar;

    @Column(name = "rakamlarNumaraSirasi")
    private String rakamlarNumaraSirasi;

    @Column(name = "devretti")
    private boolean devretti;

    @Column(name = "devirSayisi")
    private int devirSayisi;

    @OneToMany(mappedBy = "loto")
    private List<BilenKisiler> bilenKisiler;

    @OneToMany(mappedBy = "loto")
    private List<Yerler> buyukIkrKazananIlIlceler;

    @Column(name = "kibrisHasilati")
    private double kibrisHasilati;

    @Column(name = "devirTutari")
    private double devirTutari;

    @Column(name = "kolonSayisi")
    private int kolonSayisi;

    @Column(name = "kdv")
    private double kdv;

    @Column(name = "toplamHasilat")
    private double toplamHasilat;

    @Column(name = "hasilat")
    private double hasilat;

    @Column(name = "sov")
    private double sov;

    @Column(name = "ikramiyeEH")
    private double ikramiyeEH;

    @Column(name = "buyukIkramiye")
    private double buyukIkramiye;

    @Column(name = "haftayaDevredenTutar")
    private double haftayaDevredenTutar;

    public enum LotoType{
        SAYISAL_LOTO("SAYISAL_LOTO"), ON_NUMARA("ON_NUMARA"), SUPER_LOTO("SUPER_LOTO"), SANS_TOPU("SANS_TOPU");

        private String type;

        private LotoType(String type){
            this.type = type;
        }
    }

    public Loto() {
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

    public int getHafta() {
        return hafta;
    }

    public void setHafta(int hafta) {
        this.hafta = hafta;
    }

    public String getBuyukIkramiyeKazananIl() {
        return buyukIkramiyeKazananIl;
    }

    public void setBuyukIkramiyeKazananIl(String buyukIkramiyeKazananIl) {
        this.buyukIkramiyeKazananIl = buyukIkramiyeKazananIl;
    }

    public Date getCekilisTarihi() {
        return cekilisTarihi;
    }

    public void setCekilisTarihi(Date cekilisTarihi) {
        this.cekilisTarihi = cekilisTarihi;
    }

    public LotoType getCekilisTuru() {
        return cekilisTuru;
    }

    public void setCekilisTuru(LotoType cekilisTuru) {
        this.cekilisTuru = cekilisTuru;
    }

    public String getRakamlar() {
        return rakamlar;
    }

    public void setRakamlar(String rakamlar) {
        this.rakamlar = rakamlar;
    }

    public String getRakamlarNumaraSirasi() {
        return rakamlarNumaraSirasi;
    }

    public void setRakamlarNumaraSirasi(String rakamlarNumaraSirasi) {
        this.rakamlarNumaraSirasi = rakamlarNumaraSirasi;
    }

    public boolean isDevretti() {
        return devretti;
    }

    public void setDevretti(boolean devretti) {
        this.devretti = devretti;
    }

    public int getDevirSayisi() {
        return devirSayisi;
    }

    public void setDevirSayisi(int devirSayisi) {
        this.devirSayisi = devirSayisi;
    }

    public double getKibrisHasilati() {
        return kibrisHasilati;
    }

    public void setKibrisHasilati(double kibrisHasilati) {
        this.kibrisHasilati = kibrisHasilati;
    }

    public double getDevirTutari() {
        return devirTutari;
    }

    public void setDevirTutari(double devirTutari) {
        this.devirTutari = devirTutari;
    }

    public int getKolonSayisi() {
        return kolonSayisi;
    }

    public void setKolonSayisi(int kolonSayisi) {
        this.kolonSayisi = kolonSayisi;
    }

    public double getKdv() {
        return kdv;
    }

    public void setKdv(double kdv) {
        this.kdv = kdv;
    }

    public double getToplamHasilat() {
        return toplamHasilat;
    }

    public void setToplamHasilat(double toplamHasilat) {
        this.toplamHasilat = toplamHasilat;
    }

    public double getHasilat() {
        return hasilat;
    }

    public void setHasilat(double hasilat) {
        this.hasilat = hasilat;
    }

    public double getSov() {
        return sov;
    }

    public void setSov(double sov) {
        this.sov = sov;
    }

    public double getIkramiyeEH() {
        return ikramiyeEH;
    }

    public void setIkramiyeEH(double ikramiyeEH) {
        this.ikramiyeEH = ikramiyeEH;
    }

    public double getBuyukIkramiye() {
        return buyukIkramiye;
    }

    public void setBuyukIkramiye(double buyukIkramiye) {
        this.buyukIkramiye = buyukIkramiye;
    }

    public double getHaftayaDevredenTutar() {
        return haftayaDevredenTutar;
    }

    public void setHaftayaDevredenTutar(double haftayaDevredenTutar) {
        this.haftayaDevredenTutar = haftayaDevredenTutar;
    }

    public List<BilenKisiler> getBilenKisiler() {
        return bilenKisiler;
    }

    public void setBilenKisiler(List<BilenKisiler> bilenKisiler) {
        this.bilenKisiler = bilenKisiler;
    }

    public List<Yerler> getBuyukIkrKazananIlIlceler() {
        return buyukIkrKazananIlIlceler;
    }

    public void setBuyukIkrKazananIlIlceler(List<Yerler> buyukIkrKazananIlIlceler) {
        this.buyukIkrKazananIlIlceler = buyukIkrKazananIlIlceler;
    }
}
