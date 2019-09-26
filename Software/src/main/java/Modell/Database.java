package Modell;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static Database databaseInstance=null;

    final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final String URL = "jdbc:derby:sampleDB;create=true";
    final String USERNAME = "";
    final String PASSWORD = "";


    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;


    private Database() {

        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("A híd létrejött");
        } catch (SQLException ex) {
            System.out.println(ex);
        }


        if (conn != null){
            try {
                createStatement = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }


        try {
            dbmd = conn.getMetaData();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            ResultSet rs = dbmd.getTables(null, "APP", "USERS", null);
            if(!rs.next())
            {
                createStatement.execute("" +
                        "create table " +
                        "Users(name varchar2(20)," +
                        "address varchar2(20))");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Database getDatabaseInstance() {
        if (databaseInstance==null) {
            return new Database();
        } else {
            return databaseInstance;
        }
    }
}
