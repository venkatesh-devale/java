package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.List;

public class PossiblePaths {
    private Graph graph;
    private int vertices;

    public PossiblePaths(Graph graph) {
        this.graph = graph;
        this.vertices = graph.getVertices();
    }

    public void printPossiblePaths(int source, int destination) {
        boolean[] visited = new boolean[vertices];

        List<List<Integer>> possiblePaths = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helperPossiblePaths(possiblePaths, list, source, destination, visited);
    }

    private void helperPossiblePaths(List<List<Integer>> possiblePaths, List<Integer> list, int source, int destination, boolean[] visited) {
        visited[source] = true;
        list.add(new Integer(source));
        if(source == destination) {
            System.out.println("Path found: "+ list);
            possiblePaths.add(list);
            list.remove(new Integer(source));
            return ;
        }
        for(int i: graph.getAdjacencyList()[source]) {
            if(!visited[i]) {
                helperPossiblePaths(possiblePaths, list, i, destination, visited);
                list.remove(new Integer(i));
                visited[i] = false;
            }
        }
    }
}
