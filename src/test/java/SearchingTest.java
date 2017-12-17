import algorithms.graphs.Edge;
import algorithms.graphs.Graph;
import algorithms.graphs.Node;
import algorithms.search.BFS;
import algorithms.sorts.Merge;
import algorithms.sorts.Quick;
import algorithms.sorts.Sort;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SearchingTest {

    private BFS bfs;
    private int MAX;

    @Before
    public void setUp(){
        bfs = new BFS();
        MAX = Integer.MAX_VALUE;
    }

    @Test
    public void test01Searching(){
        List<Node> nodes = new ArrayList<>(Arrays.asList(
                new Node("0"),
                new Node("1"),
                new Node("2"),
                new Node("3")
        ));
        List<Edge> edges = new ArrayList<>(Arrays.asList(
                new Edge(nodes.get(0), nodes.get(1)),
                new Edge(nodes.get(1), nodes.get(2)),
                new Edge(nodes.get(1), nodes.get(3)),
                new Edge(nodes.get(2), nodes.get(0)),
                new Edge(nodes.get(2), nodes.get(3)),
                new Edge(nodes.get(3), nodes.get(2))
        ));
        Graph graph = new Graph(nodes, edges);

        BFS bfs = new BFS();

        bfs.setUp(graph);
        bfs.start(2);

        assertEquals(bfs.getResult(), "2 0 3 1 ");
        graph.setAllUnvisited();
        assertFalse(graph.getNodes().get(2).isVisited());
    }
}
