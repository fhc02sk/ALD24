package A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {

		boolean hasSwapped = false;

		for (int i = 0; i < personen.length - 1; i++) {
			if (personen[i].compareTo(personen[i + 1]) > 0) {

				hasSwapped = true;
				Person tmp = personen[i];
				personen[i] = personen[i + 1];
				personen[i + 1] = tmp;
			}
		}

		if (hasSwapped)
			sort(personen);
	}

	public void sort2(Person[] personen) {

		for (int j = 0; j < personen.length; j++) {

			boolean hasSwapped = false;

			for (int i = 0; i < personen.length - 1 - j; i++) {
				if (personen[i].compareTo(personen[i + 1]) > 0) {

					hasSwapped = true;
					Person tmp = personen[i];
					personen[i] = personen[i + 1];
					personen[i + 1] = tmp;
				}
			}

			if (hasSwapped == false)
				return;
		}
	}

	// average / worst
	// n * n = n²
	// n * ( n - 1) = n²

	// best
	// O(n)
	
}
