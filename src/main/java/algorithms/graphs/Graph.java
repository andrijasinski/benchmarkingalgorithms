package algorithms.graphs;

import java.util.*;

public class Graph {
    private HashMap<Integer, Set<Integer>> graph_map;
    private Random random;
    private int mostConnected;

    public Graph(int size) {
        graph_map = new HashMap<>();
        random = new Random();
        generateGraphEdges(size);
    }

    private void generateGraphEdges(int size) {
        mostConnected = 0;
        for (int i = 0; i < size; i++) {
            boolean connected = false;
            while (random.nextDouble() < 0.5) {
                int node_to_add = random.nextInt(size);
                if (node_to_add == i) continue;
                Set<Integer> edges = graph_map.getOrDefault(i, new HashSet<>());
                edges.add(node_to_add);
                graph_map.put(i, edges);
                connected = true;
            }
            if (!connected) {
                int node_to_add = random.nextInt(size);
                if (node_to_add == i) node_to_add = random.nextInt(size);
                Set<Integer> edges = graph_map.getOrDefault(i, new HashSet<>());
                edges.add(node_to_add);
                graph_map.put(i, edges);
            }
            if (graph_map.get(i).size() > graph_map.get(mostConnected).size()) mostConnected = i;
        }
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(mostConnected);
        visited.add(mostConnected);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> edges = graph_map.getOrDefault(node, new HashSet<Integer>());
            for (int neighbourNode : edges) {
                if (!visited.contains(neighbourNode)) {
                    visited.add(neighbourNode);
                    queue.add(neighbourNode);
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
            Set<Integer> edges = graph_map.getOrDefault(node, new HashSet<Integer>());
            for (Integer neighbourNode : edges) {
                if (!visited.contains(neighbourNode)) {
                    visited.add(neighbourNode);
                    stack.add(neighbourNode);
                }
            }
        }
    }
}
