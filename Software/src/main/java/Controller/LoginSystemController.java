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


    //Login
    @FXML
    TextField loginUsername;

    @FXML
    PasswordField loginPassword;

    @FXML
    Pane loginPanes;

    //alert
    @FXML
    Label alertLabel;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    public void backToLoginScreen(ActionEvent actionEvent) {
        regPanes.setVisible(false);
        loginPanes.setVisible(true);
    }

    public void SignUp(ActionEvent actionEvent) {
        String res=modell.signUp(regUserame.getText(),regPassword1.getText(),regPassword2.getText());
        alertLabel.setTextFill(Color.web("RED", 0.8));

        switch (res) {
            case "SUCCESSFULLY_SIGNUP":
                alertLabel.setTextFill(Color.web("#15ff25", 0.8));
                alertLabel.setText("Sikeres regisztráció, most már bejelentkezhet!");
                break;
            case "FAILED_SIGNUP":
                alertLabel.setText("Sikertelen regisztráció, forduljon a rendszergazdához!");
                break;
            case "TWO_PASSWORD_NOT_EQUAL":
                alertLabel.setText("A két jelszó nem egyforma!");
                break;
            case "PASSWORD_EQUAL_USERNAME":
                alertLabel.setText("A felhasználónév és a jelszó nem egyezhet meg");
                break;
            case "USERNAME_EXISTS":
                alertLabel.setText("Ez a felhasználónév már létezik.");
                break;
            case "DB_PROBLEM":
                alertLabel.setText("Az adatbázissal probléma van, próbálja újra később!");
                break;
        }
    }

    public void Login(ActionEvent actionEvent) {



    }

    public void GoToRegScreen(ActionEvent actionEvent) {
        regPanes.setVisible(true);
        loginPanes.setVisible(false);

    }
}
