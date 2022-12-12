package com.example.zad.repozitory.DataBase;

import com.example.zad.domen.Magazins;

import com.example.zad.repozitory.Repozitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlMagazinsRepozitory implements Repozitory<Magazins> {
    private final Connection connection;

    public SqlMagazinsRepozitory(DataBaseConnector dataBaseConnector) {
        this.connection = dataBaseConnector.getDbconnection();
    }

    @Override
    public void add(Magazins sourse) {
        String insert= "INSERT magazins (name,autor,price,kolvo) VALUES(?,?,?,?)";

        try {
            PreparedStatement prST=connection.prepareStatement(insert);


            prST.setString(1,sourse.getName());
            prST.setString(2, sourse.getAutor());
            prST.setDouble(3, sourse.getPrice());
            prST.setInt(4,sourse.getKolvo());

            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Magazins find(int id) {
        String qery="SELECT *FROM magazins WHERE id = "+id;
        Magazins magazins = null;


        try {
            PreparedStatement prst=connection.prepareStatement(qery);
            ResultSet resultSet =prst.executeQuery(qery);
            while (resultSet.next()){
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String autor=resultSet.getString(3);
                int kolvo=resultSet.getInt(4);
                double price=resultSet.getDouble(5);
                magazins =new Magazins(name,id1,price,kolvo,autor);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazins;
    }



    @Override
    public void delit(Magazins sourse) {
        String insert= "DELETE FROM magazins WHERE id = ?";

        try {
            PreparedStatement prST=connection.prepareStatement(insert);


            prST.setInt(1,sourse.getId());
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public ArrayList<Magazins> print() {
        String insert = "SELECT * FROM magazins" ;
        ArrayList<Magazins>magazinsArrayList=new ArrayList<>();



        try {
            PreparedStatement prST = connection.prepareStatement(insert);


            ResultSet resultSet = prST.executeQuery(insert);
            while (resultSet.next()) {

                int id = (resultSet.getInt(1));
                String name = (resultSet.getString(2));
                String autor = (resultSet.getString(3));
                double price = (resultSet.getDouble(4));
                int kolvo=(resultSet.getInt(5));

                magazinsArrayList.add(new Magazins(name,id,price,kolvo,autor));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return magazinsArrayList;
    }

    @Override
    public double sold(int id, int kolvo1) {
        String qery="SELECT kolvo,price FROM magazins WHERE id ="+id;
        String update="UPDATE magazins SET kolvo = ? WHERE id = "+ id;
        int kolvo=0;
        double price=0;
        int rez=0;
        try {

            PreparedStatement preparedStatement =connection.prepareStatement(qery);
            ResultSet resultSet = preparedStatement.executeQuery(qery);


            while (resultSet.next()){
                kolvo=resultSet.getInt(1);
                price= resultSet.getFloat(2);

            }
            rez=kolvo-kolvo1;


            if(rez>0){
                PreparedStatement preparedStatement1=connection.prepareStatement(update);
                preparedStatement1.setInt(1,rez);
                preparedStatement1.executeUpdate();
                price=price*kolvo1;

            }
            if(rez==0){
                delit(find(id));
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

    @Override
    public Magazins update(Magazins sourse) {
        String insert= "UPDATE magazins SET name = ?, autor = ?, price = ?, kolvo = ? WHERE id = "+sourse.getId();



        try {
            PreparedStatement prST=connection.prepareStatement(insert);


            prST.setInt(4,sourse.getKolvo());
            prST.setString(1,sourse.getName());
            prST.setString(2, sourse.getAutor());
            prST.setDouble(3, sourse.getPrice());

            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sourse;
    }
}
