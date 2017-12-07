package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Node> nodes;
    private List<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }

    public Graph(List<Node> V, List<Edge> E) {
        this.nodes = V;
        this.edges = E;
    }


    public void addNode(Node n){
        nodes.add(n);
    }

    public void addEdge(Node start, Node end){
        //korrektsuse tagamine (pole hea kiiruse ja efektiivsuse jaoks, aga igaks juhuks)
        if (!nodes.contains(start)) nodes.add(start);
        if (!nodes.contains(end)) nodes.add(end);

        Edge edge = new Edge(start,end);

        start.addEdgeOut(edge);
        end.addEdgeIn(edge);

        edges.add(edge);
    }

}
