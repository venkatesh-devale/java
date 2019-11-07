package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Graph
 */
public class Graph {

    class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [to=" + to + ", weight=" + weight + "]";
        }

        
    }

    class PQCustomComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            if(o1.weight < o2.weight) {
                return -1;
            }   
            else if(o1.weight == o2.weight) {
                return 0;
            }
            return 1;
        }
    }

    class MinDistancePath {
        int[] min_distance;
        int[] parents;

        public MinDistancePath(int[] min_distance, int[] parents) {
            this.min_distance = min_distance;
            this.parents = parents;
        }
    }
    int vertices;
    Map<Integer, List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int from, int to, int weight) {
        List<Edge> list = null;
        if(adjacencyList.containsKey(from)) {
            list = this.adjacencyList.get(from);
        } else {
            list = new ArrayList<>();
        }
        list.add(new Edge(to, weight));
        this.adjacencyList.put(from, list);
    }

    public void printGraph() {
        System.out.println(this.adjacencyList);
    }

    

    public MinDistancePath djikstraForSingleSourceShortestPath(int from) {
        int[] min_distance = new int[this.vertices];
        int[] parents = new int[this.vertices];
        Arrays.fill(parents, -1);
        Arrays.fill(min_distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[this.vertices];
        min_distance[from] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new PQCustomComparator());
        pq.add(new Edge(0,0));
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int index = edge.to;
            visited[index] = true;
            if(min_distance[index] < edge.weight) continue;
            List<Edge> edges = this.adjacencyList.get(index);
            if(edges != null) {
                for(Edge node: edges) {
                    if(!visited[node.to]) {
                        int new_distance = min_distance[index] + node.weight;
                        if(new_distance < min_distance[node.to]) {
                            parents[node.to] = index;
                            min_distance[node.to] = new_distance;
                            pq.add(new Edge(node.to, new_distance));
                        }
                    }
                }
            }
        }
        return new MinDistancePath(min_distance, parents);
    }
}