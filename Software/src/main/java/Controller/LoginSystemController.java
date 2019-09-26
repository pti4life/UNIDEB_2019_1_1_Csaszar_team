package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class LoginSystemController implements Initializable {


    //SignUp
    @FXML
    TextField regName;

    @FXML
    TextField regUserame;

    @FXML
    PasswordField regPassword1;

    @FXML
    PasswordField regPassword2;


    //Login
    @FXML
    TextField loginUsername;

    @FXML
    PasswordField loginPassword;



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void backToLoginScreen(ActionEvent actionEvent) {

    }

    public void SignUp(ActionEvent actionEvent) {

    }

    public void Login(ActionEvent actionEvent) {
    }

    public void GoToRegScreen(ActionEvent actionEvent) {

    }
}
