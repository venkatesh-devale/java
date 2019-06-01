package com.venkatesh.practice;

import java.util.List;

public class TransitiveClosure {
    private Graph graph;

    public TransitiveClosure(Graph graph) {
        this.graph = graph;
    }

    public void modifiedDFS(int sourceVertex, int currentVertex, int[][] transitiveClosureMatrix) {
        transitiveClosureMatrix[sourceVertex][currentVertex] = 1;
        for(int i: graph.getAdjacencyList()[currentVertex]) {
            if(transitiveClosureMatrix[sourceVertex][i] == 0)
                modifiedDFS(sourceVertex, i, transitiveClosureMatrix);
        }
    }

    public void prepareTransitiveClosure() {
        int vertices = graph.getVertices();
        int[][] transitiveClosureMatrix = new int[vertices][vertices];
        for(int i=0;i<vertices;i++) {
            modifiedDFS(i, i, transitiveClosureMatrix);
        }
        printTransitiveClosureMatrix(transitiveClosureMatrix);
    }

    private void printTransitiveClosureMatrix(int[][] transitiveClosureMatrix) {
        int n = graph.getVertices();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(transitiveClosureMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
