package com.venkatesh.test;

public class Main {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbabcd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int si = 0, ei = 0, max = 0;
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        while(ei < array.length) {
            int index = sb.lastIndexOf(String.valueOf(array[ei]));
            System.out.println("Index:" + index);
            if(index == -1) {
                sb.append(array[ei]);
                System.out.println(sb.toString());
            } else {
                if(max < (ei-si))
                    max = (ei-si);
                si = ei;
                sb = new StringBuilder(s.substring(si, ei+1));
                System.out.println(sb.toString());
            }

            ei++;
        }
        return max;
    }
}
