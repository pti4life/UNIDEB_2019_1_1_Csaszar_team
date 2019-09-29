package Controller;

import Modell.LoginSystemModell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginSystemController implements Initializable {

    LoginSystemModell modell=new LoginSystemModell();

    //SignUp
    @FXML
    TextField regName;

    @FXML
    TextField regUserame;

    @FXML
    PasswordField regPassword1;

    @FXML
    PasswordField regPassword2;

    @FXML
    Pane regPanes;

    @FXML
    Label regAlertLabel;


    //Login
    @FXML
    TextField loginUsername;

    @FXML
    PasswordField loginPassword;

    @FXML
    Pane loginPanes;

    @FXML
    Label loginAlertLabel;








    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    public void backToLoginScreen(ActionEvent actionEvent) {
        regPanes.setVisible(false);
        loginPanes.setVisible(true);
    }

    public void SignUp(ActionEvent actionEvent) {
        String res=modell.signUp(regUserame.getText(),regPassword1.getText(),regPassword2.getText());
        regAlertLabel.setTextFill(Color.web("RED", 0.8));

        switch (res) {
            case "SUCCESSFULLY_SIGNUP":
                regAlertLabel.setTextFill(Color.web("#15ff25", 0.8));
                regAlertLabel.setText("Sikeres regisztráció, most már bejelentkezhet!");
                break;
            case "FAILED_SIGNUP":
                regAlertLabel.setText("Sikertelen regisztráció, forduljon a rendszergazdához!");
                break;
            case "TWO_PASSWORD_NOT_EQUAL":
                regAlertLabel.setText("A két jelszó nem egyforma!");
                break;
            case "PASSWORD_EQUAL_USERNAME":
                regAlertLabel.setText("A felhasználónév és a jelszó nem egyezhet meg");
                break;
            case "USERNAME_EXISTS":
                regAlertLabel.setText("Ez a felhasználónév már létezik.");
                break;
            case "DB_PROBLEM":
                regAlertLabel.setText("Az adatbázissal probléma van, próbálja újra később!");
                break;
        }
    }

    public void Login(ActionEvent actionEvent) {

        String result=modell.login(loginUsername.getText(),loginPassword.getText());
        switch (result) {

            case "SUCCES_LOGIN":
                //SCENE VÁLTÁS
                loginAlertLabel.setText("Sikeres tököm.");
                break;
            case "BAD_PASSWORD":
                loginAlertLabel.setText("Rosszul írta be a jelszavát!");
                break;
            case "DB_PROBLEM":
                loginAlertLabel.setText("Adatbázis probléma forduljon a rendszergazdához!");
                break;
            case "USER_DOESNT_EXISTS":
                loginAlertLabel.setText("Ez a felhasználónév nem létezik!");
                break;
        }


    }

    public void GoToRegScreen(ActionEvent actionEvent) {
        regPanes.setVisible(true);
        loginPanes.setVisible(false);

    }
}
