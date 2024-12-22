package A10_DijkstraPQShortestPath;


import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;

	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}

	/**
	 * Startentfernung initialisieren
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i = 0; i < numv; i++) {
			dist[i] = 9999; // Summen im Graph d�rfen nie mehr ergeben
			pred[i] = -1; // Vorg�nger mit -1 bef�llen
		}
	}

	/**
	 * Berechnet *alle* k�rzesten Wege ausgehend vom Startknoten Setzt dist[]-
	 * und pred[]-Arrays, kein R�ckgabewert
	 * 
	 * @param from
	 *            Startknoten
	 */
	protected boolean calculatePath(int from, int to) {

		// TODO: IHRE IMPLEMENTIERUNG
		VertexHeap heap = new VertexHeap(graph.numVertices());

		for (int i = 0; i < graph.numVertices(); i++) {
			heap.insert(new Vertex(i, dist[i]));
		}
		dist[from] = 0;
		heap.setCost(from, 0);

		// algorithmus

		while (!heap.isEmpty()) {
			Vertex v = heap.remove();

			List<WeightedEdge> edges = graph.getEdges(v.vertex);
			for (WeightedEdge we : edges) {
				int newWeight = dist[v.vertex] + we.weight;
				if (newWeight < dist[we.to_vertex]) {
					dist[we.to_vertex] = newWeight;
					pred[we.to_vertex] = we.from_vertex;
					heap.setCost(we.to_vertex, newWeight);
				}
			}
		}

		return dist[to] < 9999;
	}
}
