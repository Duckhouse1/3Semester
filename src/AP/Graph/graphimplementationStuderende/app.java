package AP.Graph.graphimplementationStuderende;

public class app {
    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph();

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

//        graph.removeVertex(15);
//        graph.removeEdge(38,123);

        System.out.println(graph.edges());
//        System.out.println(graph.areAdjacent(6,66));






    }
}
