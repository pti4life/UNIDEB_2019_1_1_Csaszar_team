package Modell;


import javax.print.DocFlavor;
import java.sql.*;

public class Database {

    private static Database databaseInstance=null;


    Connection conn = null;
    Statement createStatement = null;
    DatabaseMetaData dbmd = null;


    private Database() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@codd.inf.unideb.hu:1521:ora12c", "U_C4NVNX", "rolcsi89");
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
                        "Users(" +
                        "ID INT GENERATED BY DEFAULT ON NULL AS IDENTITY," +
                        "username varchar2(20) NOT NULL," +
                        "password varchar2(65) NOT NULL," +
                        "bought_tickets number DEFAULT 0," +
                        "winner_tickets number DEFAULT 0," +
                        "credit number DEFAULT 1000," +
                        "credit_used_up number DEFAULT 0," +
                        "credit_won number DEFAULT 0," +
                        "credit_lost number DEFAULT 0)");
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

    public String authUser(String username) {
        String query="select * from users where username='"+username+"'";
        try {

            ResultSet rs = createStatement.executeQuery(query);

            if(rs.next()) {
                return "USER_EXISTS";
            } else {
                return "USER_DOESNT_EXISTS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "DB_PROBLEM";
        }
    }

    public String addUser(String username, String password) {
        try {
            PreparedStatement stmt=conn.prepareStatement("" +
                    "INSERT INTO USERS (username, password) VALUES (?,?)");
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILED_SIGNUP";
        }

        return "SUCCESSFULLY_SIGNUP";
    }

    public String login(String username,String password) {

        String query="select * from users where username='"+username+"' and password='"+password+"'";
        try {
            ResultSet rs = createStatement.executeQuery(query);

            if(rs.next()) {
                return "SUCCES_LOGIN";
            } else {
                return "BAD_PASSWORD";
            }


        } catch (Exception e) {
            System.out.println("DB PROBLEM?"+e);
            return "DB_PROBLEM";
        }

    }

    public int getCredit(String userName) {
        String query = "select credit from users where username='" + userName + "'";
        ResultSet credit = null;
        int result = 0;

        try {
            credit = createStatement.executeQuery(query);
            result = credit.getInt(0);
        }
        catch (Exception ignored) {}

        return result;
    }

    public void setBoughtTickets(String userName, int amount) {
        String query = "update users SET bought_tickets = " + amount + "where username = '" + userName + "'";

        try {
            createStatement.executeQuery(query);
        } catch (Exception ignored) {}
    }

    public int getBoughtTickets(String userName) {
        String query = "select bought_tickets from users where username = '" + userName + "'";
        ResultSet usedUpCr = null;
        int result = 0;

        try {
            usedUpCr = createStatement.executeQuery(query);
            result = usedUpCr.getInt(0);
        } catch (Exception ignored) {}

        return result;
    }

    public void setWinnerTickets(String userName, int amount) {
        String query = "update users SET winner_tickets = " + amount + "where username = '" + userName + "'";

        try {
            createStatement.executeQuery(query);
        } catch (Exception ignored) {}
    }

    public int getWinnerTickets(String userName) {
        String query = "select winner_tickets from users where username = '" + userName + "'";
        ResultSet usedUpCr = null;
        int result = 0;

        try {
            usedUpCr = createStatement.executeQuery(query);
            result = usedUpCr.getInt(0);
        } catch (Exception ignored) {}

        return result;
    }

    public void setUsedUpCredit(String userName, int amount) {
        String query = "update users SET credit_used_up = " + amount + "where username = '" + userName + "'";

        try {
            createStatement.executeQuery(query);
        } catch (Exception ignored) {}
    }

    public int getUsedUpCredit(String userName) {
        String query = "select credit_used_up from users where username = '" + userName + "'";
        ResultSet usedUpCr = null;
        int result = 0;

        try {
            usedUpCr = createStatement.executeQuery(query);
            result = usedUpCr.getInt(0);
        } catch (Exception ignored) {}

        return result;
    }

    public void setCreditWon(String userName, int amount) {
        String query = "update users SET credit_won = " + amount + "where username = '" + userName + "'";

        try {
            createStatement.executeQuery(query);
        } catch (Exception ignored) {}
    }

    public int getCreditWon(String userName) {
        String query = "select credit_won from users where username = '" + userName + "'";
        ResultSet usedUpCr = null;
        int result = 0;

        try {
            usedUpCr = createStatement.executeQuery(query);
            result = usedUpCr.getInt(0);
        } catch (Exception ignored) {}

        return result;
    }

    public void setCredit(String userName, int credit) {
        String query = "update users SET credit = " + credit + " where username='" + userName + "'";
        try {
            createStatement.executeQuery(query);
        } catch (Exception ignored) {}
    }
}
