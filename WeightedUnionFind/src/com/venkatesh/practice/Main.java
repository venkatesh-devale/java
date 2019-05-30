package com.venkatesh.practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
	    int n = scanner.nextInt();
        int p,q;
	    WeightedUnionFind weightedUnionFind = new WeightedUnionFind(n);
        System.out.println("Input P(source):");
        p = scanner.nextInt();

        System.out.println("Input Q(destination):");
        q = scanner.nextInt();
	    while(true) {
            System.out.println("----Menu-----");
            System.out.println("1. Checked if connected");
            System.out.println("2. Union P and Q");
            System.out.println("3. Exit");
            int ans = scanner.nextInt();
            switch (ans) {
                case 1:
                    System.out.println(weightedUnionFind.connected(p,q));
                    break;

                case 2:
                    weightedUnionFind.union(p, q);
                    break;

                case 3:
                    System.exit(0);

                default: break;
            }
        }



    }
}
