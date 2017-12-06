package algorithms.sorts;

import java.util.List;

public abstract class Sort {
    public abstract String getName();
    public abstract void setUp(List<Integer> l);
    public abstract void start();
    public abstract List<Integer> result();
}
