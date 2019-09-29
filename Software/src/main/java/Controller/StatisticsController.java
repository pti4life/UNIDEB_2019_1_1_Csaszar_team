package Controller;


import Modell.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {

    Database db = Database.getDatabaseInstance();
    public int bought_tickets=20, winner_tickets=3;
    public  int loser_tickets=bought_tickets-winner_tickets;

    public int credit=1000,credit_used_up=500,credit_won=600,credit_lost=298;

    @FXML
    public NumberAxis yAxis1;
    @FXML
    public CategoryAxis xAxis1;
    @FXML
    public NumberAxis yAxis2;
    @FXML
    public CategoryAxis xAxis2;

    @FXML
    public BarChart bc1;
    @FXML
    public BarChart bc2;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
       yAxis1.setLabel("Szelvények száma");
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Eddigi szelvények");
        series1.getData().add(new XYChart.Data<>("Összes ", bought_tickets));
        series1.getData().add(new XYChart.Data<>("Nyerő ", winner_tickets));
        series1.getData().add(new XYChart.Data<>("Vesztes ", loser_tickets));

        bc1.getData().add(series1);
        Node n = bc1.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: blue");
        n = bc1.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: green");
        n = bc1.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: red");


        yAxis2.setLabel("Kreditek száma");
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Kreditérték");
        series2.getData().add(new XYChart.Data<>("Jelenlegi ", credit));
        series2.getData().add(new XYChart.Data<>("Nyert ", credit_won));
        series2.getData().add(new XYChart.Data<>("Vesztett ", credit_lost));
        series2.getData().add(new XYChart.Data<>("Eljátszott ", credit_used_up));

        bc2.getData().add(series2);
        Node n1 = bc2.lookup(".data0.chart-bar");
        n1.setStyle("-fx-bar-fill: blue");
        n1 = bc2.lookup(".data1.chart-bar");
        n1.setStyle("-fx-bar-fill: green");
        n1 = bc2.lookup(".data2.chart-bar");
        n1.setStyle("-fx-bar-fill: red");

    }
}

