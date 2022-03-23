package com.company;

import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ShoeDetails shoeDetails = new ShoeDetails();
        shoeDetails.login();
        shoeDetails.shoeOrder();


        shoeDetails.geBetyg();



    }



       /* PreparedStatement insert;
        String namn = "";
        String lösenord = "";
        int kundid = 0;
        int beställningsid = 0;
        int produktid = 0;
        int id = 0;
        String köpaSko = "";
        String varaNamn = "";
        int iddd = 0;
        int sistaBeställningsId = 0;
        String loginCredentials = "SELECT Namn, Lösenord FROM KUND WHERE Namn = '" + namn + "'AND lösenord = '" + lösenord+ "'";
        Kund kund = new Kund();



        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoedb?serverTimezone=UTC&useSSL=false&allowPublicRetrieval=true"
                    , "root", "Evilman666");

            Statement statement = connection.createStatement();
           // CallableStatement stm = connection.prepareCall("CALL AddToCart(?,?,?)");








            Scanner sc = new Scanner(System.in);




            System.out.println("Ange namn");
            namn = sc.nextLine();
            System.out.println("Ange lösenord");
            lösenord = sc.nextLine();

            ResultSet rs = statement.executeQuery("SELECT * FROM KUND WHERE Namn = '" + namn + "'AND lösenord = '" + lösenord+ "'");
            if (rs.next())
            {
                kund.setNamn(rs.getString("namn"));
                kund.setLösenord(rs.getString("lösenord"));
                kund.setId(rs.getInt("id"));
                id = rs.getInt("id");
            }

            else{
                System.out.println("Nej nu funkade det inte");
            }

            System.out.println(id);



           // beställningsid = sc.nextInt();






            //stm.execute();
            String svar;




          //  ResultSet rs1 = statement.executeQuery("SELECT NAMN, LÖSENORD FROM KUND WHERE NAMN = användarnamn AND lösenord = lösenordsvar ");
            System.out.println("Vill du se produktlistan? Ja/Nej");
            svar = sc.next();


            if (svar.equalsIgnoreCase("ja")) {

                ResultSet rss = statement.executeQuery("Select ID, FÄRG,STORLEK, MÄRKE,PRIS,LAGER, NAMN from VARA WHERE LAGER >= 1");


                while (rss.next()) {
                    int idd = rss.getInt("ID");
                    String färg = rss.getString("FÄRG");
                    int storlek = rss.getInt("STORLEK");
                    String märke = rss.getString("MÄRKE");
                    int pris = rss.getInt("PRIS");
                    int lager = rss.getInt("LAGER");
                    varaNamn = rss.getString("NAMN");
                    System.out.println(idd + " " + storlek + " " + färg + " " + märke + " " + pris + " " + lager + " " + varaNamn);


                }

            }

            else if (svar.equalsIgnoreCase("Nej")) {
                System.out.println("Ok, hejdå");
            }

            System.out.println("Vilken sko vill du lägga till?");
            sc.nextLine();
            String svarPåVara = sc.nextLine();



            ResultSet rsss = statement.executeQuery("Select ID, FÄRG,STORLEK, MÄRKE,PRIS,LAGER, NAMN from VARA WHERE Namn = '" + svarPåVara + "'");

            while (rsss.next()){
                iddd = rsss.getInt("ID");


            }

            insert = connection.prepareStatement("CALL AddToCart(?,?,?)");

            insert.setInt(1, id);
            insert.setInt(2, beställningsid);
            insert.setInt(3, iddd);

            insert.executeUpdate();


            ResultSet resultSetBeställningsId = statement.executeQuery("SELECT MAX(beställningsid) FROM beställning ");

         while (resultSetBeställningsId.next()){
                sistaBeställningsId = resultSetBeställningsId.getInt("MAX(beställningsid)");
            }


            System.out.println(sistaBeställningsId);

            insert = connection.prepareStatement("CALL AddToCart(?,?,?)");

            insert.setInt(1, id);
            insert.setInt(2, sistaBeställningsId);
            insert.setInt(3, iddd);

            insert.executeUpdate();


            ResultSet utskriftAvBeställning = statement.executeQuery("Select * from BESTÄLLNING WHERE beställningsid ='" + sistaBeställningsId + "'");


            while (utskriftAvBeställning.next()) {
                int idbeställning = utskriftAvBeställning.getInt("beställningsid");
                int beställningsnamn = utskriftAvBeställning.getInt("skoid");
                /*String färg = rss.getString("FÄRG");
                int storlek = rss.getInt("STORLEK");
                String märke = rss.getString("MÄRKE");
                int pris = rss.getInt("PRIS");
                int lager = rss.getInt("LAGER");
                varaNamn = rss.getString("NAMN");


                System.out.println(idbeställning + " " + beställningsnamn);


            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




    public void login(){



    }


*/

}
