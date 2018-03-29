package algorithms.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class MatrixGraph {
    private int[][] graph;
    private Random random;
    private int mostConnected;

    public MatrixGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && graph[j][i] != 1) graph[j][i] = 1;
            }
            if (IntStream.of(graph[i]).sum() > IntStream.of(graph[mostConnected]).sum()) mostConnected = i;
        }
        this.graph = graph;
        random = new Random();
    }

    public MatrixGraph(int size) {
        graph = new int[size][size];
        random = new Random();
        for (int[] layer : graph) {
            Arrays.fill(layer, 0);
        }
        generateGraphEdges(size);
    }

    private void generateGraphEdges(int size) {
        mostConnected = 0;
        for (int i = 0; i < size; i++) {
            boolean connected = false;
            while (random.nextDouble() < 0.5) {
                int node_to_add = random.nextInt(size);
                if (node_to_add == i) continue;
                graph[i][node_to_add] = 1;
                graph[node_to_add][i] = 1;
                connected = true;
            }
            if (!connected) {
                int node_to_add = random.nextInt(size);
                if (node_to_add == i) continue;
                graph[i][node_to_add] = 1;
                graph[node_to_add][i] = 1;
            }
            if (IntStream.of(graph[i]).sum() > IntStream.of(graph[mostConnected]).sum()) mostConnected = i;
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(mostConnected);
        visited.add(mostConnected);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] edges = graph[node];
//            System.out.print(node + " ");
            for (int edge = 0; edge < edges.length; edge++) {
                if (edges[edge] == 1 && !visited.contains(edge)) {
                    visited.add(edge);
                    queue.add(edge);
                }
            }
        }
    }

    public void dfs() {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.add(mostConnected);
        visited.add(mostConnected);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            int[] edges = graph[node];
//            System.out.print(node + " ");
            for (int edge = 0; edge < edges.length; edge++) {
                if (edges[edge] == 1 && !visited.contains(edge)) {
                    visited.add(edge);
                    stack.add(edge);
                }
            }
        }
    }

    public int[][] getGraph() {
        return graph;
    }

    public int getMostConnected() {
        return mostConnected;
    }

    @Override
    public String toString() {
        String out = "";
        for (int[] ints : graph) {
            out += Arrays.toString(ints) + "\n";
        }
        return out;
    }
}
