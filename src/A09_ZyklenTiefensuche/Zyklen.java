package A09_ZyklenTiefensuche;

import java.util.*;
import A10_DijkstraPQShortestPath.WeightedEdge;

public class Zyklen {


	private boolean visited[];

	private HashMap<Integer, Integer> follow;

	private Graph g;

	public Zyklen(Graph g) {
		this.g = g;
	}

	/**
	 * Retourniert einen Zyklus eines Graphen, sofern einer existiert
	 * @return Anzahl der Komponenten
	 */
	public List<Integer> getCycle() {
		int n = g.numVertices();
		visited = new boolean[n];
		follow = new HashMap<Integer, Integer>(n);
		for (int i=0; i < n; i++) {		// der Reihe nach mit allen Knoten durchmachen
			if (visited[i]) {
				continue;
			}
			List<Integer> res = checkForCycle(i, -1);
			if (res != null) {			// Zyklus gefunden?
				return res;
			}
		}
		return null;
	}

	private List<Integer> checkForCycle(Integer v, Integer pred) {

		return null;			// kein Zyklus gefunden
	}

	/**
	 * Generiert Liste des Weges aus follow-HashMap
	 * @param start Startpunkt des Zyklus
	 * @return Liste der Knoten des Zyklus in passender Besuchsreihenfolge
	 */
	private List<Integer> foundCycle(Integer start) {
		List<Integer> cycle = new ArrayList<Integer>();

		return cycle;
	}


}