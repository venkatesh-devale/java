package study.venkatesh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountAllPossiblePathsBetweenTwoVertices {
    Graph graph;
    int vertices;
    List<List<Integer>> pathList;
    boolean[] visited;
    int numPaths = 0;

    public CountAllPossiblePathsBetweenTwoVertices(Graph graph) {
        this.graph = graph;
        this.vertices = graph.getVertices();
        this.visited = new boolean[vertices];
        pathList = new ArrayList<>();
    }

    public void countAllPossiblePathsBetweenTwoVertices(int source, int destination) {
        List<Integer> path = new LinkedList<>();
        path.add(source);
        countAllPossiblePathsBetweenTwoVertices(source, destination, path);
        System.out.println(numPaths);
        System.out.println(pathList);
    }

    public void countAllPossiblePathsBetweenTwoVertices(int source, int destination, List<Integer> path) {
        if(!visited[source]) {
            visited[source] = true;
            for(int i: this.graph.getAdjacencyList()[source]) {

                path.add(i);
                if(i == destination) {
                    pathList.add(new ArrayList<>(path));
                    numPaths++;
                    path.remove(path.size()-1);
                } else {
                    countAllPossiblePathsBetweenTwoVertices(i, destination, path);
                    path.remove(path.size()-1);
                }
            }
        }


    }

}
