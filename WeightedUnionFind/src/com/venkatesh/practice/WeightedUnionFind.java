package com.venkatesh.practice;

public class WeightedUnionFind {
    private int[] size;
    private int[] parent;

    public WeightedUnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while(parent[p] != p)
            p = parent[p];
        return parent[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

}
