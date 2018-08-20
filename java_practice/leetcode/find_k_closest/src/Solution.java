import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> l = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;
        int mid, index=0;
        while(low <= high) {
            mid= (low+high)/2;
            if(arr[mid]<=x){
                if(arr[mid] == x) {
                    index = mid;break;
                }

                else if((mid-1)>=0 && arr[mid-1] == x) {
                    index = mid-1;break;
                }

                else if((mid+1<=high) && arr[mid+1] == x) {
                    index = mid+1; break;
                }

                else if((mid+1<=high) && arr[mid+1] > x) {
                    index = mid; break;
                }

                else
                    low = mid+1;
            }
            else {
                if((mid-1>=0) && arr[mid-1] < x) {
                    index = mid;break;
                }

                high = mid-1;
            }
        }
        int i = index-1;
        int j = index;
        while(k-- > 0) {
            if(i<0 || (j<arr.length && (Math.abs(arr[j]-x) < (Math.abs(arr[i]-x))))){
                j++;
            }
            else i--;
        }
        for(int m = i+1; m < j; m++)
            l.add(arr[m]);
        return l;
    }
}