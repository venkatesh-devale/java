package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }

    private static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        helper(n*2, sb, list);
        return list;
    }
    
    private static void helper(int length, StringBuilder sb, List<String> list) {
        
        if(length == 0) {
            if(isValidParenthesis(sb)) {
                list.add(sb.toString());
            }
            return ;
        }
        for(int i=0;i<length;i++) {
            sb.append("(");
            helper(length--, sb, list);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
        }
        
    }
    
    private static boolean isValidParenthesis(StringBuilder sb) {
        System.out.println(sb.toString());
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) == '(') {
                stack.push('(');
            }
            if(sb.charAt(i) == ')') {
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}