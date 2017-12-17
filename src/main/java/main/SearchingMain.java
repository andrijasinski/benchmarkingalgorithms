package main;

import algorithms.graphs.Graph;
import algorithms.search.BFS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import sysinfo.SysInfo;

public class SearchingMain {
    private final static Logger log = (Logger) LogManager.getLogger(SearchingMain.class);

    public static void main(String[] args) {
        log.info(SysInfo.getSystemInfo());
        log.info("Initializing Breadth First Search");
        BFS bfs = new BFS();

        for (int i = 1000; i < 10000; i += 1000) {
            log.info("Generating graph with " + i + " nodes");
            Graph graph = new Graph();
            graph.generateGraph(i);

            bfs.setUp(graph);
            log.info("Starting BFS");
            long startTime = System.currentTimeMillis();
            bfs.start(2);
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime);
            log.info("Result for BFS algorithm is: " + elapsedTime + " ms");


            graph.setAllUnvisited();
        }
    }
}
