package study.venkatesh;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(3, 1);
        graph.printGraph();

        //graph.bfsTraversal(2);

        //graph.dfsTraversal(2);

        //System.out.println("Recursive DFS traversal:");
        //graph.dfsRecursiveTraversal(2);
        //System.out.println("Mother Vertex: " + graph.findMotherVertex());

        //TransitiveClosure tc = new TransitiveClosure(graph);
        //tc.printTransitiveClosureMatrix();

        //FindKCoresUndirected findKCoresUndirected = new FindKCoresUndirected(graph);
        //findKCoresUndirected.findKCoresUndirected(3);

        CountAllPossiblePathsBetweenTwoVertices countAllPossiblePathsBetweenTwoVertices = new CountAllPossiblePathsBetweenTwoVertices(graph);
        countAllPossiblePathsBetweenTwoVertices.countAllPossiblePathsBetweenTwoVertices(0,2);
    }
}

class Graph {
    private int vertices;
    private List<Integer> adjacencyList[];
    private boolean[] visited;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.visited = new boolean[vertices];
        this.adjacencyList = new List[vertices];

        for(int i=0;i<vertices;i++) {
            this.adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public void printGraph() {
        for(int i=0;i<vertices;i++) {
            System.out.print("vertex : " + i + " -> ");
            for(int temp: this.adjacencyList[i])
                System.out.print("  " + temp);
            System.out.println();
        }
    }

    public void bfsTraversal(int source) {
        System.out.println("BFS Traversal");
        boolean[] visited = new boolean[this.vertices];
        Queue<Integer> queue = new LinkedList<>();

        if(source >= 0 && source < vertices) {
            queue.offer(source);
            visited[source] = true;
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                List<Integer> edges = this.adjacencyList[vertex];
                for(int destination: edges) {
                    if(!visited[destination]) {
                        queue.offer(destination);
                        visited[destination] = true;
                    }
                }
            }
        }
        System.out.println();
    }

    public void dfsTraversal(int source) {
        System.out.println("Iterative DFS Traversal");
        boolean[] visited = new boolean[this.vertices];
        Stack<Integer> stack = new Stack<>();
        if(source >= 0 && source < vertices) {
            stack.push(source);
            visited[source] = true;
        }

        while(!stack.empty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");
            Iterator<Integer> iterator = this.adjacencyList[vertex].listIterator();
            while(iterator.hasNext()) {
                int destination = iterator.next();
                if(!visited[destination]) {
                    stack.push(destination);
                    visited[destination] = true;
                }
            }

        }
        System.out.println();
    }

    public void dfsRecursiveTraversal(int source) {
        if(source < 0 && source > this.vertices) {
            return;
        }

        if(!this.visited[source]) {
            this.visited[source] = true;
            //System.out.print(source + " ");
            Iterator<Integer> iterator = this.adjacencyList[source].listIterator();
            while(iterator.hasNext()) {
                int destination = iterator.next();
                dfsRecursiveTraversal(destination);
            }
        }


    }

    public int findMotherVertex () {
        int motherVertex = 0;

        for(int i=0;i<this.vertices;i++) {
            if(!this.visited[i]) {
                dfsRecursiveTraversal(i);
                motherVertex = i;
            }
        }

        this.visited = new boolean[this.vertices];
        dfsRecursiveTraversal(motherVertex);
        for(boolean value: this.visited) {
            if(!value) return -1;
        }

        return motherVertex;
    }

    public int getVertices() {
        return this.vertices;
    }


    public List<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }
}
