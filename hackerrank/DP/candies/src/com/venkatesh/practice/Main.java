package com.venkatesh.practice;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    long candies = candies(6, new int[]{4,6,4,5,6,2});
        System.out.println("Candies:"+ candies);
    }

    private static long candies(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++) {
            if(arr[i-1]<arr[i]) {
                dp[i] = dp[i-1]+1;
            }
        }

        for(int i=n-1;i>0;i--) {
            if(arr[i-1]>arr[i]) {
                if(dp[i-1] <= dp[i]) {
                    dp[i-1] = dp[i]+1;
                }
            }
        }
        long candies = 0;
        for(long i: dp) {
            candies+=i;
        }
        return candies;
    }
}
