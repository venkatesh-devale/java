package com.venkatesh.practice;

import java.util.LinkedList;
import java.util.Queue;

public class NodeAtALevelUndirectedGraph {
    private Graph graph;
    private int vertices;

    public NodeAtALevelUndirectedGraph(Graph graph) {
        this.graph = graph;
        this.vertices = graph.getVertices();
    }

    public int printCountOfNodesAtLevel(int level) {
        if(level == 0)
            return 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[vertices];
        queue.offer(0);
        return helperBFS(level, queue, visited);
    }

    private int helperBFS(int level, Queue<Integer> queue, boolean[] visited) {
        int currentLevel = 0;
        int size = 0;
        while(!queue.isEmpty() && currentLevel <= level) {
            System.out.println("Current level: "+currentLevel+" and current queue is: "+queue);
            size = queue.size();
            for(int i=0;i<size;i++) {
                int vertex = queue.poll();
                visited[vertex] = true;
                for(int j: graph.getAdjacencyList()[vertex]) {
                    if(!visited[j])
                        queue.offer(j);
                }
            }
            currentLevel++;
        }
        return size;
    }


}
