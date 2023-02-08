import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

// TODO: Add logic to get number of required minimum shelves. (https://www.geeksforgeeks.org/sorting-in-java/)
public class Boekenkast {

	public static void main(String[] args) throws IOException {
		Calendar calendar = Calendar.getInstance();
		String formattedDate = (calendar.get(Calendar.MONTH) + 1) + "_" + calendar.get(Calendar.DAY_OF_MONTH) + "_" + calendar.get(Calendar.HOUR_OF_DAY) + "_" + calendar.get(Calendar.MINUTE);

		// Get's input data
		String mainPath = "src/main/resources/";
		FileReader input = new FileReader(mainPath + "boekenkast/input.txt");
		FileWriter output = new FileWriter(mainPath + "boekenkast/output_" + formattedDate + ".txt");

		/*
		* bsTotal: total amount of bookshelve space per testcase
		* sTotal: total amount of book space per testcase
		* */
		int bsTotal = 0;
		int sTotal = 0;

		/*
		* Tries to read the input data, crashes when reading is unsuccessful
		* */
		try(Scanner scanner = new Scanner(input)) {

			/*
			* Total of testcases in the input file
			* */
			int t = scanner.nextInt();

			output.write("Number of testcases: " + t + "\n");
			output.write("--------------------\n\n");

			/*
			* Loops through every test case
			* */
			for (int i = 0; i < t; i++) {
				output.write("Test case number " + (i+1) + ":\n");
				output.write("	Information about the bookshelves:\n");

				/*
				* bs: total amount of bookshelves in current testcase
				* bsList: empty list which will be populated with every bookshelve length in the current testcase
				* */
				int bs = scanner.nextInt();
				Integer[] bsList = new Integer[bs];

				output.write("		Number of bookshelves: " + bs + "\n");

				/*
				* Loops through every bookshelve size
				* */
				for (int x = 0; x < bs; x++) {
					/*
					* bsS: current bookshelve size
					* */
					int bsS = scanner.nextInt();

					bsTotal += bsS;

					/*
					* Adds current bookshelve length to the list
					* */
					bsList[x] = bsS;
					output.write("		Bookshelve size number " + (x+1) + ": " + bsS + "\n");
				}

				output.write("\n		Bookshelve lengths: " + Arrays.toString(bsList).replace("[", "").replace("]", "") +"\n");

				/*
				* Sorts bookshelve lengths in descending order
				* */
				Arrays.sort(bsList, Collections.reverseOrder());
				output.write("		Bookshelve lengths sorted (desc): " + Arrays.toString(bsList).replace("[", "").replace("]", "") + "\n\n");
				output.write("	Information about the books:\n");

				/*
				* Total amount of books in current testcase
				* */
				int c = scanner.nextInt();
				output.write("		Number of books: " + c + "\n");

				/*
				* Empty list which will be populated with all titles of the current testcase
				* */
				String[] titleList = new String[c];
				for (int b = 0; b < c; b++) {
					int s = scanner.nextInt();
					sTotal += s;

					StringBuilder title = new StringBuilder();
					while(!(scanner.hasNextInt()) && scanner.hasNext()) {
						title.append(scanner.next()).append(" ").trimToSize();
					}

					output.write("		Size of book: " + s + " | Title: " + title + "\n");

					/*
					* Adds current title to the list
					* */
					titleList[b] = title.toString().trim();
				}

				output.write("\n		Titles: " + Arrays.toString(titleList).replace("[", "").replace("]", "") + "\n");

				/*
				* Sorts title alphabetically in ascending order
				* */
				Arrays.sort(titleList);

				output.write("		Titles sorted (asc): " + Arrays.toString(titleList).replace("[", "").replace("]", "") + "\n\n");
				output.write("	Total:\n");

				output.write("		sTotal: " + sTotal + " | bsTotal: " + bsTotal + "\n");
				if (sTotal > bsTotal) {
					output.write("		Actual answer that needs to be displayed: " + (i+1) + " ONMOGELIJK\n\n");
				} else {
					output.write("		Actual answer that needs to be displayed: " + (i+1) + " WIP\n\n");
				}
				output.write("--------------------" + ((i == (t - 1)) ? "" : "\n\n"));
			}

			output.close();
		}
	}
}
