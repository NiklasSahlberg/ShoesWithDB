package com.company;

import java.util.List;

public class Beställning {
    private int beställningsid;
    private int skoid;
    private int antal;

    public Beställning(int beställningsid, int skoid, int antal, List<Ordrar> ordrarlist, List<Vara> varaList) {
        this.beställningsid = beställningsid;
        this.skoid = skoid;
        this.antal = antal;
        this.ordrarlist = ordrarlist;
        this.varaList = varaList;
    }

    public Beställning() {

    }

    public int getBeställningsid() {
        return beställningsid;
    }

    public void setBeställningsid(int beställningsid) {
        this.beställningsid = beställningsid;
    }

    public int getSkoid() {
        return skoid;
    }

    public void setSkoid(int skoid) {
        this.skoid = skoid;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public List<Ordrar> getOrdrarlist() {
        return ordrarlist;
    }

    public void setOrdrarlist(List<Ordrar> ordrarlist) {
        this.ordrarlist = ordrarlist;
    }

    public List<Vara> getVaraList() {
        return varaList;
    }

    public void setVaraList(List<Vara> varaList) {
        this.varaList = varaList;
    }

    private List<Ordrar> ordrarlist;
    private List <Vara> varaList;

}
