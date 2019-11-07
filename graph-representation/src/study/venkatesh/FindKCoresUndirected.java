package study.venkatesh;

import java.util.LinkedList;
import java.util.Queue;

public class FindKCoresUndirected {
    Graph graph;
    int vertices;

    public FindKCoresUndirected(Graph graph) {
        this.graph = graph;
        vertices = graph.getVertices();
    }

    private void dfsUtil(int source, boolean[] visited, int[] degree, int k) {
        visited[source] = true;
        System.out.print(source + "->");
        for(int i: this.graph.getAdjacencyList()[source]){
            if(degree[i] >= k)
                System.out.print(" " + i);
        }

        System.out.println();

        for(int i: this.graph.getAdjacencyList()[source]){
            if(!visited[i] && degree[i] >= k)
                dfsUtil(i, visited, degree, k);
        }
    }

    public void findKCoresUndirected(int k) {
        int[] degree = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<vertices;i++) {
            degree[i] = this.graph.getAdjacencyList()[i].size();
            if(degree[i] < k)
                queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            degree[vertex] = 0;
            for(int i: this.graph.getAdjacencyList()[vertex]) {
                if(degree[i] != 0) {
                    degree[i]--;
                    if(degree[i] < k) {
                        queue.offer(i);
                    }
                }
            }
        }

        for(int i=0;i<vertices;i++) {
            if(!visited[i] && degree[i] >= k) {
                dfsUtil(i, visited, degree, k);
            }
        }

    }
}
