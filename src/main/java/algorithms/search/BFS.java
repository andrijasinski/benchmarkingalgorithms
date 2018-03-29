package algorithms.search;

import algorithms.graphs.Edge;
import algorithms.graphs.Graph;
import algorithms.graphs.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private Graph g;

    private Queue<Node> queue;

    private StringBuilder result;

    public void setUp(Graph g){

        this.g = g;
        queue = new LinkedList<>();
        result = new StringBuilder();
    }

    public void start(int entryPoint){
        List<Node> nodes = new ArrayList<>(g.getNodes());

        Node node = nodes.get(entryPoint);
        node.setVisited(true);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            result.append(n.getName()).append(" ");

            for (Edge edge : n.getOut()) {
                Node next = edge.getEnd();
                if (!next.isVisited()){
                    next.setVisited(true);
                    queue.add(next);
                }
            }
        }
    }

    public String[] getResult() {
        return result.toString().split(" ");
    }
}
