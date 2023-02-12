import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Hittegolf {

	public static void main(String[] args) throws IOException {
		Calendar calendar = Calendar.getInstance();
		String date = calendar.get(Calendar.DAY_OF_MONTH) + "_" + calendar.get(Calendar.MONTH) + "_" + calendar.get(Calendar.HOUR_OF_DAY) + "_" + calendar.get(Calendar.MINUTE) + "_" + calendar.get(Calendar.SECOND);

		String path = "src/main/resources/";
		FileReader input = new FileReader(path + "hittegolf/input.txt");
		FileWriter output = new FileWriter(path + "hittegolf/output_" + date + ".txt");

		try (Scanner scanner = new Scanner(input)) {
			int cases = scanner.nextInt();
			output.write("Total testcases: " + cases);

			// testcases
			for (int currentCase = 0; currentCase < cases; currentCase++) {
				output.write("\n\nCurrent testcase: " + (currentCase+1));

				// temperatures
				int tempCount = 1;
				List<Double> temperatures = new ArrayList<>();
				while (scanner.hasNextDouble()) {
					double currentTemperature = scanner.nextDouble();
					temperatures.add(currentTemperature);
					output.write("\n	Temperature reading #" + tempCount + ": " + currentTemperature);
					tempCount++;
				}

				List<Double> heatWave = new ArrayList<>();
				for (double temp : temperatures) {

				}

//				System.out.println((currentCase+1) + " " + (heatWaveStart == -1 ? "geen hittegolf" : (heatWaveStart+1) + " " + heatWave.size()));

				output.write("\n\nTemperature list: " + temperatures);
				output.write("\nPredicted heatwave: " + heatWave);
//				output.write("\nStart of heatwave: " + ((heatWaveStart == -1) ? "no heatwave" : (heatWaveStart+1)));

				output.write("\n-----");
				scanner.next();
			}

			output.close();
		}
	}
}
