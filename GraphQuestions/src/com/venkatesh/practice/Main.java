package com.venkatesh.practice;

public class Main {

    public static void main(String[] args) {
	    // Graph g = new Graph(5);
     //    g.addEdge(0, 1);
     //    g.addEdge(0, 4);
     //    g.addEdge(1, 3);
     //    g.addEdge(2, 0);
     //    g.addEdge(3, 2);

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

//        IterativeDFS iterativeDFS = new IterativeDFS(g);
//        iterativeDFS.iterativeDFS(0);
//        g.printGraph();
//        TopologicalSorting topologicalSorting = new TopologicalSorting(g);
//        topologicalSorting.performTopologicalSort();
//        NodeAtALevelUndirectedGraph nodeAtALevelUndirectedGraph = new NodeAtALevelUndirectedGraph(g);
//        System.out.println(nodeAtALevelUndirectedGraph.printCountOfNodesAtLevel(4));

        // PossiblePaths possiblePaths = new PossiblePaths(g);
        // possiblePaths.printPossiblePaths(4,1);

        int[][] matrix = {
                {3,3}, {1,1}
        };
        MinimumInitialVerticesToTraverseEntireMatrix minimumInitialVertices = new MinimumInitialVerticesToTraverseEntireMatrix();
        minimumInitialVertices.printMinimumInitialVertices(matrix);

    }
}
