package main;

import algorithms.graphs.Graph;
import algorithms.search.BFS;
import algorithms.search.DFS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import sysinfo.SysInfo;

public class SearchingMain {
    private final static Logger log = (Logger) LogManager.getLogger(SearchingMain.class);

    public static void main(String[] args) {
        log.info(SysInfo.getSystemInfo());
        log.info("Initializing Breadth First Search and Depth First Search algorithms");
        BFS bfs = new BFS();
        DFS dfs = new DFS();

        for (int i = 1000; i < 10001; i += 500) {
            log.info("Generating graph with " + i + " nodes");
            Graph graph = new Graph();
            graph.generateGraph(i);
            int startingPoint = graph.getStartingPoint();

            bfs.setUp(graph);
            log.info("Starting BFS");
            long startTime = System.nanoTime();
            bfs.start(startingPoint);
            long stopTime = System.nanoTime();
            double elapsedTime = (stopTime - startTime);
            log.info("Result for BFS algorithm is: " + elapsedTime + " nanos");

            graph.setAllUnvisited();

            dfs.setUp(graph);
            log.info("Starting DFS");
            startTime = System.nanoTime();
            dfs.start(startingPoint);
            stopTime = System.nanoTime();
            elapsedTime = (stopTime - startTime);
            log.info("Result for DFS algorithm is: " + elapsedTime + " nanos");
        }
    }
}
