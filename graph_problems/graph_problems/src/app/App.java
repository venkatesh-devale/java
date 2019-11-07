package app;

import app.Graph.MinDistancePath;

public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 4);

        
        MinDistancePath minDistancePath = graph.djikstraForSingleSourceShortestPath(0);
        int[] parents = minDistancePath.parents;
        int destination = 3;
        int node = destination;
        System.out.println("The Path is:");
        System.out.print(node+"->");
        while(parents[node] != -1) {
            System.out.print(parents[node]+"->");
            node = parents[node];
        }
        System.out.println("DONE");
    }
}