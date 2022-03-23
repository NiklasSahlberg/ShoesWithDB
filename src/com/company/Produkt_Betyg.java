package com.company;

import java.util.List;

public class Produkt_Betyg {
    private int kundid;
    private double betygid;
    private int varaid;
    private String kommentar;

    public Produkt_Betyg(int kundid, int betygid, int varaid, String kommentar, List<Vara> varaList, List<Betyg> betygList) {
        this.kundid = kundid;
        this.betygid = betygid;
        this.varaid = varaid;
        this.kommentar = kommentar;
        this.varaList = varaList;
        this.betygList = betygList;
    }

    public Produkt_Betyg() {

    }

    public int getKundid() {
        return kundid;
    }

    public void setKundid(int kundid) {
        this.kundid = kundid;
    }

    public double getBetygid() {
        return betygid;
    }

    public void setBetygid(double betygid) {
        this.betygid = betygid;
    }

    public int getVaraid() {
        return varaid;
    }

    public void setVaraid(int varaid) {
        this.varaid = varaid;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public List<Vara> getVaraList() {
        return varaList;
    }

    public void setVaraList(List<Vara> varaList) {
        this.varaList = varaList;
    }

    public List<Betyg> getBetygList() {
        return betygList;
    }

    public void setBetygList(List<Betyg> betygList) {
        this.betygList = betygList;
    }

    private List<Vara> varaList;
    private List<Betyg> betygList;


}
