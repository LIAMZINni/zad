package repozitory.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
    protected String dbhost="localhost";
    protected String dbport="3306";
    protected String dbuser="root";
    protected String dbpass="19283746";
    protected String dbname="newspaper";
    protected String durl="jdbc:mysql://";
    private static Connection connection;
    public DataBaseConnector(){
        try {
            connection= DriverManager.getConnection(durl+dbhost+":"+dbport+"/"+dbname,dbuser,dbpass);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Connection getDbconnection() {
        return connection;
    }
}
