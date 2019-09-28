package Controller;

import Modell.LoginSystemModell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    public void backToLoginScreen(ActionEvent actionEvent) {
        regPanes.setVisible(false);
        loginPanes.setVisible(true);
    }

    public void SignUp(ActionEvent actionEvent) {
        System.out.println(regPassword1.getText());
        System.out.println(regPassword2.getText());
        System.out.println(regUserame.getText());

    }

    public void Login(ActionEvent actionEvent) {


    }

    public void GoToRegScreen(ActionEvent actionEvent) {
        regPanes.setVisible(true);
        loginPanes.setVisible(false);

    }
}
