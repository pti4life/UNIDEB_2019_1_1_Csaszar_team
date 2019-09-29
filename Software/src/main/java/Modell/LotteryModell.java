package Modell;

import modell.Ticket;

public class LotteryModell {

    public static String getPriceOf(String ticket) {
        return String.valueOf(getTotalPrice(ticket));
    }

    public static int getTotalPrice(String ticket) {
        int result = 0;

        try {
            result = Integer.parseInt(ticket);
        }
        catch (Exception ignored) {}

        return result* Ticket.PRICE;
    }

    public static String hmsibCalculate(String amount, String unit) {
        if(unit.equals("%"))
            return calculateTicketAmount(amount);
        else
            return calculateChance(amount);
    }

    private static String calculateTicketAmount(String amount) {
        double chance = 0;

        try {
            chance = Double.parseDouble(amount) / 100;
        }
        catch (Exception ignored) {}

        return String.valueOf(chance* Ticket.COMBINATIONS);
    }

    private static String calculateChance(String amount) {
        double chance = 0;

        try {
            chance = (double) Integer.parseInt(amount)/ Ticket.COMBINATIONS;
        }
        catch (Exception ignored) {}

        return String.valueOf(chance);
    }
}
