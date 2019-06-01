package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.List;

public class KCoresGraph {
    private Graph graph;
    private int k;

    public KCoresGraph(Graph graph, int k) {
        this.graph = graph;
        this.k = k;
    }

    public void DFS(int s, List<Integer> list, int k, boolean[] visited, boolean[] processed) {
        if(!visited[s]) {
            visited[s] = true;
            for(int i: list) {
                int index = graph.getAdjacencyList()[i].indexOf(s);
                if(index != -1) {
                    graph.getAdjacencyList()[i].remove(index);
                    if(!processed[i] && graph.getAdjacencyList()[i].size() < k) {
                        DFS(i, graph.getAdjacencyList()[i], k, visited, processed);
                    }
                }

            }
        }

    }

    public void makeKCoreGraph() {
        boolean[] visited = new boolean[graph.getVertices()];
        boolean[] processed = new boolean[graph.getVertices()];
        for(int i=0;i<graph.getVertices();i++) {
            List<Integer> list = graph.getAdjacencyList()[i];
            if(list.size() < k) {
                DFS(i, list, k, visited, processed);
            }
        }
        printGraph();
    }

    private void printGraph() {
        for(int i=0;i<graph.getVertices();i++) {
            if(graph.getAdjacencyList()[i].size() < k)
                continue;
            System.out.print(i+"->");
            for(int vertex: graph.getAdjacencyList()[i]) {
                System.out.print(vertex+" ");
            }
            System.out.println();
        }
    }
}
