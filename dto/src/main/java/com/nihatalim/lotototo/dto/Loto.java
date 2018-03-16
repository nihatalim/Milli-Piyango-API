package com.nihatalim.lotototo.dto;

import java.util.Date;
import java.util.List;

public class Loto {
    public String oid;
    public int hafta;
    public String buyukIkramiyeKazananIl;
    public Date cekilisTarihi;
    public LotoType cekilisTuru;
    public String rakamlar;
    public String rakamlarNumaraSirasi;
    public boolean devretti;
    public int devirSayisi;
    public List<BilenKisiler> bilenKisiler;
    public List<Yerler> buyukIkrKazananIlIlceler;
    public double kibrisHasilati;
    public double devirTutari;
    public int kolonSayisi;

    public double kdv;

    public double toplamHasilat;

    public double hasilat;

    public double sov;

    public double ikramiyeEH;

    public double buyukIkramiye;

    public double haftayaDevredenTutar;

    public enum LotoType{
        SAYISAL_LOTO("SAYISAL_LOTO"), ON_NUMARA("ON_NUMARA"), SUPER_LOTO("SUPER_LOTO"), SANS_TOPU("SANS_TOPU");

        public String type;

        private LotoType(String type){
            this.type = type;
        }
    }
}
