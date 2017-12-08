package algorithms.graphs;

public class Edge {

    private Node start;
    private Node end;

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return start + " -> " + end;
    }

    @Override
    public boolean equals(Object obj) {
        Edge e = (Edge) obj;
        return e.getStart().equals(this.start) && e.getEnd().equals(this.end);
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }
}
