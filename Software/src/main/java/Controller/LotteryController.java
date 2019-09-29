package Controller;

import Modell.Database;
import Modell.LotteryModell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modell.Ticket;

import java.net.URL;
import java.util.ResourceBundle;

public class LotteryController implements Initializable {

    private Database db = Database.getDatabaseInstance();
    private int creditAmount;
    private String user = LoginSystemController.userName;

    @FXML
    public Pane welcomePane;
    @FXML
    public Pane newTicketPane;
    @FXML
    public Pane hmsibPane;
    @FXML
    public Pane statisticsPane;
    @FXML
    public Label newTicketError;
    @FXML
    public Label ticketPrice;
    @FXML
    public Label totalPrice;
    @FXML
    public Label result;
    @FXML
    public Label credit;
    @FXML
    public TextField ticketAmount;
    @FXML
    public TextField hmsibInput;
    @FXML
    public ChoiceBox<String> hmsibChoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showWelcomePane();
        ticketPrice.setText(Ticket.PRICE + " K");
        creditAmount = db.getCredit(user);
        credit.setText(creditAmount + " K");
        hmsibChoice.getItems().addAll("sz", "%");
        hmsibChoice.setValue("sz");
    }

    @FXML
    public void showWelcomePane() {
        welcomePane.setVisible(true);
        newTicketPane.setVisible(false);
        hmsibPane.setVisible(false);
        statisticsPane.setVisible(false);
    }

    @FXML
    public void showNewTicketPane() {
        welcomePane.setVisible(false);
        newTicketPane.setVisible(true);
        hmsibPane.setVisible(false);
        statisticsPane.setVisible(false);
    }

    @FXML
    public void showHMSIBPane() {
        welcomePane.setVisible(false);
        newTicketPane.setVisible(false);
        hmsibPane.setVisible(true);
        statisticsPane.setVisible(false);
    }

    @FXML
    public void showStatisticsPane() {
        welcomePane.setVisible(false);
        newTicketPane.setVisible(false);
        hmsibPane.setVisible(false);
        statisticsPane.setVisible(true);
    }

    @FXML
    public void calculatePrice() {
        totalPrice.setText(LotteryModell.getPriceOf(ticketAmount.getText()));
    }

    @FXML
    private void showNewTicketError(String message) {
        newTicketError.setText(message);
    }

    @FXML
    public void buyTickets() {
        int price = LotteryModell.getTotalPrice(ticketAmount.getText());
        if(price != 0 && creditAmount >= price) {
            creditAmount -= price;
            db.setCredit(user, creditAmount);
            credit.setText(creditAmount + " K");
        }
        else
            if(creditAmount < price)
                showNewTicketError("Nincs elég kredited");
    }

    @FXML
    public void hmsibCalculate() {
        result.setText(LotteryModell.hmsibCalculate(hmsibInput.getText(), hmsibChoice.getSelectionModel().getSelectedItem()));
    }

    public void logOut(ActionEvent actionEvent) {
    }
}
