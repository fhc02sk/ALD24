package A08_GraphZusammen;



import A08_GraphZusammen.Graph;
import A10_DijkstraPQShortestPath.WeightedEdge;

import java.util.List;
import java.util.Stack;


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
			deepSearch2(g, i, counter);
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
		Stack<Integer> stack = new Stack<>();

		stack.push(i); // wurzel am stack ablegen

		while (!stack.isEmpty()){
			int v = stack.pop();

			if (visited[v] != -1)
				continue; // achtung bei diesem knoten waren wir schon mal

			visited[v] = comp;

			List<WeightedEdge> edges = g.getEdges(v);
			for (WeightedEdge we : edges)
				stack.push(we.to_vertex);
		}
	}

}