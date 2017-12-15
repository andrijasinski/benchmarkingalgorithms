package algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private String name;

    private Set<Edge> out;

    private Set<Edge> in;

    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Set<Edge> getOut() {
        return out;
    }

    public Set<Edge> getIn() {
        return in;
    }

    public Node(String name) {
        this.name = name;
        out = new HashSet<Edge>();
        in = new HashSet<Edge>();
    }

    public Set<Edge> getEdges(){
        Set<Edge> temp = new HashSet<>(out);
        temp.addAll(in);
        return temp;
    }

    public void addEdgeOut(Edge e) {
        out.add(e);
    }

    public void addEdgeIn(Edge e) {
        in.add(e);
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Node) obj).getName());
    }
}
