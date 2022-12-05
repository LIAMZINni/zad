package repozitory.DataBase;

import domen.Newspaper;
import repozitory.Repozitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlNewspaperRepozitory implements Repozitory<Newspaper> {
    private final Connection connection;

    public SqlNewspaperRepozitory(DataBaseConnector connector) {
        this.connection = connector.getDbconnection();
    }

    @Override
    public void add(Newspaper sourse) {
        String insert= "INSERT newspapers (name,autor,price,kolvo) VALUES(?,?,?,?)";

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
    public Newspaper find(int id) {
        String qery="SELECT *FROM newspapers WHERE id = "+id;
        Newspaper newspaper = null;


        try {
            PreparedStatement prst=connection.prepareStatement(qery);
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

    @Override
    public void delit(Newspaper sourse) {
        String insert= "DELETE FROM newspapers WHERE id = ?";

        try {
            PreparedStatement prST=connection.prepareStatement(insert);


            prST.setInt(1,sourse.getId());
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Newspaper> print() {
        String insert = "SELECT * FROM newspapers" ;
        ArrayList<Newspaper>newspaperArrayList=new ArrayList<>();



        try {
            PreparedStatement prST = connection.prepareStatement(insert);


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

    @Override
    public double sold(int id, int kolvo1) {
        String qery="SELECT kolvo,price FROM newspapers WHERE id ="+id;
        String update="UPDATE newspapers SET kolvo = ? WHERE id = "+ id;
        int kolvo=0;
        double price=0;
        int rez=0;
        try {

            PreparedStatement preparedStatement =connection.prepareStatement(qery);
            ResultSet resultSet = preparedStatement.executeQuery(qery);


            while (resultSet.next()){
                kolvo=resultSet.getInt(1);
                price= resultSet.getFloat(2);
                System.out.println(kolvo+" "+price);
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
    public Newspaper update(int id) {
        String insert= "UPDATE newspapers SET name = ?, autor = ?, price = ?, kolvo = ? WHERE id = "+id;
        Newspaper newspaper=find(id);
        Newspaper newspaper1=null;

        try {
            PreparedStatement prST=connection.prepareStatement(insert);


            prST.setInt(4,newspaper.getKolvo());
            prST.setString(1,newspaper.getName());
            prST.setString(2, newspaper.getAutor());
            prST.setDouble(3, newspaper.getPrice());
            newspaper1=find(id);
            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newspaper1;
    }
}
