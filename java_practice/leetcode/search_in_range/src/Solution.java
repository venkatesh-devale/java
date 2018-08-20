public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length-1;
        if(n == 0)
            return new int[]{-1,-1};
        int indexTarget = findTarget(nums, 0, n, target);
        if(indexTarget == -1)
            return new int[]{-1,-1};
        int start = findStart(nums, 0, indexTarget-1, target);
        int end = findEnd(nums, indexTarget+1, n, target);
        if(start == -1)
            start = indexTarget;
        if(end == -1)
            end = indexTarget;
        return new int[]{start,end};
    }

    private int findTarget(int[] a, int low, int high, int target) {
        int mid;
        while(low <= high) {
            mid = (low + high)/2;
            if(a[mid] == target)
                return mid;
            if(a[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    private int findStart(int[] a, int low, int high, int target) {
        if(a[0] == target) {
            return 0;
        }
        int mid;
        while(low <= high) {
            mid = (low+high)/2;
            if(a[mid]==target) {
                if(mid > 0 && a[mid-1] < target) {
                    return mid;
                }
                else {
                    high = mid-1;
                }
            }
            else if(a[mid]<target) {
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return -1;
    }

    private int findEnd(int[] a, int low, int high,int target) {
        int mid;
        while(low<=high) {
            mid = (low+high)/2;
            if(a[mid] == target) {
                if(mid == high)
                    return mid;
                if(a[mid+1]>target)
                    return mid;
                else
                    low = mid+1;
            }
            else if(a[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}