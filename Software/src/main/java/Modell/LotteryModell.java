package Modell;

import modell.Ticket;

import java.util.Arrays;
import java.util.Random;

public class LotteryModell {

    public static String getPriceOf(String ticket) {
        return String.valueOf(getTotalPrice(ticket));
    }

    public static int getTotalPrice(String ticket) {
        System.out.println("TICKET: "+ticket);
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

    public static boolean numbersCorrect(int[] nums) {
        for(int i : nums)
            if(i > 90 || i < 1)
                return false;

        long dist = Arrays.stream(nums).distinct().count();

        return dist == nums.length;
    }

    public static int[] generateNumbers() {
        int[] nums = new int[] {0, 0, 0, 0, 0};

        while(!numbersCorrect(nums)) {
            for(int i = 0; i < 5; i++)
                nums[i] = new Random().nextInt(90)+1;
        }

        return nums;
    }

    public static boolean isWin(int[] nums, Ticket[] tickets) {
        for(Ticket tmp : tickets)
            if(tmp.isWinner(nums))
                return true;

        return false;
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
