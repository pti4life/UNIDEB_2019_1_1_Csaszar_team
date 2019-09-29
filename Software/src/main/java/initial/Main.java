package initial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage=primaryStage;
        setScene("LoginSystemView.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }


    public static void setScene(String scene){
        Parent root=null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(Main.class.getClassLoader().getResource(scene)));
        } catch (IOException e){
            System.out.println("geci");
            System.out.println(e);
        }
        stage.setTitle("Lotterysimulator");
        stage.setScene(new Scene(root, 800, 400));
        stage.setResizable(false);
        stage.show();
    }
}
