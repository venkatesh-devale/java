package com.venkatesh.practice;

import java.util.Stack;

public class TopologicalSorting {
    private Graph graph;
    private int vertices;

    public TopologicalSorting(Graph graph) {
        this.graph = graph;
        vertices = graph.getVertices();
    }

    public void performTopologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<vertices;i++) {
            if(!visited[i])
                helperTopoSort(i, stack, visited);
        }
        System.out.println("Printing the topological sorted order vertices:");
        while(!stack.empty()) {
            System.out.print(stack.peek()+ " ");
            stack.pop();
        }
        System.out.println();
    }

    private void helperTopoSort(int i, Stack<Integer> stack, boolean[] visited) {
        if(visited[i])
            return;
        visited[i] = true;
        for(int j: graph.getAdjacencyList()[i]) {
            if(!visited[j])
                helperTopoSort(j, stack, visited);
        }
        stack.push(i);
    }
}
