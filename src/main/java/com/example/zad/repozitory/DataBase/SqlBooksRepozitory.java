package com.example.zad.repozitory.DataBase;

import com.example.zad.domen.Books;
import com.example.zad.repozitory.Repozitory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlBooksRepozitory implements Repozitory<Books> {
    public final Connection connection;

    public SqlBooksRepozitory(DataBaseConnector baseConnector) {
        this.connection = baseConnector.getDbconnection();
    }

    @Override
    public void add(Books sourse) {
        String insert= "INSERT books (name,autor,price,kolvo) VALUES(?,?,?,?)";
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
    public Books find(int id) {
        String qery="SELECT *FROM books WHERE id = "+id;
        Books books = null;


        try {
            PreparedStatement prst=connection.prepareStatement(qery);
            ResultSet resultSet =prst.executeQuery(qery);
            while (resultSet.next()){
                int id1=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String autor=resultSet.getString(3);
                int kolvo=resultSet.getInt(4);
                double price=resultSet.getDouble(5);
                books =new Books(name,id1,price,kolvo,autor);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void delit(Books sourse) {
        String insert= "DELETE FROM books WHERE id = ?";

        try {
            PreparedStatement prST=connection.prepareStatement(insert);


            prST.setInt(1,sourse.getId());
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Books> print() {
        String insert = "SELECT * FROM books" ;
        ArrayList<Books>booksArrayList=new ArrayList<>();




        try {
            PreparedStatement prST = connection.prepareStatement(insert);


            ResultSet resultSet = prST.executeQuery(insert);
            while (resultSet.next()) {

                int id = (resultSet.getInt(1));
                String name = (resultSet.getString(2));
                String autor = (resultSet.getString(3));
                double price = (resultSet.getDouble(4));
                int kolvo=(resultSet.getInt(5));

                booksArrayList.add(new Books(name,id,price,kolvo,autor));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booksArrayList;
    }

    @Override
    public double sold(int id, int kolvo1) {
        String qery = "SELECT kolvo,price FROM books WHERE id =" + id;
        String update = "UPDATE books SET kolvo = ? WHERE id = " + id;
        int kolvo = 0;
        double price = 0;
        int rez = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(qery);
            ResultSet resultSet = preparedStatement.executeQuery(qery);


            while (resultSet.next()) {
                kolvo = resultSet.getInt(1);
                price = resultSet.getFloat(2);

            }
            rez = kolvo - kolvo1;


            if (rez > 0) {
                PreparedStatement preparedStatement1 = connection.prepareStatement(update);
                preparedStatement1.setInt(1, rez);
                preparedStatement1.executeUpdate();
                price = price * kolvo1;

            }
            if (rez == 0) {
                delit(find(id));
                price = price * kolvo1;
            }
            if (rez < 0) {

                System.out.println("error");
                return 0;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public Books update(Books sourse) {
        String insert= "UPDATE books SET name = ?, autor = ?, price = ?, kolvo = ? WHERE id = "+sourse.getId();



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
