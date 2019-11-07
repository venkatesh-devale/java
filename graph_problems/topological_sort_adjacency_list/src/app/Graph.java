package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph
 */
public class Graph {

    int vertices;
    List<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new List[vertices];
        for(int i=0;i<vertices;i++) {
            this.adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public void printGraph() {
        for(int i=0;i<this.vertices;i++) {
            System.out.println(i + "->" + this.adjacencyList[i]);
        }
    }
}