package com.venkatesh.practice;

public class MotherVertex {
    private Graph graph;

    public  MotherVertex(Graph graph) {
        this.graph = graph;
    }

    public int getMotherVertex() {
        int motherVertex = -1;
        for(int i=0;i< graph.getAdjacencyList().length;i++) {
            if(!graph.getVisited()[i]) {
                graph.DFS(i);
                motherVertex = i;
            }
        }

        graph.resetVisited();
        graph.DFS(motherVertex);
        for(boolean i: graph.getVisited()) {
            if(!i)
                return -1;
        }
        return motherVertex;
    }
}
