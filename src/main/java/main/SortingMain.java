package main;

import algorithms.sorts.Merge;
import algorithms.sorts.Quick;
import algorithms.sorts.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import sysinfo.SysInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingMain {

    private final static Logger log = (Logger) LogManager.getLogger(SortingMain.class);

    public static void main(String[] args) {
        log.info(SysInfo.getSystemInfo());
        log.info("Initializing Merge and Quick sorts");
        Sort merger = new Merge();
        Sort quick = new Quick();

        merger.setUp(new ArrayList(Arrays.asList(1)));
        merger.start();
        quick.setUp(new ArrayList(Arrays.asList(1)));
        quick.start();

        for (int i = 5000; i < 200000; i += 1000) {
            // Integer.MAX_VALUE/46 <- maximum size of an ArrayList (stable)
//            List<Integer> l = generator(Integer.MAX_VALUE/46, Integer.MAX_VALUE);
            log.info("Generating array with " + i + " elements");
            List<Integer> l = generator(i, Integer.MAX_VALUE);

            merger.setUp(l);
            long startTime = System.currentTimeMillis();
            merger.start();
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime);
            log.info("Result for Mergesort algorithm is: " + elapsedTime + " ms");

            quick.setUp(l);
            startTime = System.currentTimeMillis();
            quick.start();
            stopTime = System.currentTimeMillis();
            elapsedTime = (stopTime - startTime);
            log.info("Result for Quicksort algorithm is: " + elapsedTime + " ms");
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
