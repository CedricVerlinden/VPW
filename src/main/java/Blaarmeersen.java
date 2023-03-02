import java.util.Scanner;

public class Blaarmeersen {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int k = scanner.nextInt();

            for (int i = 0; i < k; i++) {
                int c = scanner.nextInt();
                int ig = scanner.nextInt();
                double percentage = (c * 0.80);

                System.out.print((i+1));

                int binnen = 0;
                for (int cig = 0; cig < ig; cig++) {
                    int client = scanner.nextInt();
                    int total = binnen += client;

                    if (total > c) {
                        System.out.print(" r");
                    } else if (total <= percentage) {
                        System.out.print(" g");
                    } else if (total > percentage) {
                        System.out.print(" o");
                    }
                }

                System.out.println();
            }
        }
    }
}
