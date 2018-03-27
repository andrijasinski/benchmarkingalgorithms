package algorithms.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class MatrixGraph {
    private int[][] graph;
    private Random random;

    public MatrixGraph(int[][] graph) {
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
        }
    }

    public int[][] getGraph() {
        return graph;
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
