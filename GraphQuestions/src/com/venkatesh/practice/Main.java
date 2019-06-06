package com.venkatesh.practice;

public class Main {

    public static void main(String[] args) {
	    Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

//        g2.printGraph();

//        System.out.println("Print mother verices:");
//        MotherVertex motherVertex = new MotherVertex(graph);
//        motherVertex.getMotherVertex();

//        System.out.println("Printing the transitive closure:");
//        TransitiveClosure tc = new TransitiveClosure(graph);
//        tc.prepareTransitiveClosure();

//        System.out.println("Printing K Cores:");
//        KCoresGraph kCoresGraph = new KCoresGraph(g2, 3);
//        kCoresGraph.makeKCoreGraph();

        IterativeDFS iterativeDFS = new IterativeDFS(g);
        iterativeDFS.iterativeDFS(0);

    }
}
