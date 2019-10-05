package app;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int n = 4;
        int k = 3;

        List<List<Integer>> finalList = combine(n,k);
        System.out.println(finalList);

    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalList = new ArrayList<>();
        helperCombine(1, new ArrayList<>(), n, k, finalList);   
        return finalList;
    }
    
    private static void helperCombine(int start, List<Integer> list, int n, int k, List<List<Integer>> finalList) {
        if(list.size() == k) {
            finalList.add(new ArrayList<>(list));
            return ;
        }
        
        for(int i=start;i<=n;i++) {
            Integer temp = Integer.valueOf(i);
            list.add(temp);
            helperCombine(i+1, list, n, k, finalList);
            list.remove(temp);
        }
    }
}