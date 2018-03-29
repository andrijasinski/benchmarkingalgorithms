package main;

import algorithms.sorts.Merge;
import algorithms.sorts.Quick;
import algorithms.sorts.Sort;
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
import java.util.Random;

public class SortingMain {

    private final static Logger log = (Logger) LogManager.getLogger(SortingMain.class);

    public static void main(String[] args) {
        String sysinfo = SysInfo.getSystemInfo();
        log.info(sysinfo);
        log.info("Initializing Merge and Quick sorts");
        Sort merger = new Merge();
        Sort quick = new Quick();

        merger.setUp(generator(10, 10));
        merger.start();
        quick.setUp(generator(10, 10));
        quick.start();

        Path mergesort_file = Paths.get("mergesort_results_" + getTimestamp() + ".csv");
        Path quicksort_file = Paths.get("quicksort_results_" + getTimestamp() + ".csv");
        List<String> mergesort_results = new ArrayList<>(Arrays.asList(sysinfo));
        List<String> quicksort_results = new ArrayList<>(Arrays.asList(sysinfo));

        for (int i = 5000; i < 50000; i += 1000) {
            // Integer.MAX_VALUE/46 <- maximum size of an ArrayList (stable)
            log.info("Generating array with " + i + " elements");
            List<Integer> l = generator(i, Integer.MAX_VALUE);
            String run = "Sorting;Mergesort;"+ i + ";";
            merger.setUp(l);
            long startTime = System.currentTimeMillis();
            merger.start();
            long stopTime = System.currentTimeMillis();
            double elapsedTime = (stopTime - startTime);
            log.info("Result for Mergesort algorithm is: " + elapsedTime + " ms");
            run += elapsedTime + ";";
            mergesort_results.add(run);

            run =  "Sorting;Quicksort;"+ i + ";";
            quick.setUp(l);
            startTime = System.currentTimeMillis();
            quick.start();
            stopTime = System.currentTimeMillis();
            elapsedTime = (stopTime - startTime);
            log.info("Result for Quicksort algorithm is: " + elapsedTime + " ms");
            run += elapsedTime + ";";
            quicksort_results.add(run);
        }
        try {
            Files.write(mergesort_file, mergesort_results, Charset.forName("UTF-8"));
            Files.write(quicksort_file, quicksort_results, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
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

    private static String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
        return sdf.format(new Timestamp(System.currentTimeMillis()));
    }
}
