public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        if(nums == null || n == 0)
            return -1;
        int pivot = findPivot(nums, 0, n-1);
        System.out.println(pivot);
        if(pivot == -1) //no rotated array
            return binarySearch(nums, 0, n-1, target);
        if(nums[pivot] == target)
            return pivot;
        if(nums[0] > target)
            return binarySearch(nums, pivot+1,n-1,target);
        return binarySearch(nums, 0, pivot-1,target);

    }

    private int findPivot(int[] a, int low, int high) {
        if(high < low) return -1;
        if(high == low) return low;

        int mid = (low+high)/2;
        
        if(mid<high && a[mid]<a[mid+1])
            return mid;
        if(mid>low && a[mid]>a[mid-1])
            return (mid-1);
        if(a[low]>=a[mid])
            return findPivot(a,low,mid-1);
        return findPivot(a, mid+1, high);
    }

    private int binarySearch(int[] a, int low, int high, int target) {
        int l = low;
        int r = high;
        int mid;

        while(l<=r) {
            mid = (l+r)/2;
            if(a[mid] == target)
                return mid;
            if(a[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }
}