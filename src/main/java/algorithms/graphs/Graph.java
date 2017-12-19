package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {

    private List<Node> nodes;
    private List<Edge> edges;
    private Random random;

    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }

    public Graph(List<Node> V, List<Edge> E) {
        this.nodes = V;
        this.edges = E;
    }

    public Graph(Graph g){
        this.nodes = g.getNodes();
        this.edges = g.getEdges();
    }

    public int getStartingPoint(){
        // Returns an index of node with greatest amount of outgoing edges
        int res = 0;
        int lastMax = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getOut().size() > lastMax) {
                res = i;
                lastMax = nodes.get(i).getOut().size();
            }
        }
        return res;
    }

    public void setAllUnvisited(){
        for (Node node : nodes) {
            node.setVisited(false);
        }
    }

    public void addNodes(List<Node> n) {nodes.addAll(n);}

    public void addEdges(List<Edge> e) {edges.addAll(e);}

    public void addNode(Node n){
        nodes.add(n);
    }

    public void addEdge(Node start, Node end){
        if (!nodes.contains(start)) nodes.add(start);
        if (!nodes.contains(end)) nodes.add(end);
        if (edges.contains(new Edge(start, end)) || edges.contains(new Edge(end, start))) return;

        Edge edge = new Edge(start,end);

        start.addEdgeOut(edge);
        end.addEdgeIn(edge);

        edges.add(edge);
    }

    public void generateEdges(){
        random = new Random();
        for (Node n : nodes) {
            ArrayList<Node> temp = new ArrayList<>(this.nodes);
            temp.remove(n);
            generateEdges(n, temp);
        }
    }

    private void generateEdges(Node node, List<Node> nodes){
//        if (random.nextDouble() < 0.4) return;
        Node n = nodes.get(random.nextInt(nodes.size()));
        addEdge(node, n);
        if (random.nextDouble() < 0.35 && node.getOut().size() < nodes.size()) generateEdges(node, nodes);
    }

    public void generateGraph(int amountOfVerices){
        random = new Random();
        for (int i = 1; i <= amountOfVerices; i++) {
            nodes.add(new Node(Integer.toString(i)));
        }
        generateEdges();
    }

    public String toString() {
        String s = "";
        s = s + "Graph G {\n";
        for (Edge e : edges) {
            String nimi = e.toString().replace("-", "").replace(">", "--");
            s = s + "    " + nimi
                    + "[label = \"" + "\"]\n";
        }
        s = s + "}";
        return s;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}
