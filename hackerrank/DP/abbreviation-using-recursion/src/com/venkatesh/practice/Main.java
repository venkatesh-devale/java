package com.venkatesh.practice;


public class Main {

    public static void main(String[] args) {
        System.out.println(abbreviation("AfPNZC", "APNZC"));
    }

    private static String abbreviation(String a, String b) {
        boolean possible = false;
        possible = abbreviationHelper(a, b);
        return (possible) ? "YES" : "NO";
    }

    private static boolean abbreviationHelper(String a, String b) {
        if(b.length() == 0) {
            if(containsUpperCase(a)) {
                return false;
            }
            return true;
        }
        if(a.length() < b.length()) {
            return false;
        }
        if(a.equals(b)) {
            return true;
        }
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);

        if(Character.isLowerCase(sbA.charAt(0))) {
            return abbreviationHelper(sbA.replace(0, 1, Character.toString(Character.toUpperCase(sbA.charAt(0)))).toString(), sbB.toString()) || abbreviationHelper(sbA.deleteCharAt(0).toString(), sbB.toString());
        } else if(sbA.charAt(0) == sbB.charAt(0)) {
            sbA.deleteCharAt(0);
            sbB.deleteCharAt(0);
            return abbreviationHelper(sbA.toString(), sbB.toString());
        } else {
            return false;
        }
    }

    private static boolean containsUpperCase(String a) {
        if(a.length() == 0) {
            return false;
        }
        for(int i=0;i<a.length();i++) {
            if(Character.isUpperCase(a.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
