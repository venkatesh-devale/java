import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacency_list;

    public Graph(int n) {
        vertices = n;
        adjacency_list = new LinkedList[n];
        for(int i=0;i<n;i++) {
            adjacency_list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int srcVertex, int destVertex) {
        if(srcVertex >= 0 && destVertex < vertices)
            adjacency_list[srcVertex].add(destVertex);
        else
            System.out.println("Invalid source and destination");
    }

    public void print() {
        for(int i=0;i<vertices;i++) {
            Iterator<Integer> itr = adjacency_list[i].listIterator();
            System.out.println("vertex :"+ i);
            System.out.println("Edges are:");
            while(itr.hasNext()) {
                System.out.print(itr.next()+"  ");
            }
            System.out.println();
        }
    }

    public void bfs(int startVertex) {
        Queue<Integer> q = new LinkedList<Integer>();
        LinkedList<Integer> visited = new LinkedList<>();
        q.add(startVertex);
        visited.add(startVertex);
        while(!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");
            Iterator<Integer> it = adjacency_list[temp].listIterator();
            while(it.hasNext()) {
                int temp2 = it.next();
                if(visited.contains(temp2)) {
                    continue;
                }
                visited.add(temp2);
                q.add(temp2);
            }
        }
    }
}
