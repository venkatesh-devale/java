package hackerrank.DP.max_subset_sum;
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {3,5,-7,8,10};
        System.out.println(maxSubsetSum(arr));
    }

    static int maxSubsetSum(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return arr[0];
        }
        int[] sumArr = new int[arr.length];
        int maxSum = Math.max(arr[0], arr[1]);
        sumArr[0] = arr[0];
        sumArr[1] = arr[1];
        for(int i=2;i<arr.length;i++) {
            
            int immediateNonAdjacent = sumArr[i-2];
            int lastImmediateNonAdjacent = 0;
            if(i-3>=0) {
                lastImmediateNonAdjacent = sumArr[i-3];
            }
            int immediateNonAdjacentSum = immediateNonAdjacent + arr[i];
            int lastImmediateNonAdjacentSum = lastImmediateNonAdjacent + arr[i];
            sumArr[i] = Math.max(Math.max(Math.max(immediateNonAdjacentSum, lastImmediateNonAdjacentSum), arr[i]), immediateNonAdjacent);
            maxSum = Math.max(sumArr[i], maxSum);
        }
        return maxSum;
    }
}