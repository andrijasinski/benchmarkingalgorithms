package main;

import algorithms.graphs.Graph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import sysinfo.SysInfo;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchingMain {
    private final static Logger log = (Logger) LogManager.getLogger(SearchingMain.class);

    public static void main(String[] args) {
        String sysinfo = SysInfo.getSystemInfo();
        log.info(sysinfo);
        log.info("Initializing graph for Breadth First Search and Depth First Search algorithms");

        Graph graph;

        ResultsSaver bfs_file = new ResultsSaver("bfs_results_");
        ResultsSaver dfs_file = new ResultsSaver("dfs_results_");

        List<String> bfs_results = new ArrayList<>(Arrays.asList(sysinfo));
        List<String> dfs_results = new ArrayList<>(Arrays.asList(sysinfo));

        for (int i = 1000; i <= 2000000; i += 1000) {
            log.info("Generating graph with " + i + " nodes");
            graph = new Graph(i);
            String run = "Searching;BFS;"+ i + ";";

            log.info("Starting BFS");
            long startTime = System.currentTimeMillis();
            graph.bfs();
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime);
            log.info("Result for BFS algorithm is: " + elapsedTime + " ms");
            run += elapsedTime + ";";
            bfs_results.add(run);

            run = "Searching;DFS;"+ i + ";";

            log.info("Starting DFS");
            startTime = System.currentTimeMillis();
            graph.dfs();
            stopTime = System.currentTimeMillis();
            elapsedTime = (stopTime - startTime);
            log.info("Result for DFS algorithm is: " + elapsedTime + " ms");
            run += elapsedTime + ";";
            dfs_results.add(run);
        }
        try {
            bfs_file.writeResults(bfs_results);
            dfs_file.writeResults(dfs_results);
        } catch (IOException e) {
            log.error("Failed to save results: " + e);
        }
    }

    private static String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
        return sdf.format(new Timestamp(System.currentTimeMillis()));
    }
}
