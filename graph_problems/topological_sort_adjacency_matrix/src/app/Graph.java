package app;

/**
 * Graph
 */
public class Graph {

    int vertices;
    int[][] adjacency_matrix = null;
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacency_matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacency_matrix[source][destination] = weight;
    }

    public void printGraph() {
        for(int i = 0; i < this.vertices; i++) {
            System.out.print(i + "->[");
            for(int j = 0; j < this.vertices; j++) {
                if(adjacency_matrix[i][j] != 0) {
                    System.out.print(j + "->");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
}