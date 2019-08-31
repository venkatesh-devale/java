package com.venkatesh.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println(abbreviation("daBcd", "ABC"));
    }

    private static String abbreviation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[a.length()+1][b.length()+1];
        dp[0][0] = 1;
        for(int i=0;i<a.length();i++) {
            for(int j=0;j<=b.length();j++) {
                if(dp[i][j] == 1) {
                    if(j < b.length() && Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                        dp[i+1][j+1] = 1;
                    }
                    if(Character.isLowerCase(a.charAt(i))) {
                        dp[i+1][j] = 1;
                    }
                }
            }
        }
        return (dp[n][m] == 1) ? "YES" : "NO";
    }
}
