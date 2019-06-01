package com.venkatesh.practice;

public class Main {

    public static void main(String[] args) {
	    Graph graph = new Graph(5);
	    graph.addEdge(1,0);
        graph.addEdge(2,1);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(0,2);

        graph.printGraph();

//        System.out.println("Print any mother vertex:");
//        MotherVertex motherVertex = new MotherVertex(graph);
//        System.out.println(motherVertex.getMotherVertex());

        System.out.println("Printing the transitive closure:");
        TransitiveClosure tc = new TransitiveClosure(graph);
        tc.prepareTransitiveClosure();

    }
}
