package Controller;

import Modell.Database;
import Modell.LotteryModell;
import initial.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modell.Ticket;

import java.net.URL;
import java.util.ResourceBundle;

import static Modell.LotteryModell.*;

public class LotteryController implements Initializable {

    private Database db = Database.getDatabaseInstance();
    private int creditAmount;
    private String user = LoginSystemController.userName;
    private Ticket[] tickets;
    private int counter = 0;

    @FXML
    public Pane welcomePane;
    @FXML
    public Pane newTicketPane;
    @FXML
    public Pane hmsibPane;
    @FXML
    public Pane statisticsPane;
    @FXML
    public Pane drawPane;
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
    public Label ticketsLeft;
    @FXML
    public Label num1Out;
    @FXML
    public Label num2Out;
    @FXML
    public Label num3Out;
    @FXML
    public Label num4Out;
    @FXML
    public Label num5Out;
    @FXML
    public Label losingMessage;
    @FXML
    public TextField ticketAmount;
    @FXML
    public TextField hmsibInput;
    @FXML
    public TextField num1In;
    @FXML
    public TextField num2In;
    @FXML
    public TextField num3In;
    @FXML
    public TextField num4In;
    @FXML
    public TextField num5In;
    @FXML
    public ChoiceBox<String> hmsibChoice;
    @FXML
    public Button drawButton;
    @FXML
    public Button backButton;

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
        drawPane.setVisible(false);
    }

    @FXML
    public void showNewTicketPane() {
        welcomePane.setVisible(false);
        newTicketPane.setVisible(true);
        hmsibPane.setVisible(false);
        statisticsPane.setVisible(false);
        drawPane.setVisible(false);
    }

    @FXML
    public void showHMSIBPane() {
        welcomePane.setVisible(false);
        newTicketPane.setVisible(false);
        hmsibPane.setVisible(true);
        statisticsPane.setVisible(false);
        drawPane.setVisible(false);
    }

    @FXML
    public void showStatisticsPane() {
        welcomePane.setVisible(false);
        newTicketPane.setVisible(false);
        hmsibPane.setVisible(false);
        statisticsPane.setVisible(true);
        drawPane.setVisible(false);
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
            db.setUsedUpCredit(user, db.getUsedUpCredit(user)+price);
            db.setBoughtTickets(user, db.getBoughtTickets(user) + Integer.parseInt(ticketAmount.getText()));
            credit.setText(creditAmount + " K");
            drawPane.setVisible(true);
            ticketsLeft.setText(ticketAmount.getText());
            tickets = new Ticket[Integer.parseInt(ticketAmount.getText())];
        }
        else
            if(creditAmount < price)
                showNewTicketError("Nincs elég kredited");
    }

    @FXML
    public void fillTicket() {
        int[] numbers = getNumbers();
        if(numbersCorrect(numbers)) {
            tickets[counter] = new Ticket(numbers);
            counter++;
            ticketsLeft.setText(Integer.parseInt(ticketAmount.getText())-counter + "");
        }
        if(counter == Integer.parseInt(ticketAmount.getText()))
            drawButton.setVisible(true);
    }

    @FXML
    private int[] getNumbers() {
        int[] nums = new int[] {0, 0, 0, 0, 0};

        try {
            nums[0] = Integer.parseInt(num1In.getText());
            nums[1] = Integer.parseInt(num2In.getText());
            nums[2] = Integer.parseInt(num3In.getText());
            nums[3] = Integer.parseInt(num4In.getText());
            nums[4] = Integer.parseInt(num5In.getText());
        }
        catch (Exception ignored) {}

        return nums;
    }

    @FXML
    public void doDraw() {
        int[] numbers = generateNumbers();
        setNumbers(numbers);

        if(isWin(numbers, tickets))
            winningSituation(numbers);
        else
            losingSituation();

        backButton.setVisible(true);
    }

    @FXML
    private void winningSituation(int[] numbers) {
        int wonCr = 0;
        int winner = 0;

        for(Ticket tmp : tickets)
            if(tmp.isWinner(numbers)) {
                winner++;
                switch (tmp.matchCounter(numbers)) {
                    case 1:
                        wonCr += Ticket.MATCH1;
                        break;
                    case 2:
                        wonCr += Ticket.MATCH2;
                        break;
                    case 3:
                        wonCr += Ticket.MATCH3;
                        break;
                    case 4:
                        wonCr += Ticket.MATCH4;
                        break;
                    case 5:
                        wonCr += Ticket.MATCH5;
                        break;
                }
            }

        losingMessage.setText("Nyertél" + wonCr + "Kreditet!!");
        creditAmount += wonCr;
        credit.setText(creditAmount + "");
        db.setCreditWon(user, db.getCreditWon(user) + wonCr);
        db.setCredit(user, creditAmount);
        db.setWinnerTickets(user, db.getWinnerTickets(user) + winner);
    }

    @FXML
    private void losingSituation() {
        losingMessage.setText("Sajnos nem nyertél...");
        losingMessage.setVisible(true);
    }

    @FXML
    private void setNumbers(int[] nums) {
        num1Out.setText(nums[0] + "");
        num2Out.setText(nums[1] + "");
        num3Out.setText(nums[2] + "");
        num4Out.setText(nums[3] + "");
        num5Out.setText(nums[4] + "");
    }

    @FXML
    public void hmsibCalculate() {
        result.setText(LotteryModell.hmsibCalculate(hmsibInput.getText(), hmsibChoice.getSelectionModel().getSelectedItem()));
    }

    @FXML
    public void logOut() {
        Main.setScene("LoginSystemView.fxml");
    }
}
