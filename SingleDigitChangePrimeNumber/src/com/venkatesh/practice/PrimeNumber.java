package com.venkatesh.practice;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
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
        Graph graph = new Graph(vertices);
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
