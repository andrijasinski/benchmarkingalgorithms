import algorithms.sorts.Quick;
import algorithms.sorts.Sort;
import algorithms.sorts.Merge;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SortingTest {

    private List<Sort> algs;
    private int MAX;

    @Before
    public void setUp(){
        algs = new ArrayList<>();
        algs.add(new Merge());
        algs.add(new Quick());
        MAX = Integer.MAX_VALUE;
    }

    @Test
    public void test01Merge(){
        for (Sort alg : algs) {
            for (int i = 5000; i < 50000; i += 5000) {
                List<Integer> list = generator(i, MAX);
                alg.setUp(list);
                alg.start();
                List<Integer> res = alg.result();
                Collections.sort(list);
                assertEquals(list, res);
            }
        }
    }

    private List<Integer> generator(int size, int bound){
        List<Integer> l = new ArrayList<>();
        Random generator = new Random();
        for (int j = 0; j < size; j++) {
            l.add(generator.nextInt(bound));
        }
        return l;
    }
}
