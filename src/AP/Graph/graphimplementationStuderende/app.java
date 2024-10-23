package AP.Graph.graphimplementationStuderende;

public class app {
    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();
//        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph<>();
//        EdgeListGraph graph = new EdgeListGraph<>();
        graph.addVertex(15);
        graph.addVertex(38);
        graph.addVertex(6);
        graph.addVertex(123);
        graph.addVertex(66);

        graph.addEdge(15,38,10);
        graph.addEdge(15,6,23);
        graph.addEdge(15,66,90);

        graph.addEdge(38,123,55);
        graph.addEdge(38,66,2);

        graph.addEdge(123,6,7);
        graph.addEdge(123,66,76);

        graph.addEdge(66,6,8);

        graph.printGraph();

        graph.removeEdge(15,66);
        System.out.println("Fjernet edge mellem 15 og 66");
        graph.printGraph();
        System.out.println("alle Edges:");
        System.out.println(graph.edges());

        System.out.println("Alle edges til 66:");
        System.out.println(graph.incidentEdges(66));
        System.out.println(graph.areAdjacent(15,123));
        System.out.println(graph.neighbors(66));
        System.out.println(graph.degree(66));

        System.out.println("Fjerne knuden 66");
        graph.removeVertex(66);
        graph.printGraph();



    }
}
