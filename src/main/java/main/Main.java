package main;

import algorithms.Algorithm;
import algorithms.Merge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Algorithm merger = new Merge();
        for (int i = 1; i < 10; i++) {
            List<Integer> l = new ArrayList<>();
            Random generator = new Random();
            for (int j = 0; j < i*10000; j++) {
                l.add(generator.nextInt(5000));
            }

            merger.setUp(l);
            long startTime = System.nanoTime();
            merger.start();
            long stopTime = System.nanoTime();
            long elapsedTime = stopTime - startTime;
            System.out.println("Mergesort " + elapsedTime + " . Num of elements " + i*10000);
        }
    }
}
