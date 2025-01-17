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

		// Initialisierung
		int size = g.numVertices();
		visited = new boolean[size];
		follow = new HashMap<Integer, Integer>(size + 1);

		for (int i = 0; i < size; i++) {
			if (visited[i]) // Konten wurde in vorhergehenden durchlauf schon besucht
				continue;

			// Tiefensuche
			List<Integer> result = checkForCycle(i, -1);
			if (result != null){
				return result;
			}
		}

		return null; // default
	}

	private List<Integer> checkForCycle(Integer v, Integer pred) {

		// follow überprüfen
		if (follow.containsKey(v)) {
			// dann waren wir dort als vorgänger schon mal
			return foundCycle(v);
		}
		// check if visted is true
		if (visited[v]) // knoten wurde schon mal besucht
			return null;

		// implementierung
		visited[v] = true;
		follow.put(pred, v); // eine route

		List<WeightedEdge> edges = g.getEdges(v);
		for (WeightedEdge we : edges) {
			// code: gerichtet oder ungerichtet
			if (we.to_vertex == pred && !g.isDirected()) {
				continue;
			}

			List<Integer> route = checkForCycle(we.to_vertex, v); // rekursion
			if (route != null)
				return route;
		}

		follow.remove(pred); // Backtracking / Rückwärtslaufen / Aufräumen

		return null;			// kein Zyklus gefunden
	}

	/**
	 * Generiert Liste des Weges aus follow-HashMap
	 * @param start Startpunkt des Zyklus
	 * @return Liste der Knoten des Zyklus in passender Besuchsreihenfolge
	 */
	private List<Integer> foundCycle(Integer start) {
		List<Integer> cycle = new ArrayList<Integer>();

		// follow, start
		/*
			2, 3
			3, 4
			4, 5
			5, 2 => 2, 3, 4, 5, 2
		 */

		Integer current = start;
		while (current != null) {
			cycle.add(current);
			current = follow.get(current);
		}

		cycle.add(start);

		return cycle;
	}


}