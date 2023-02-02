import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VPW {

	public static void main(String[] args) throws IOException {
		String mainPath = "src/main/resources/";
		FileReader file = new FileReader(mainPath + "input.txt");

		try (Scanner sc = new Scanner(file)) {
			int k = sc.nextInt();

			List<List<Integer>> lists = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				int n = sc.nextInt();
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					list.add(sc.nextInt());
				}
				lists.add(list);
			}

			for (int i = 0; i < lists.size(); i++) {
				List<Integer> list = lists.get(i);
				int min = Collections.min(list);
				int max = Collections.max(list);
				System.out.println((i + 1) + " " + min + " " + max);
			}
		}
	}
}
