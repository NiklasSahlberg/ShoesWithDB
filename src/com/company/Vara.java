package com.company;

import java.util.List;

public class Vara {
    private int id;
    private int storlek;

    public Vara(int id, int storlek, String färg, String märke, int pris, String namn, int lager, List<Skotyp> skotypList, List<SkoILager> skoILagerList) {
        this.id = id;
        this.storlek = storlek;
        this.färg = färg;
        this.märke = märke;
        this.pris = pris;
        this.namn = namn;
        this.lager = lager;
        this.skotypList = skotypList;
        this.skoILagerList = skoILagerList;
    }

    private String färg;
    private String märke;
    private int pris;

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    private String namn;

    public Vara() {

    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int storlek) {
        this.storlek = storlek;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getLager() {
        return lager;
    }

    public void setLager(int lager) {
        this.lager = lager;
    }

    public List<Skotyp> getSkotypList() {
        return skotypList;
    }

    public void setSkotypList(List<Skotyp> skotypList) {
        this.skotypList = skotypList;
    }

    public List<SkoILager> getSkoILagerList() {
        return skoILagerList;
    }

    public void setSkoILagerList(List<SkoILager> skoILagerList) {
        this.skoILagerList = skoILagerList;
    }

    private int lager;
    private List<Skotyp> skotypList;
    private List <SkoILager> skoILagerList; 

}
