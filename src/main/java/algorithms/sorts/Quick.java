package algorithms.sorts;

import java.util.ArrayList;
import java.util.List;

public class Quick extends Sort {

    private int[] numbers;
    private int number;

    private String name = "Quicksort";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setUp(List<Integer> l) {
        this.numbers = toArray(l);
        number = l.size();
    }

    @Override
    public void start() {
        quicksort(0, number - 1);
    }


    @Override
    public List<Integer> result() {
        return toList(numbers);
    }

    // Original source code can be found here:
    // http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
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
