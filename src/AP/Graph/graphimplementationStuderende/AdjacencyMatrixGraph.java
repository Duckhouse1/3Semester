package AP.Graph.graphimplementationStuderende;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrixGraph<V> implements Graph<V> {

    private Map<V, Integer> vertices = new HashMap<V, Integer>(); // Store vertices with index as value
    private List<Edge<V>> edges = new ArrayList<>(); // Store edges

    private Edge<V>[][] matrix;
    private int vertexNr;

    private static final int N = 15;

    /**
     * Construct an empty graph
     */
    public AdjacencyMatrixGraph() {
        matrix = (Edge<V>[][]) new Edge[N][N];
        vertexNr = 0;

    }

    @Override
    /** Return the number of vertices in the graph */
    public int numVertices() {
        return vertices.size();
    }

    @Override
    /** Return the number of edges in the graph */
    public int numEdges() {
        return edges.size();
    }

    @Override
    /** Return a list with the vertices in the graph. */
    public List<V> vertices() {
        return new ArrayList<>(vertices.keySet());
    }

    @Override
    /** Return a list with the edges in the graph. */
    public List<Edge<V>> edges() {
        return new ArrayList<Edge<V>>(edges);
    }


    @Override
    /**
     * Return a list with the neighbors of the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public List<V> neighbors(V v) {
        List<V> neighbors = new ArrayList<>();
        int index = vertices.get(v);
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] != null){
                if (!matrix[index][i].getU().equals(v)){
                    neighbors.add(matrix[index][i].getU());
                } else {
                    neighbors.add(matrix[index][i].getV());
                }
            }
        }
        return neighbors;
    }


    @Override
    /**
     * Return the incident edges to the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public List<Edge<V>> incidentEdges(V v) {
        List<Edge<V>> incidentEdges = new ArrayList<>();
        int indexValue = vertices.get(v);
        for (int i = 0; i < matrix[indexValue].length; i++) {
            if (matrix[indexValue][i] != null){
                incidentEdges.add(matrix[indexValue][i]);
            }
        }
        return incidentEdges;
    }

    @Override
    /**
     * Return the degree for the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public int degree(V v) {
        int degreeCounter = 0;
        int index = vertices.get(v);
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] != null){
                degreeCounter++;
            }
        }
        return degreeCounter;

    }

    @Override
    /**
     * Return true, if the specified vertices are neighbors.
     * Pre: The vertices are vertices in the graph.
     */
    public boolean areAdjacent(V v, V u) {
        return matrix[vertices.get(v)][vertices.get(u)] != null;
    }

    @Override
    /** Print the vertices and the edges. */
    public void printGraph() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] +"|");
            }
            System.out.println();
        }
    }


    @Override
    /**
     * Add a vertex to the graph.
     * Pre: The vertex is not in the graph before this addition.     */
    public void addVertex(V v) {
        vertices.put(v,vertexNr);
        vertexNr++;
    }

    @Override
    /**
     * Add an edge with weight 0 between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     */
    public void addEdge(V v, V u) {
        // TODO
        Edge<V> newEdge = new Edge<>(v,u,0);
        edges.add(newEdge);
        matrix[vertices.get(v)][vertices.get(u)] = newEdge;
    }

    @Override
    /**
     * Add an edge with the specified weight between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     * Pre: The weight is not negative.
     */
    public void addEdge(V v, V u, int e) {
        Edge<V> newEdge = new Edge<>(v,u,e);
        edges.add(newEdge);
        matrix[vertices.get(v)][vertices.get(u)] = newEdge;
    }

    @Override
    /**
     * Remove the specified vertex from the graph.
     * Pre: The vertex is in the graph
     */
    public void removeVertex(V v) {
        //TODO
    }

    @Override
    /**
     * Remove the edge between the specified vertices from the graph.
     * Pre: The vertices are vertices in the graph,
     *   and The graph has an edge between the vertices.
     */
    public void removeEdge(V v, V u) {
//       TODO

    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph matrixGraph = new AdjacencyMatrixGraph();

        matrixGraph.addVertex(20);
        matrixGraph.addVertex(10);
        matrixGraph.addVertex(1);

        matrixGraph.addEdge(20,10,8);
        matrixGraph.addEdge(1,10,12);
        matrixGraph.addEdge(1,20,4);

        matrixGraph.printGraph();
    }


}

