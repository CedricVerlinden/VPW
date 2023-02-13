import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hittegolf {

	public static void main(String[] args) throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int cases = scanner.nextInt();

			for (int currentCase = 0; currentCase < cases; currentCase++) {

				List<Double> temperatures = new ArrayList<>();
				while (scanner.hasNextDouble()) {
					double currentTemperature = scanner.nextDouble();
					temperatures.add(currentTemperature);
				}

				double prev = -1;
				int thirty = 0;
				int count = 0;
				int heatWaveStart = -1;
				List<Double> heatWave = new ArrayList<>();
				for (double temp : temperatures) {
					if (temp < 25) {
						if (heatWave.size() >= 5 && thirty >= 3) {
							break;
						}
						heatWave.clear();
						thirty = 0;
						count++;
						heatWaveStart = -1;
						prev = temp;
						continue;
					}

					if (temp >= 30) {
						thirty++;
					}

					if (prev >= 25 || prev == -1 || heatWave.isEmpty()) {
						if (heatWave.isEmpty()) {
							heatWaveStart = count+1;
						}
						heatWave.add(temp);
						count++;
					}

					prev = temp;
				}

				System.out.println((currentCase+1) + " " + (heatWaveStart == -1 ? "geen hittegolf" : (heatWaveStart) + " " + heatWave.size()));
				scanner.next();
			}
		}
	}
}
