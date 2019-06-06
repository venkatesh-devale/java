package com.venkatesh.practice;

import java.util.Stack;

public class IterativeDFS {
    Graph graph;

    public IterativeDFS(Graph graph) {
        this.graph = graph;
    }

    public void iterativeDFS(int s) {
        Stack<Integer> stack = new Stack();
        int n = this.graph.getVertices();
        boolean[] visited = new boolean[n];
        stack.push(s);
        while(!stack.empty()) {
            int vertex = stack.pop();
            if(!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex+ " ");
                for(int i: this.graph.getAdjacencyList()[vertex]) {
                    stack.push(i);
                }
            }

        }
    }
}
