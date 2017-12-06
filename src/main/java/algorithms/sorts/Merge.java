package algorithms.sorts;

import java.util.ArrayList;
import java.util.List;

public class Merge extends Sort {

    private int[] numbers;
    private int[] helper;
    private int number;

    public String getName() {
        return name;
    }

    private String name = "Mergesort";

    @Override
    public void setUp(List<Integer> l){
        this.numbers = toArray(l);
        number = l.size();
        this.helper = new int[number];
    }

    @Override
    public List<Integer> result(){
        return toList(numbers);
    }

    @Override
    public void start() {
        mergesort(0, number - 1);
    }


    // Original source code can be found here:
    // http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
    private void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }

    private int[] toArray(List<Integer> l) {
        int[] array = new int[l.size()];
        for(int i = 0; i < l.size(); i++) array[i] = l.get(i);
        return array;
    }

    private List<Integer> toList(int[] a) {
        List<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        return l;
    }
}
