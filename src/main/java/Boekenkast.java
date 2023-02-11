import java.io.IOException;
import java.util.*;

public class Boekenkast {

	public static void main(String[] args) throws IOException {
		try (Scanner scanner = new Scanner(System.in)) {
			int cases = scanner.nextInt();
			for (int currentCase = 0; currentCase < cases; currentCase++) {

				// Bookshelves
				int shelves = scanner.nextInt();
				List<Integer> bookShelves = new ArrayList<>();
				for (int currentShelve = 0; currentShelve < shelves; currentShelve++) {
					int currentShelveSize = scanner.nextInt();
					bookShelves.add(currentShelveSize);
				}

				int books = scanner.nextInt();
				HashMap<String, Integer> booksUnsorted = new HashMap<>();
				if (!(books == 0)) {
					for (int currentBook = 0; currentBook < books; currentBook++) {
						int currentBookSize = scanner.nextInt();

						StringBuilder title = new StringBuilder();
						while (!(scanner.hasNextInt()) && scanner.hasNext()) {
							title.append(scanner.next()).append(" ");
						}

						booksUnsorted.put(title.toString().trim(), currentBookSize);
					}
				}

				bookShelves.sort(Collections.reverseOrder());

				Map<String, Integer> booksSorted = new TreeMap<>(booksUnsorted);
				Collection<Integer> bookSizeCollection = booksSorted.values();
				List<Integer> bookSizes = new ArrayList<>(bookSizeCollection);

				int currentShelf = 0;
				int count = 0;
				for (int book : bookSizes) {
					if (currentShelf < bookShelves.size() && bookShelves.get(currentShelf) >= book) {
						bookShelves.set(currentShelf, bookShelves.get(currentShelf) - book);
					} else if (++currentShelf < bookShelves.size() && bookShelves.get(currentShelf) >= book) {
						bookShelves.set(currentShelf, bookShelves.get(currentShelf) - book);
						count++;
					} else {
						count = -1;
					}
				}

				System.out.println((currentCase + 1) + " " + ((count == -1) ? "ONMOGELIJK" : (bookSizes.isEmpty()) ? "0" : (currentShelf + 1)));
			}
		}
	}
}
