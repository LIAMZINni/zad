package com.example.zad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database extends Configs{
    Connection dbconnection;
    public Connection getDbconnection()
            throws ClassNotFoundException, SQLException{
        String connectionstring="jbdc:mysql://"+dbhost+":"+dbport+"/"+dbname;
        Class.forName("com.mysql.jdbc.Driver");
        dbconnection=DriverManager.getConnection(connectionstring,dbuser,dbpass);
        return dbconnection;

    }
    public void singnewspaper(String name, String autor, String id, String nubresofpages){
        String insert="INSERT INTO"+Const.NEWSPAPER_TABLE+"("+Const.NEWSPAPER_name+","
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
            e.printStackTrace();
        }
    }

}
