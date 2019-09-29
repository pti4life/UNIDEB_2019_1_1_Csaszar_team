package modell;

public class Ticket {

    public static final int PRICE = 3;
    public static final int COMBINATIONS = 43949268;

    private int[] numbers = new int[5];

    /**
     * Constructor for Ticket class, which makes Ticket object from
     * <code>int[]</code>.
     * @param nums array, containing the 5 chosen numbers
     */
    public Ticket(int[] nums) {
        numbers = nums;
    }

    /**
     * Constructor for ticket class, which makes Ticket object from
     * 6 <code>int</code>s.
     * @param num1 chosen number 1.
     * @param num2 chosen number 2.
     * @param num3 chosen number 3.
     * @param num4 chosen number 4.
     * @param num5 chosen number 5.
     */
    public Ticket(int num1, int num2, int num3, int num4, int num5) {
        numbers[0] = num1;
        numbers[1] = num2;
        numbers[2] = num3;
        numbers[3] = num4;
        numbers[4] = num5;
    }

    /**
     * Method, which gives information weather the ticket has winner
     * numbers.
     * @param nums numbers of the lottery
     * @return
     */
    public boolean isWinner(int[] nums) {
        return matchCounter(nums) >= 2;
    }

    /**
     * Method, which calculates the number of matches.
     * @param nums numbers of the lottery
     * @return number of matches
     */
    public int matchCounter(int[] nums) {
        int counter = 0;

        for(int i : this.numbers)
            for(int j : nums)
                if(i == j)
                    counter++;

        return counter;
    }


}
