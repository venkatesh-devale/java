package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,0);
        graph.addEdge(4,1);
        graph.addEdge(5,2);
        graph.addEdge(5,0);

        graph.printGraph();
        graph.printAllTopologicalSorts();
    }
}

class Graph {
    private int vertices;
    private List<Integer>[] adlist;
    int[] indegree;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adlist = new ArrayList[vertices];
        this.indegree = new int[this.vertices];
        for(int i=0;i<vertices;i++) {
            adlist[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adlist[source].add(destination);
    }

    public void printGraph() {
        for(int i=0;i<this.vertices;i++) {
            System.out.println();
            System.out.print(i+"-->");
            for(int j: this.adlist[i]) {
                System.out.print(j+" ");
            }
        }
        System.out.println();
    }

    public void printAllTopologicalSorts() {
        for(int i=0;i<this.vertices;i++) {
            for(int j: adlist[i]) {
                this.indegree[j]++;
            }
        }

        System.out.println("Printing all the indegrees");
        for(int i=0;i<this.vertices;i++)
            System.out.println("vertex: " + i + " indegree: " + this.indegree[i]);

        boolean[] visited = new boolean[this.vertices];
        Stack stack = new Stack();
        topologicalSortHelper(visited, stack);

    }

    public void topologicalSortHelper(boolean[] visited, Stack<Integer> stack) {
        boolean flag = false;
        for(int i=0;i<this.vertices;i++) {
            if(!visited[i] && this.indegree[i] == 0) {
                visited[i] = true;
                stack.push(i);

                for(int j: adlist[i]) {
                    this.indegree[j]--;
                }

                topologicalSortHelper(visited, stack);

                visited[i] = false;
                stack.pop();
                for(int j: adlist[i]){
                    this.indegree[j]++;
                }
                flag = true;
            }
        }
        if(!flag) {
            stack.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
