import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Boekenkast {

	public static void main(String[] args) throws FileNotFoundException {
		String mainPath = "src/main/resources/";
		FileReader file = new FileReader(mainPath + "boekenkast/input.txt");

		try(Scanner scanner = new Scanner(file)) {
			int t = scanner.nextInt();
			System.out.println("Number of testcases: " + t + "\n");

			for (int i = 0; i < t; i++) {
				int bs = scanner.nextInt();
				System.out.println("Number of bookshelves: " + bs);

				for (int x = 0; x < bs; x++) {
					System.out.println("Bookshelve size number #" + (x+1) + " " + scanner.nextInt());
				}

				int c = scanner.nextInt();
				System.out.println("Number of books: " + c);

				for (int b = 0; b < c; b++) {
					int s = scanner.nextInt();
					System.out.print("Size of book: " + s + " | Title: ");

					StringBuilder title = new StringBuilder();
					while(!(scanner.hasNextInt()) && scanner.hasNext()) {
						title.append(scanner.next()).append(" ").trimToSize();
					}
					System.out.println(title);
				}
				System.out.println();
			}
		}
	}
}
