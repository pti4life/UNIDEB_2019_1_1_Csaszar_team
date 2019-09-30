package Modell;

import org.apache.commons.codec.digest.DigestUtils;

public class LoginSystemModell {

    Database db = Database.getDatabaseInstance();

    public String login(String username, String password) {
        String res=db.authUser(username);
        if (res.equals("USER_EXISTS")) {
            password=DigestUtils.sha256Hex(password);
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
;
        String result=db.authUser(username);
        if (result.equals("USER_DOESNT_EXISTS")) {
            password= DigestUtils.sha256Hex(password);
            String result2=db.addUser(username,password);
            return result2;
        } else  {
            return result;
        }




    }


}
