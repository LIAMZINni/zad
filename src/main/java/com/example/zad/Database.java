package com.example.zad;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;




public class Database extends Configs{

        Connection dbconnection=null;
        public Connection getDbconnection()
            throws ClassNotFoundException, SQLException{
        String connectionstring="jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconnection=DriverManager.getConnection(connectionstring,dbuser,dbpass);
        return dbconnection;


    }
    public void singnewspaper(String name, String autor, String id, String nubresofpages){
        String insert="INSERT "+"newspapers"+"("+Const.NEWSPAPER_name+","
                +Const.NEWSPAPER_id+","+Const.NEWSPAPER_autor+","+Const.NEWSPAPER_nambersofpages+")"
                +"VALUES(?,?,?,?)";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);
            prST.setString(1,name);
            prST.setString(2, id);
            prST.setString(3, autor);
            prST.setString(4, nubresofpages);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        }
    }



    public static void main(String[] args) {


    }
}

