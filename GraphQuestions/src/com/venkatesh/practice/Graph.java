package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private int vertices;
    private boolean[] visited;
    private List<Integer>[] adjacencyList;


    public Graph(int n) {
        this.vertices = n;
        this.visited = new boolean[n];
        this.adjacencyList = new List[n];
        for(int i=0;i<n;i++) {
            this.adjacencyList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int s, int d) {
        this.adjacencyList[s].add(d);
        //this.adjacencyList[d].add(s);
    }

    public void printGraph() {
        System.out.println("Printing the Graph:");
        for(int i=0;i<this.vertices;i++) {
            System.out.print(i+"->");
            for(int vertex: this.adjacencyList[i]) {
                System.out.print(vertex+" ");
            }
            System.out.println();
        }
    }

    public void DFS(int s) {
        if(!visited[s]) {
            visited[s] = true;
            List<Integer> list = adjacencyList[s];
            for(int i: list)
                DFS(i);
        }
    }

    public void resetVisited() {
        Arrays.fill(this.visited, false);
    }

    public int getVertices() {
        return vertices;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public List<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public void setAdjacencyList(List<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
