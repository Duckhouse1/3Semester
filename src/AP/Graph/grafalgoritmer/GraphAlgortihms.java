package AP.Graph.grafalgoritmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphAlgortihms {
    /**
     * Returnerer en liste af grafens knuder fundet ved et dybddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        List<V> besøgt = new ArrayList<>();
        besøgt.add(v);

        return dfs(graph,v,besøgt);
    }
    private static <V> List<V> dfs(Graph<V> graph, V v, List<V> besøgte) {
        for (V vertixes : graph.neighbors(v)){
            if (!besøgte.contains(vertixes)){
                besøgte.add(vertixes);
                dfs(graph,vertixes,besøgte);
            }
        }

        return besøgte;
    }
        /**
         * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
         * grafen med startknude v.
         */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        List<V> besøgte = new ArrayList<>();
        List<V> knudeKø = new LinkedList<>();
        knudeKø.add(v);
        while (!knudeKø.isEmpty()){
            V førsteKnude = knudeKø.get(0);
            knudeKø.remove(førsteKnude);
            besøgte.add(førsteKnude);
            for (V naboKnude : graph.neighbors(førsteKnude)){
                if (!besøgte.contains(naboKnude) && !knudeKø.contains(naboKnude)){
                    knudeKø.add(naboKnude);
                }
            }
        }
        return besøgte;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        return bfs(graph,graph.vertices().get(0)).size() == (graph.vertices().size());
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        return bfs(graph,v1).contains(v2);
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Set<Edge> mst(Graph<V> graph) {
        // TODO Opgave 7
        return null;
    }

    public static void main(String[] args) {
        EdgeListGraph graph = new EdgeListGraph<>();

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

        System.out.println(dfs(graph,123));
        System.out.println(bfs(graph,123));

        System.out.println(connected(graph));
    }
}
