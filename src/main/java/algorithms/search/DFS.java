package algorithms.search;

import algorithms.graphs.Edge;
import algorithms.graphs.Graph;
import algorithms.graphs.Node;

import java.util.Stack;
import java.util.List;

public class DFS {

    private Graph g;

    private Stack<Node> stack;

    private StringBuilder result;

    public void setUp(Graph g){
        this.g = g;
        stack = new Stack<>();
        result = new StringBuilder();
    }

    public void start(int entryPoint){
        List<Node> nodes = g.getNodes();

        Node node = nodes.get(entryPoint);
        node.setVisited(true);
        stack.add(node);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            result.append(n.getName()).append(" ");

            for (Edge edge : n.getOut()) {
                Node next = edge.getEnd();
                if (!next.isVisited()){
                    next.setVisited(true);
                    stack.add(next);
                }
            }
        }
    }

    public String[] getResult() {
        return result.toString().split(" ");
    }
}
