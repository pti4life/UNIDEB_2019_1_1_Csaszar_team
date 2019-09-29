package Modell;

import javax.xml.crypto.Data;
import java.util.IllegalFormatCodePointException;

public class LoginSystemModell {

    Database db = Database.getDatabaseInstance();

    public String login(String username, String password) {
        Boolean res=db.authUser(username);

        if(res==null)  {
            return "DB_PROBLEM";
        } else if (res) {
            String loginResult=db.login(username,password);
            return loginResult;
        } else {
            return "USER_DOESNT_EXISTS";
        }

    }

    public String signUp(String username, String password, String password2) {
        if (!password.equals(password2)) {
            return "TWO_PASSWORD_NOT_EQUAL";
        }

        if (password.equals(username)) {
            return "PASSWORD_EQUAL_USERNAME";
        }

        try {
            if (db.authUser(username)) {
                return "USERNAME_EXISTS";
            }

        } catch (NullPointerException ex) {
            System.out.println(ex);
            return "DB_PROBLEM";
        }

        String result=db.addUser(username,password);

        return result;

    }


}
