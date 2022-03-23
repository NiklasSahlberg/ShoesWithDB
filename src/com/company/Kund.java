package com.company;

public class Kund {
    private int id;
    private String namn;

    public Kund(int id, String namn, String efternamn, String lösenord) {
        this.id = id;
        this.namn = namn;
        this.efternamn = efternamn;
        this.lösenord = lösenord;
    }

    private String efternamn;

    public Kund() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
    }

    private String lösenord;
}
