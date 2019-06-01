package com.venkatesh.practice;

public class Main {

    public static void main(String[] args) {
	    Graph g2 = new Graph(13);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 5);
        g2.addEdge(1, 6);
        g2.addEdge(2, 7);
        g2.addEdge(2, 8);
        g2.addEdge(2, 9);
        g2.addEdge(3, 10);
        g2.addEdge(3, 11);
        g2.addEdge(3, 12);

//        g2.printGraph();

//        System.out.println("Print mother verices:");
//        MotherVertex motherVertex = new MotherVertex(graph);
//        motherVertex.getMotherVertex();

//        System.out.println("Printing the transitive closure:");
//        TransitiveClosure tc = new TransitiveClosure(graph);
//        tc.prepareTransitiveClosure();

        System.out.println("Printing K Cores:");
        KCoresGraph kCoresGraph = new KCoresGraph(g2, 3);
        kCoresGraph.makeKCoreGraph();
    }
}
