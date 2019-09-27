package Modell;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static Database databaseInstance=null;


    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;


    private Database() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@codd.inf.unideb.hu:1521:ora12c", "U_C4NVNX", "rolcsi89");
            System.out.println("efut");
        } catch (Exception ex) {
            System.out.println("hiba a onnectionnál");
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

    public static Database getDatabaseInstance() {
        if (databaseInstance==null) {
            return new Database();
        } else {
            return databaseInstance;
        }
    }
}
