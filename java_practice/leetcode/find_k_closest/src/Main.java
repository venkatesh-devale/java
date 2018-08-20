import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        Solution s = new Solution();
        List<Integer> index = s.findClosestElements(a,1,1);
        for(int i: index) {
            System.out.print(i+" ");
        }
    }
}

