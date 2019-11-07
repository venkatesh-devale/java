package study.venkatesh;

public class TransitiveClosure {
    Graph graph;

    public TransitiveClosure(Graph graph) {
        this.graph = graph;
    }

    public void printTransitiveClosureMatrix() {
        int[][] transitiveClosureMatrix = new int[graph.getVertices()][graph.getVertices()];

        for(int i=0;i<this.graph.getVertices();i++)
            dfsEnhancedRecursiveTraversal(i, i, transitiveClosureMatrix);


        for(int i=0;i<this.graph.getVertices();i++) {
            for(int j=0;j<this.graph.getVertices();j++) {
                System.out.print(transitiveClosureMatrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    private void dfsEnhancedRecursiveTraversal(int source, int destination, int[][] transitiveClosureMatrix) {
        for(int i: this.graph.getAdjacencyList()[destination]) {
            if(transitiveClosureMatrix[source][i] == 0) {
                transitiveClosureMatrix[source][i] = 1;
                dfsEnhancedRecursiveTraversal(source, i, transitiveClosureMatrix);
            }

        }
    }
}
