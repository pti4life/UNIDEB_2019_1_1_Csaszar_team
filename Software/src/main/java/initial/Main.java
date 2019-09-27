package initial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LoginSystemView.fxml"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
        System.out.println("show után gec");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
