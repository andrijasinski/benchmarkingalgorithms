package main;

import algorithms.graphs.Graph;
import algorithms.graphs.Node;
import algorithms.sorts.Sort;
import algorithms.sorts.Merge;
import algorithms.sorts.Quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testSorts();
        testGraphs();
    }

    private static void testGraphs() {
        Graph graph = new Graph();
/*        List<Node> nodes = new ArrayList<>(Arrays.asList(
                new Node("A"),
                new Node("B"),
                new Node("C"),
                new Node("D"),
                new Node("E"),
                new Node("F")
        ));

        graph.addNodes(nodes);

        graph.generateEdges();*/

        graph.generateGraph(20);

        System.out.println(graph);


    }

    private static void testSorts() {
        Sort merger = new Merge();
        Sort quick = new Quick();

        merger.setUp(new ArrayList(Arrays.asList(1)));
        merger.start();
        quick.setUp(new ArrayList(Arrays.asList(1)));
        quick.start();

        for (int i = 5000; i < 20000; i += 1000) {
            // Integer.MAX_VALUE/46 <- maximum size of an ArrayList (stable)
//            List<Integer> l = generator(Integer.MAX_VALUE/46, Integer.MAX_VALUE);
            List<Integer> l = generator(i, Integer.MAX_VALUE);

            merger.setUp(l);
            long startTime = System.currentTimeMillis();
            merger.start();
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime)/1000.0;
            System.out.println("\n\n" + merger.getName() + " " + elapsedTime + " . Num of elements ");

            quick.setUp(l);
            startTime = System.currentTimeMillis();
            quick.start();
            stopTime = System.currentTimeMillis();
            elapsedTime = (stopTime - startTime)/1000.0;
            System.out.println("\n" + quick.getName() + " " + elapsedTime + " . Num of elements ");
        }
    }

    private static List<Integer> generator(int size, int bound){
        List<Integer> l = new ArrayList<>();
        Random generator = new Random();
        for (int j = 0; j < size; j++) {
            l.add(generator.nextInt(bound));
        }
        return l;
    }
}
