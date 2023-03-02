import java.io.FileReader;
import java.util.*;

public class Aanwerving {

    public static void main(String[] args) throws Exception {
        String path = "src/resources/";
        FileReader input = new FileReader(path + "input.txt");

        try (Scanner scanner = new Scanner(input)) {
            int cases = scanner.nextInt();

            for (int i = 0; i < cases; i++) {
                int candidates = scanner.nextInt();
                int verkenning = scanner.nextInt();

                ArrayList<Integer> verkenningScores = new ArrayList<>();
                for (int cv = 0; cv < verkenning; cv++) {
                    verkenningScores.add(scanner.nextInt());
                }

                int max = Collections.max(verkenningScores);

                List<Integer> scores = new ArrayList<>();
                int employee = 0;
                for (int cs = verkenning; cs < candidates; cs++) {
                    int currentScore = scanner.nextInt();
                    scores.add(currentScore);
                    if ((cs+1) == candidates) {
                        employee = currentScore;
                        break;
                    }
                    if (currentScore >= max) {
                        employee = currentScore;
                        break;
                    }
                }

                System.out.println((i+1) + " " + ((scores.indexOf(employee)) + 4) + " " + employee);

                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
    }
}
