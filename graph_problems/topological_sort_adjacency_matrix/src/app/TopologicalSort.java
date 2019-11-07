package app;

import java.util.Arrays;

/**
 * TopologicalSort
 */
public class TopologicalSort extends Graph {
    public TopologicalSort(int vertices) {
        super(vertices);
    }
    
    public int[] getTopologicalSort() {
        int[] topological_sorted_array = new int[this.vertices];
        boolean[] visited = new boolean[this.vertices];
        int index = this.vertices-1;
        for(int i=0;i<this.vertices;i++) {
            if(!visited[i]) {
                index = dfs(i, visited, topological_sorted_array, index);
            }
        }
        return topological_sorted_array;
    }

    private int dfs(int current, boolean[] visited, int[] array, int index) {
        if(visited[current]) return index;
        
        visited[current] = true;
        for(int j=0;j<this.vertices;j++) {
            if(!visited[j] && this.adjacency_matrix[current][j] != 0) {
                index = dfs(j, visited, array, index);
            }
        }
        array[index--] = current;
        return index;
    }

    // Using Topological Sort
    public int getSingleSourceShortestPathDistanceUsingTPS(int source, int destination) {
        int[] topological_sorted_array = getTopologicalSort();
        int[] min_distances = new int[this.vertices];
        Arrays.fill(min_distances, Integer.MAX_VALUE);
        min_distances[0] = 0;
        for(int node: topological_sorted_array) {
            for(int j = 0; j < this.vertices; j++) {
                if(this.adjacency_matrix[node][j] != 0) {
                    int current_distance = this.adjacency_matrix[node][j] + min_distances[node];
                    if(current_distance < min_distances[j]) {
                        min_distances[j] = current_distance;
                    }
                }
            }
        }
        return min_distances[destination]-min_distances[source];
    }
}

    

    