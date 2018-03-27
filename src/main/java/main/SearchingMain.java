package main;

import algorithms.graphs.Graph;
import algorithms.search.BFS;
import algorithms.search.DFS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import sysinfo.SysInfo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        log.info("Initializing Breadth First Search and Depth First Search algorithms");
        BFS bfs = new BFS();
        DFS dfs = new DFS();

        Path bfs_file = Paths.get("bfs_results_" + getTimestamp() + ".csv");
        Path dfs_file = Paths.get("dfs_results_" + getTimestamp() + ".csv");
        List<String> bfs_results = new ArrayList<>(Arrays.asList(sysinfo));
        List<String> dfs_results = new ArrayList<>(Arrays.asList(sysinfo));

        for (int i = 1000; i < 10001; i += 500) {
            log.info("Generating graph with " + i + " nodes");
            String run = "Searching;BFS;"+ i + ";";
            Graph graph = new Graph();
            graph.generateGraph(i);
            int startingPoint = graph.getStartingPoint();

            bfs.setUp(graph);
            log.info("Starting BFS");
            long startTime = System.currentTimeMillis();
            bfs.start(startingPoint);
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime);
            log.info("Result for BFS algorithm is: " + elapsedTime + " ms");
            run += elapsedTime + ";";
            bfs_results.add(run);
            graph.setAllUnvisited();

            run = "Searching;DFS;"+ i + ";";
            dfs.setUp(graph);
            log.info("Starting DFS");
            startTime = System.currentTimeMillis();
            dfs.start(startingPoint);
            stopTime = System.currentTimeMillis();
            elapsedTime = (stopTime - startTime);
            log.info("Result for DFS algorithm is: " + elapsedTime + " ms");
            run += elapsedTime + ";";
            dfs_results.add(run);
        }
        try {
            Files.write(bfs_file, bfs_results, Charset.forName("UTF-8"));
            Files.write(dfs_file, dfs_results, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
        return sdf.format(new Timestamp(System.currentTimeMillis()));
    }
}
