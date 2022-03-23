package com.company;

import java.sql.*;
import java.util.Scanner;

public class ShoeDetails {
    String namn = "";
    String lösenord = "";
    int beställningsid = 0;
    int sistaBeställningsId = 0;
    Kund kund = new Kund();
    Scanner sc = new Scanner(System.in);

    public void login() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "niklas123");
            Statement statement = connection.createStatement();
            System.out.println("Ange namn");
            namn = sc.nextLine();
            System.out.println("Ange lösenord");
            lösenord = sc.nextLine();
            ResultSet rs = statement.executeQuery("SELECT * FROM KUND WHERE Namn = '" + namn + "'AND lösenord = '" + lösenord + "'");
            if (rs.next()) {
                kund.setNamn(rs.getString("namn"));
                kund.setLösenord(rs.getString("lösenord"));
                kund.setId(rs.getInt("id"));


                printList();
            } else {
                System.out.println("Nej nu funkade det inte");
                login();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void printList(){
        System.out.println("Vill du se produktlistan? Ja/Nej");
        String svar = sc.next();
        Vara vara = new Vara();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "niklas123");
            Statement statement = connection.createStatement();



            if (svar.equalsIgnoreCase("ja")) {

                ResultSet rss = statement.executeQuery("Select ID, FÄRG,STORLEK, MÄRKE,PRIS,LAGER, NAMN from VARA WHERE LAGER >= 1");
                while (rss.next()) {

                    vara.setFärg(rss.getString("FÄRG"));
                    vara.setStorlek(rss.getInt("STORLEK"));
                    vara.setMärke(rss.getString("MÄRKE"));
                    vara.setLager(rss.getInt("LAGER"));
                    vara.setNamn(rss.getString("NAMN"));
                    vara.setPris(rss.getInt("PRIS"));


                    System.out.println("Storlek: " + vara.getStorlek() + " Färg: " + vara.getFärg() + " Märke: " + vara.getMärke()+ " Pris: " + vara.getPris() + " Hur många i lager: " + vara.getLager() + " Modell: " + vara.getNamn());
                }
            }
            else if (svar.equalsIgnoreCase("Nej")) {
                System.out.println("Ok, hejdå");
            }
            else {
                System.out.println("Vänligen ange ett av svaren. ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void shoeOrder(){


        try {
            Vara vara = new Vara();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "niklas123");
            Statement statement = connection.createStatement();


            PreparedStatement insert;

            System.out.println("Vilken sko vill du beställa?");
            sc.nextLine();
            String svarPåVara = sc.nextLine();

            ResultSet rs = statement.executeQuery("Select ID, FÄRG,STORLEK, MÄRKE,PRIS,LAGER, NAMN from VARA WHERE Namn = '" + svarPåVara + "'");

            while (rs.next()){
                vara.setId(rs.getInt("ID"));
                vara.setLager(rs.getInt("LAGER"));
            }

            if (vara.getLager() > 0) {
                insert = connection.prepareStatement("CALL AddToCart(?,?,?)");
                insert.setInt(1, kund.getId());
                insert.setInt(2, beställningsid);
                insert.setInt(3, vara.getId());
                insert.executeUpdate();
                System.out.println("Vill du lägga till något mer?");
                String läggaTillMer = sc.next();
                if (läggaTillMer.equalsIgnoreCase("ja")) {

                    ResultSet resultSetBeställningsId = statement.executeQuery("SELECT MAX(beställningsid) FROM beställning ");

                    while (resultSetBeställningsId.next()) {
                        sistaBeställningsId = resultSetBeställningsId.getInt("MAX(beställningsid)");
                    }


                    beställningsid = sistaBeställningsId;
                    shoeOrder();
                } else {
                    System.out.println("Din beställning har gått igenom. Tack för din beställning!");
                    skrivUtbeställning();
                }
            }
            else {
                System.out.println("Varan är slut i lager. Vill du beställa något annat?");
                String svar = sc.next();
                if (svar.equalsIgnoreCase("Ja")){
                    shoeOrder();
                }
                else
                {
                    System.out.println("Okej ha det bra!");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void skrivUtbeställning(){

        try {
            Vara vara = new Vara();
            Beställning beställning = new Beställning();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "niklas123");
            Statement statement = connection.createStatement();



            ResultSet resultSetBeställningsId = statement.executeQuery("SELECT MAX(beställningsid) FROM beställning ");

            while (resultSetBeställningsId.next()){
                sistaBeställningsId = resultSetBeställningsId.getInt("MAX(beställningsid)");
            }
            System.out.println("Vill du skriva ut din beställning? Ja/Nej");
            String svar = sc.next();

            if (svar.equalsIgnoreCase("Ja")) {
                ResultSet rs = statement.executeQuery("Select * from BESTÄLLNING b INNER JOIN VARA v on b.skoid = v.id  WHERE BESTÄLLNINGSID = '" + sistaBeställningsId + "'");
                System.out.println("I din beställning finns: ");
                while (rs.next()) {
                    vara.setNamn(rs.getString("NAMN"));
                    beställning.setAntal(rs.getInt("ANTAL"));
                    System.out.println(vara.getNamn() + " Antal:" + beställning.getAntal() + " ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    public void geBetyg() {
        try {
            Produkt_Betyg produkt_betyg = new Produkt_Betyg();


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "niklas123");
            Statement statement = connection.createStatement();
            PreparedStatement insert;

            System.out.println("Vilken sko vill du betygsätta?");
            sc.nextLine();
            String svarPåVara = sc.nextLine();

            ResultSet rs = statement.executeQuery("Select ID, FÄRG,STORLEK, MÄRKE,PRIS,LAGER, NAMN from VARA WHERE Namn = '" + svarPåVara + "'");
            while (rs.next()){

               produkt_betyg.setVaraid(rs .getInt("ID"));

            }

            System.out.println("Vad får varan för betyg? 1-4");
           produkt_betyg.setBetygid(sc.nextInt());
           if (produkt_betyg.getBetygid() >= 1 && produkt_betyg.getBetygid() <=4
           ) {
               System.out.println("Kommentera varan");
               sc.nextLine();
               produkt_betyg.setKommentar(sc.nextLine());

               insert = connection.prepareStatement("CALL RATE(?,?,?,?)");
               insert.setInt(1, kund.getId());
               insert.setDouble(2, produkt_betyg.getBetygid());
               insert.setString(3, produkt_betyg.getKommentar());
               insert.setDouble(4, produkt_betyg.getVaraid());
               insert.executeUpdate();
               betygOchKommentar();
           }

           else {
               System.out.println("Vänligen ange en siffra mellan 1-4");
               geBetyg();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void betygOchKommentar(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "niklas123");
            Statement statement = connection.createStatement();
            Vara vara = new Vara();
            Produkt_Betyg produkt_betyg = new Produkt_Betyg();

            System.out.println("Vilken sko vill du se betyg för?");
            String svarPåVara = sc.nextLine();
            ResultSet rs = statement.executeQuery("Select ID, FÄRG,STORLEK, MÄRKE,PRIS,LAGER, NAMN from VARA WHERE Namn = '" + svarPåVara + "'");
            while (rs.next()){

               vara.setId(rs.getInt("ID"));

            }


            if(vara.getId() != 0) {
                System.out.println("Snittbetyg för skorna: ");
                ResultSet rs2 = statement.executeQuery("SELECT avg(betyg_id) as betyg_id from produkt_betyg where vara_ID = '" + vara.getId() + "'");
                while (rs2.next()) {

                    produkt_betyg.setBetygid(rs2.getDouble("betyg_id"));
                    System.out.println(produkt_betyg.getBetygid());
                }
                System.out.println("Kommentarer för skorna: ");

                ResultSet rsssss = statement.executeQuery("SELECT kommentar  from produkt_betyg where vara_ID = '" + vara.getId() + "'");
                while (rsssss.next()) {

                    produkt_betyg.setKommentar(rsssss.getString("kommentar"));
                    System.out.println(produkt_betyg.getKommentar());
                }
            }

            else  {
                System.out.println("Du angav inget giltigt svar. Försök igen.");
                betygOchKommentar();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}