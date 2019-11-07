package app;



/**
 * TopologicalSort
 */
public class TopologicalSort extends Graph {
    
    public TopologicalSort(int vertices) {
        super(vertices);
    }

    public int[] printTopologicalSort() {
        boolean[] visited = new boolean[this.vertices];
        int[] topologically_sorted_array = new int[this.vertices];
        int index = this.vertices-1;
        for(int i = 0;i < this.vertices; i++) {
            if(!visited[i]) {
                index = dfs(i, visited, topologically_sorted_array, index);
            }
        }
        return topologically_sorted_array;
    }

    private int dfs(int i, boolean[] visited, int[] array, int index) {
        
        visited[i] = true;

        for(int node: this.adjacencyList[i]) {
            if(!visited[node]) {
                index = dfs(node, visited, array, index);
            }
        }
        array[index--] = i;
        return index;
    }

}