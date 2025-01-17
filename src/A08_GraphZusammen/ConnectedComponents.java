package A08_GraphZusammen;



import A08_GraphZusammen.Graph;
import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.List;


public class ConnectedComponents {

	private int[] visited;

	/**
	 * Retourniert die Anzahl der zusammenhaengenden Komponenten eines Graphen
	 * @param g zu pruefender Graph
	 * @return Anzahl der Komponenten
	 */
	public int getNumberOfComponents(Graph g) {
		int size = g.numVertices(); // Anzahl Knoten im Graphen
		visited = new int[size];

		// Initialisierung
		for (int i = 0; i < size; i++)
			visited[i] = -1;

		int counter = 0;
		for (int i = 0; i < size; i++) {
			if (visited[i] != -1)
				continue;

			counter++;
			deepSearch(g, i, counter);
		}

		return counter;
	}

	private void deepSearch(Graph g, int i, int comp) {
		if (visited[i] != -1)
			return;

		visited[i] = comp;

		List<WeightedEdge> wedges = g.getEdges(i);
		for (WeightedEdge we : wedges) {
			deepSearch(g, we.to_vertex, comp);
		}
	}

	private void deepSearch2(Graph g, int i, int comp) {

	}

}