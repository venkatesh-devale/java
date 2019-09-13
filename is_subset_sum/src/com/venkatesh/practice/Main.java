package com.venkatesh.practice;

public class Main {

    public static void main(String[] args) {
        int[] array = {2,3,7,8,10};
        int target = 13;
        System.out.println(isSubsetSum(array, target));
    }

    public static boolean isSubsetSum(int[] array, int target) {
        boolean[][] dp = new boolean[array.length][target+1];
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<dp[0].length;i++) {
            if(array[0] == i) {
                dp[0][i] = true;
            }
        }

        for(int i=1;i<dp.length;i++) {
            for(int j=1; j<dp[0].length;j++) {
                if(array[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i]];
                }
            }
        }
        return dp[array.length-1][target];
    }
}
