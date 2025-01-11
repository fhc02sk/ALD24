package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {

		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {
		if (left >= right) // 0, 1 Element zu sortieren
			return;

		int p = partition(personen, left, right);
		// int p = > neue Index von Partion
		sort(personen, left, p - 1);
		sort(personen, p + 1, right);

	}

	private int partition(Person[] personen, int left, int right) {

		Person pivot = personen[right]; // Pivot Element gemert
		int i = left - 1; // (left = 0) bzw. i = -1 // left -1, weil sofort in do-while i++ und somit wieder korrekt
		int k = right; // k wird mit k-- korekt gesetzt

		do {
			// von links, läuft die Schleife, solange das personen[i] < pivot
			do {
				i++;
			} while (i <= right && personen[i].compareTo(pivot) < 0);
			// wenn wir sind, personen[i] > pivot

			do {
				k--;
			} while (k >= left && personen[k].compareTo(pivot) > 0);
			// wenn wir sind, personen[k] < pivot

			// personen[i] > pivot && personen[k] < pivot
			if (i < k) {
				// swap
				Person temp = personen[i];
				personen[i] = personen[k];
				personen[k] = temp;
			}
		} while (i < k);

		// i >= k => Pivot Element an die richtige Stelle positioniert
		Person temp = personen[i];
		personen[i] = pivot;
		personen[right] = temp;

		return i; // neuer Index vom PivotElement
	}
}