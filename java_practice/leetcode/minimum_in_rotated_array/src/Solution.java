public class Solution {
    public int findMin(int[] a) {
        int n = a.length;
        if(n == 1 || a[0]<a[n-1])
            return a[0];
        int mid, low = 0, high = n-1;
        while(low < high) {
            mid = (low+high)/2;
            if(a[low] > a[high])
            {
                if(a[low]<=a[mid] && a[mid]>a[mid+1])
                    low = mid +1;
                else if(a[low]>a[mid] && a[mid] > a[mid-1])
                    high = mid-1;
                else if(a[low]<a[mid] && a[mid] > a[mid-1])
                    low = mid +1;
                else if(a[mid] < a[mid-1]) {
                    if(a[mid]>a[mid+1])
                        low = mid+1;
                    else
                        return a[mid];
                }
                else
                    return a[mid+1];
            }
            else
                return a[low];
        }
        return a[low];
    }
}