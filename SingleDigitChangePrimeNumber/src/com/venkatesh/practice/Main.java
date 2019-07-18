package com.venkatesh.practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    PrimeNumber primeNumber = new PrimeNumber();
	    primeNumber.shortestPath(1033, 8179);
    }
}

class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int n) {
        this.vertices = n;
        this.adjacencyList = new LinkedHashMap<Integer, List<Integer>>();
    }

    public void addEdge(int s, int d) {
        List<Integer> list;
        if(adjacencyList.containsKey(s)) {
            list = adjacencyList.get(s);
        } else {
            list = new ArrayList<Integer>();
        }
        list.add(d);
        adjacencyList.put(s, list);

        if(adjacencyList.containsKey(d)) {
            list = adjacencyList.get(d);
        } else {
            list = new ArrayList<Integer>();
        }
        list.add(s);
        adjacencyList.put(d, list);
    }

    public void printGraph() {
        System.out.println("Printing the Graph:");
        System.out.println(adjacencyList);
    }

    public void BFS(int source, int destination) {
        if(source == destination) {
            System.out.println("Source prime number and destination prime number match hence 0 steps");
            return ;
        }

        Map<Integer, Integer> visited = new HashMap();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        visited.put(source, 1);
        while(!queue.isEmpty()) {
            int element = queue.poll();
            List<Integer> list = adjacencyList.get(element);
            if(list != null) {
                for(int i: list) {
                    if(visited.getOrDefault(i, 0) == 0) {
                        visited.put(i, visited.get(element)+1);
                        if(i == destination) {
                            int steps = visited.get(i)-1;
                            System.out.println("Reached destination in "+ steps + " steps");
                            return ;
                        }
                        queue.offer(i);
                    }
                }
            }
        }
        System.out.println("Could not reach the destination prime number");
    }
}

class PrimeNumber {
    private int n;
    private boolean[] primeNumbers;

    public PrimeNumber() {
        this.n = 9999;
        this.primeNumbers = new boolean[n+1];
        generatePrimeNumber();
    }

    //Generate 0...9999 prime numbers using SieveOfEratosthenes
    private void generatePrimeNumber() {
        //primeNumber[i] == 0 means prime and 1 means not prime
        for(int i=2;i*i<=n;i++) {
            if(!primeNumbers[i]) {
                for(int j=i*i;j<=n;j=j+i) {
                    primeNumbers[j] = true;
                }
            }
        }
    }

    public void shortestPath(int primeNumber1, int primeNumber2) {
        int source, destination;
        List<Integer> range = getPrimeNumberBetweenSourceAndDestination(primeNumber1, primeNumber2);
        System.out.println("Prime Numbers between "+primeNumber1+" and "+primeNumber2);
        int vertices = range.size();
        //System.out.println("Range Size: "+range.size());
        com.venkatesh.practice.Graph graph = new com.venkatesh.practice.Graph(vertices);
        for(int i=0;i<vertices;i++) {
            source = range.get(i);
            for(int j=i+1;j<vertices;j++) {
                destination = range.get(j);
                if(isSingleDigitDifferent(source, destination))
                    graph.addEdge(source, destination);
            }
        }

        graph.printGraph();
        graph.BFS(primeNumber1, primeNumber2);
    }

    private boolean isSingleDigitDifferent(int source, int destination) {
        char[] num1 = Integer.toString(source).toCharArray();
        char[] num2 = Integer.toString(destination).toCharArray();
        int count = 0;
        for(int i=0;i<4;i++) {
            if(num1[i] != num2[i]) count++;
        }

        return (count == 1);
    }

    private List<Integer> getPrimeNumberBetweenSourceAndDestination(int primeNumber1, int primeNumber2) {
        List<Integer> rangeOfPrimeNumbers = new ArrayList<Integer>();
        for(int i=primeNumber1;i<=primeNumber2;i++) {
            if(!primeNumbers[i])
                rangeOfPrimeNumbers.add(i);
        }
        //System.out.println(rangeOfPrimeNumbers.size());
        return rangeOfPrimeNumbers;
    }
}
