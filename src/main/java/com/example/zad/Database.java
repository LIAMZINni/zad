package com.example.zad;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.*;
import java.util.List;


public class Database extends Configs{

        Connection dbconnection=null;
        public Connection getDbconnection()
            throws ClassNotFoundException, SQLException{
        String connectionstring="jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconnection=DriverManager.getConnection(connectionstring,dbuser,dbpass);
        return dbconnection;


    }

    public void singnewspaper(String table,String name, String autor, double price){

        String insert= "INSERT "+table+"(name,autor,price) VALUES(?,?,?)";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setString(1,name);
            prST.setString(2, autor);
            prST.setDouble(3, price);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }
    }
    public void updete(String table,String name, String autor, double price,int id){
        String insert= "UPDATE "+table+" SET name = ?, autor = ?, price = ? WHERE id = ?";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setInt(4,id);
            prST.setString(1,name);
            prST.setString(2, autor);
            prST.setDouble(3, price);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
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
                newspaperArrayList.add(new Newspaper(name,id,price,autor));






            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        }

    return newspaperArrayList;

    };
        public void delit(String table,int id){
        String insert= "DELETE FROM "+table+" WHERE id = ?";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setInt(1,id);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        }
    }




    public static void main(String[] args) {
            Database db=new Database();
        Scanner in=new Scanner(System.in);





    }




    }


