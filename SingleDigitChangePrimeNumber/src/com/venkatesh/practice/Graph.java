package com.venkatesh.practice;

import java.util.*;

public class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int n) {
        this.vertices = n;
        this.adjacencyList = new LinkedHashMap<Integer, List<Integer>>();
    }

    public void addEdge(int s, int d) {
        List<Integer> list;
        if(adjacencyList.containsKey(s)) {
            list = adjacencyList.get(s);
        } else {
            list = new ArrayList<Integer>();
        }
        list.add(d);
        adjacencyList.put(s, list);

        if(adjacencyList.containsKey(d)) {
            list = adjacencyList.get(d);
        } else {
            list = new ArrayList<Integer>();
        }
        list.add(s);
        adjacencyList.put(d, list);
    }

    public void printGraph() {
        System.out.println("Printing the Graph:");
        System.out.println(adjacencyList);
    }

    public void BFS(int source, int destination) {
        if(source == destination) {
            System.out.println("Source prime number and destination prime number match hence 0 steps");
            return ;
        }

        Map<Integer, Integer> visited = new HashMap();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        visited.put(source, 1);
        while(!queue.isEmpty()) {
            int element = queue.poll();
            List<Integer> list = adjacencyList.get(element);
            if(list != null) {
                for(int i: list) {
                    if(visited.getOrDefault(i, 0) == 0) {
                        visited.put(i, visited.get(element)+1);
                        if(i == destination) {
                            int steps = visited.get(i)-1;
                            System.out.println("Reached destination in "+ steps + " steps");
                            return ;
                        }
                        queue.offer(i);
                    }
                }
            }
        }
        System.out.println("Could not reach the destination prime number");
    }
}
