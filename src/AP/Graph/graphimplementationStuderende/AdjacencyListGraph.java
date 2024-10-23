package AP.Graph.graphimplementationStuderende;


import java.util.*;

public class AdjacencyListGraph<V> implements Graph<V> {
    // List with all the vertices in the graph.
    private List<V> vertices;
    // Map with pairs containing (vertex, list of edges),
    // where list of edges is the incident edges to the vertex.
    // Note: Each edge is in 2 lists of incident edges.
    private Map<V, List<Edge<V>>> edges = new HashMap();

    /**
     * Construct an empty graph
     */
    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
        edges = new LinkedHashMap<>();
    }

    @Override
    /** Return the number of vertices in the graph */
    public int numVertices() {
        return vertices.size();
    }

    @Override
    /** Return the number of edges in the graph */
    public int numEdges() {
        int size = 0;
        for (List<Edge<V>> list : edges.values()) {
            size += list.size();
        }
        return size / 2;
    }

    @Override
    /** Return the vertices in the graph */
    public List<V> vertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    /** Return the edges in the graph */
    public List<Edge<V>> edges() {
        List<Edge<V>> edgesToReturn = new ArrayList<>();
        for (List<Edge<V>> e : edges.values()) {
            edgesToReturn.addAll(e);
        }
        return edgesToReturn;
    }


    @Override
    /** Return the neighbors of the specified vertex */
    public List<V> neighbors(V v) {
        List<V> neighbors = new ArrayList<>();
        List<Edge<V>> theEdgesToV = edges.get(v);
        for (Edge<V> edge : theEdgesToV){
            if (!edge.getU().equals(v)){
                neighbors.add(edge.getU());
            } else if (!edge.getV().equals(v)){
                neighbors.add(edge.getV());
            }
        }
        return neighbors;
    }


    @Override
    /** Return the incident edges of vertex v */
    public List<Edge<V>> incidentEdges(V v) {
        return edges.get(v);
    }

    @Override
    /** Return the degree for a specified vertex */
    public int degree(V v) {
        //TODO
        return -1;
    }

    @Override

    public boolean areAdjacent(V v, V u) {
        List<Edge<V>> VEdgelist = edges.get(v);
        int index = 0;
        Edge<V> current = VEdgelist.get(index);
        boolean found = false;
        while (!found && index < VEdgelist.size()){
            if (current.getU().equals(u) || current.getU().equals(v)) {
                found = true;
            } else {
                index++;
            }
        }
        return found;
    }


    @Override
    /** Print the edges */
    public void printGraph() {
        for (V v : vertices) {
            List<Edge<V>> incidentEdges = edges.get(v);
            System.out.print("Vertex: " + v);
            System.out.println("\tIncident edges: " + incidentEdges);
        }
    }


    @Override
    /**
     * Add a vertex to the graph.
     * Pre: The vertex is not in the graph before this addition.     */
    public void addVertex(V v) {
        vertices.add(v);
        edges.put(v, new ArrayList<Edge<V>>());
    }

    @Override
    /**
     * Add an edge with weight 0 between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     */
    public void addEdge(V v, V u) {
        Edge<V> newEdge = new Edge<>(v, u, 0);
        edges.get(v).add(newEdge);
        edges.get(u).add(newEdge);
    }

    @Override
    /** Add an edge to the graph */
    public void addEdge(V v, V u, int e) {
        Edge<V> newEdge = new Edge<>(v, u, e);
        edges.get(v).add(newEdge);
        edges.get(u).add(newEdge);
    }


    @Override
    /**
     * Remove the specified vertex from the graph.
     * Pre: The vertex is in the graph
     */
    public void removeVertex(V v) {
        //TODO
    }

    private void removeVertex(V v, List<Edge<V>> list) {
        //TODO
    }

    @Override
    /**
     * Remove the edge between the specified vertices from the graph.
     * Pre: The vertices are vertices in the graph,
     *   and The graph has an edge between the vertices.
     */
    public void removeEdge(V v, V u) {
        List<Edge<V>> samletEdgeListe = new ArrayList<>(edges.get(v));
        samletEdgeListe.addAll(edges.get(u));
        Edge<V> toRemove = null;
        int index = 0;
        boolean found = false;
        while (!found && index <= edges.get(v).size()) {
            boolean checkFirst = edges.get(v).get(index).getU().equals(u) && samletEdgeListe.get(index).getV().equals(v);
            boolean checkSecond = samletEdgeListe.get(index).getU().equals(v) && samletEdgeListe.get(index).getV().equals(u);
            if (checkFirst || checkSecond) {
                toRemove = samletEdgeListe.get(index);
                found = true;
            } else {
                index++;
            }
        }
        edges.get(u).remove(toRemove);
        edges.get(v).remove(toRemove);
    }


}

