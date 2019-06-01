package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.List;

public class MotherVertex {
    private Graph graph;

    public  MotherVertex(Graph graph) {
        this.graph = graph;
    }

    public int DFS(int s) {

            graph.getVisited()[s] = true;
            List<Integer> list = graph.getAdjacencyList()[s];
            for(int i: list) {
                if(!graph.getVisited()[i])
                    DFS(i);
            }
            return s;
    }

    public void getMotherVertex() {
        int motherVertex = -1;
        List<Integer> motherVertices = new ArrayList<Integer>();
        for(int i=0;i< graph.getAdjacencyList().length;i++) {
            if(!graph.getVisited()[i]) {
                motherVertex = DFS(i);

                if(checkIfMotherVertex(motherVertex))
                    motherVertices.add(motherVertex);
            }
        }
        System.out.println(motherVertices);

    }

    public boolean checkIfMotherVertex(int motherVertex) {
        graph.resetVisited();
        DFS(motherVertex);
        for(boolean i: graph.getVisited()) {
            if(!i)
                return false;
        }
        return true;
    }
}
