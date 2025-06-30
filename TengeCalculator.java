import java.util.Scanner;

public class TengeCalculator {

    private static final int[] VALUES = { 20_000, 10_000, 5_000, 2_000, 1_000, 500,
            200, 100, 50, 20, 10, 5, 2, 1 };

    private static final String[] TITLES = { "20,000 note(s): ", "10,000 note(s): ", "5,000 note(s): ",
            "2,000 note(s): ", "1,000 note(s): ", "500 note(s): ", "200 coin(s): ", "100 coin(s): ",
            "50 coin(s): ", "20 coin(s): ", "10 coin(s): ", "5 coin(s): ", "2 coin(s): ", "1 coin(s): "};

    private static void tengeBreakdown(long remainingTenge) {
        for (int i = 0; i < VALUES.length; i++) {
            if (remainingTenge >= VALUES[i]) {
                System.out.printf("%s%d%n", TITLES[i], remainingTenge / VALUES[i]);
                remainingTenge %= VALUES[i];
            }
        }
    }

    private static long userPrompt(Scanner input, String msg) {
        while (true) {
            System.out.print(msg);
            if(input.hasNextLong()) {
                long tengeAmount = input.nextLong();
                if(tengeAmount >= 0) {
                    return tengeAmount;
                }
                System.out.println("Amount cannot be negative");
            } else {
                System.out.println("Please enter a whole number");
                input.next();
            }

        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            long remainingTenge = userPrompt(input, "Enter tenge amount: ");
            System.out.println(remainingTenge + " tenge consists of: ");
            tengeBreakdown(remainingTenge);
        }
    }
}
