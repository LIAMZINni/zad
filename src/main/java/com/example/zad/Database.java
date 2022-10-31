package com.example.zad;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Database extends Configs{

        Connection dbconnection=null;
        public Connection getDbconnection()
            throws ClassNotFoundException, SQLException{
        String connectionstring="jdbc:mysql://"+dbhost+":"+dbport+"/"+dbname;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconnection=DriverManager.getConnection(connectionstring,dbuser,dbpass);
        return dbconnection;


    }

    public void singnewspaper(String table,String name, String autor, int nubresofpages){

        String insert= "INSERT "+table+"(name,autor,numbersofpages) VALUES(?,?,?)";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setString(1,name);
            prST.setString(2, autor);
            prST.setInt(3, nubresofpages);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        }
    }
    public void apeit(String table,String name, String autor, int nubresofpages,int id){
        String insert= "UPDATE "+table+" SET name = ?, autor = ?, numbersofpages = ? WHERE id = ?";

        try {
            PreparedStatement prST=getDbconnection().prepareStatement(insert);


            prST.setInt(4,id);
            prST.setString(1,name);
            prST.setString(2, autor);
            prST.setInt(3, nubresofpages);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        }

    }
    public class Item{
        private String autor;
        private String name;
        private int id;
        private int nubberOfPage;
        public Item(){
            this.name = name;
            this.id = id;
            this.nubberOfPage = nubberOfPage;
            this.autor=autor;
        }

        public void setId(int newid){
            this.id=id;
        }
        public int getId() {
            return id;
        }
        public void setName(String newname){
            this.name=name;
        }
        public String getName(){
            return name;
        }
        public void setNubberOfPage(int newnumbers){
            this.nubberOfPage=nubberOfPage;
        }
        public int getNubberOfPage(){
            return nubberOfPage;
        }
        public void setAutor(String newautor){
            this.autor=autor;
        }
        public String getAutor(){
            return  autor;
        }
        public String tostring() {
            return "id= "+id+"\n"+
                    "name= "+name+"\n"+
                    "autor= "+autor+"\n"+
                    "numberofpages= "+nubberOfPage+"\n";

        }
    }


    public void print(String table) {
        String insert = "SELECT * FROM " + table;
        ArrayList<Newspaper>newspaperArrayList=new ArrayList<>();



        try {
            PreparedStatement prST = getDbconnection().prepareStatement(insert);


            ResultSet resultSet = prST.executeQuery(insert);
            while (resultSet.next()) {

                int id = (resultSet.getInt(1));
                String name = (resultSet.getString(2));
                String autor = (resultSet.getString(3));
                int numbersofpages = (resultSet.getInt(4));
                newspaperArrayList.add(new Newspaper(name,id,numbersofpages,autor));



                System.out.println( "id= " + id + "\n" +
                        "name= " + name + "\n" +
                        "autor= " + autor + "\n" +
                        "numberofpages= " + numbersofpages + "\n");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("error");
        }



    }
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


