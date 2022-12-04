package com.example.zad;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.*;
import java.util.List;


public class Database extends Configs{





    private static Connection connection;
    public Connection getDbconnection(){
        try {
            connection=DriverManager.getConnection(durl+dbhost+":"+dbport+"/"+dbname,dbuser,dbpass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void singnewspaper(String table,String name, String autor,int kolvo, double price){

        String insert= "INSERT "+table+"(name,autor,price,kolvo) VALUES(?,?,?,?)";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setString(1,name);
            prST.setString(2, autor);
            prST.setDouble(3, price);
            prST.setInt(4,kolvo);

            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updete(String table,String name, String autor,int kolvo, double price,int id){
        String insert= "UPDATE "+table+" SET name = ?, autor = ?, price = ?, kolvo = ? WHERE id = "+id;

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setInt(4,kolvo);
            prST.setString(1,name);
            prST.setString(2, autor);
            prST.setDouble(3, price);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public ObservableList<Newspaper> print(String table) {
        String insert = "SELECT * FROM " + table;
        ObservableList<Newspaper>newspaperArrayList= FXCollections.observableArrayList();



        try {
            PreparedStatement prST = getDbconnection().prepareStatement(insert);


            ResultSet resultSet = prST.executeQuery(insert);
            while (resultSet.next()) {

                int id = (resultSet.getInt(1));
                String name = (resultSet.getString(2));
                String autor = (resultSet.getString(3));
                double price = (resultSet.getDouble(4));
                int kolvo=(resultSet.getInt(5));

                newspaperArrayList.add(new Newspaper(name,id,price,kolvo,autor));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newspaperArrayList;

    }
        public void delit(String table,int id){
        String insert= "DELETE FROM "+table+" WHERE id = ?";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setInt(1,id);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    public  double sold(int id,String table,int kolvo1){
            String qery="SELECT kolvo,price FROM "+table+" WHERE id ="+id;
            String update="UPDATE "+table+" SET kolvo = ? WHERE id = "+ id;
            int kolvo=0;
            double price=0;
            int rez=0;
            try {

                PreparedStatement preparedStatement =getDbconnection().prepareStatement(qery);
                ResultSet resultSet = preparedStatement.executeQuery(qery);


                while (resultSet.next()){
                kolvo=resultSet.getInt(1);
                price= resultSet.getFloat(2);
                System.out.println(kolvo+" "+price);
                }
                rez=kolvo-kolvo1;


                if(rez>0){
                    PreparedStatement preparedStatement1=getDbconnection().prepareStatement(update);
                    preparedStatement1.setInt(1,rez);
                    preparedStatement1.executeUpdate();
                    price=price*kolvo1;

                }
                if(rez==0){
                    delit(table,id);
                    price=price*kolvo1;
                }
                if(rez<0) {

                    System.out.println("error");
                    return 0;
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }

        return price;
    }
    public Newspaper find(String table,int id){
        String qery="SELECT *FROM "+table+" WHERE id = "+id;
        Newspaper newspaper = null;


        try {
            PreparedStatement prst=getDbconnection().prepareStatement(qery);
            ResultSet resultSet =prst.executeQuery(qery);
            while (resultSet.next()){
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String autor=resultSet.getString(3);
                int kolvo=resultSet.getInt(4);
                double price=resultSet.getDouble(5);
                newspaper =new Newspaper(name,id1,price,kolvo,autor);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return newspaper;
    }










    }


