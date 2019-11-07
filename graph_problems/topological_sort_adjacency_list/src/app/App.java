package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        TopologicalSort tps = new TopologicalSort(8);
        tps.addEdge(0, 1);
        tps.addEdge(0, 2);
        tps.addEdge(1, 2);
        tps.addEdge(1, 3);
        tps.addEdge(1, 4);
        tps.addEdge(2, 3);
        tps.addEdge(2, 6);
        tps.addEdge(3, 4);
        tps.addEdge(3, 5);
        tps.addEdge(3, 6);
        tps.addEdge(4, 7);
        tps.addEdge(5, 7);
        tps.addEdge(6, 7);


        System.out.println("Printing the graph:");
        tps.printGraph();

        System.out.println("Printing the topological sort:");
        int[] tps_array = tps.printTopologicalSort();
        System.out.println(Arrays.toString(tps_array));


    }


}