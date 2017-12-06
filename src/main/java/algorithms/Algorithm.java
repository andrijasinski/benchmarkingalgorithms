package algorithms;

import java.util.List;

public abstract class Algorithm {
    public abstract void setUp(List l);
    public abstract void start();
    public abstract List<Integer> result();
}
