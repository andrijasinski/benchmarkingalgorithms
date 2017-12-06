package main;

import algorithms.sorts.Sort;
import algorithms.sorts.Merge;
import algorithms.sorts.Quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sort merger = new Merge();
        Sort quick = new Quick();

        merger.setUp(new ArrayList(Arrays.asList(1)));
        merger.start();
        quick.setUp(new ArrayList(Arrays.asList(1)));
        quick.start();

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
            System.out.println("\n\n" + merger.getName() + " " + elapsedTime + " . Num of elements " + i*10000);

            quick.setUp(l);
            startTime = System.nanoTime();
            quick.start();
            stopTime = System.nanoTime();
            elapsedTime = stopTime - startTime;
            System.out.println("\n" + quick.getName() + " " + elapsedTime + " . Num of elements " + i*10000);
        }
    }
}
