package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        TopologicalSort topologicalSort = new TopologicalSort(8);
        topologicalSort.addEdge(0, 1, 3);
        topologicalSort.addEdge(0, 2, 6);
        topologicalSort.addEdge(1, 2, 4);
        topologicalSort.addEdge(1, 3, 4);
        topologicalSort.addEdge(1, 4, 11);
        topologicalSort.addEdge(2, 3, 8);
        topologicalSort.addEdge(2, 6, 11);
        topologicalSort.addEdge(3, 4, -4);
        topologicalSort.addEdge(3, 5, 5);
        topologicalSort.addEdge(3, 6, 2);
        topologicalSort.addEdge(4, 7, 9);
        topologicalSort.addEdge(5, 7, 1);
        topologicalSort.addEdge(6, 7, 2);

        // Topological Sort
        int[] result = topologicalSort.getTopologicalSort();
        System.out.println(Arrays.toString(result));

        // Single source shortest distance from some start node to destination
        int source = 3;
        int destination = 7;
        int distance = topologicalSort.getSingleSourceShortestPathDistanceUsingTPS(source, destination);
        System.out.println("Shortest distance between " + source  + " and " + destination + " : " + distance);
    }
}