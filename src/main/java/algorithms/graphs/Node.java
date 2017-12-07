package algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private String name;

    private Set<Edge> out;

    private Set<Edge> in;

    private String misPuu;

    public Node(String name) {
        this.name = name;
        out = new HashSet<Edge>();
        in = new HashSet<Edge>();
    }

    public void addEdgeOut(Edge e) {
        out.add(e);
    }

    public void addEdgeIn(Edge e) {
        in.add(e);
    }


}
