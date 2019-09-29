package Modell;

import javax.xml.crypto.Data;
import java.util.IllegalFormatCodePointException;

public class LoginSystemModell {

    Database db = Database.getDatabaseInstance();

    public String login(String username, String password) {
        String res=db.authUser(username);
        System.out.println(res);
        if (res.equals("USER_EXISTS")) {
            String loginResult=db.login(username,password);
            return loginResult;
        }
        return res;

    }

    public String signUp(String username, String password, String password2) {
        if (!password.equals(password2)) {
            return "TWO_PASSWORD_NOT_EQUAL";
        }

        if (password.equals(username)) {
            return "PASSWORD_EQUAL_USERNAME";
        }

        String result=db.authUser(username);

        if (result.equals("USER_EXISTS")) {
            String result2=db.addUser(username,password);
            return result;
        } else  {
            return result;
        }




    }


}
