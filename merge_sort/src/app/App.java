package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] result = sortArray(new int[]{5,2,3,1});
        System.out.println("Array after sorting:");
        for(int i: result) {
            System.out.print(i+ " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        if(nums.length == 1) return nums;
        
        int pivot = nums.length/2;
        int[] leftArray = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] rightArray = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));

        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] a, int[] b) {
        int[] mergedArray = new int[a.length+b.length];

        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] <= b[j]) {
                mergedArray[k++] = a[i++];
            } else {
                mergedArray[k++] = b[j++];
            }
        }

        if(i == a.length) {
            return mergeRemainingArray(mergedArray, b, j, k);
        }
        return mergeRemainingArray(mergedArray, a, i, k);
    }

    public static int[] mergeRemainingArray(int[] mergedArray, int[] a, int i, int k) {
        while(i < a.length) {
            mergedArray[k++] = a[i++];
        }

        return mergedArray;
    }
}