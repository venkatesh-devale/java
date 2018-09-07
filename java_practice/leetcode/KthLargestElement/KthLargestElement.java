import java.util.Arrays;

class KthLargestElement {

	int heapSize, k;
	int[] a;
	
    public KthLargestElement(int k, int[] nums) {
        // if(nums.length == 0)
        //     heapSize = 0;
        // else
        heapSize = nums.length-1;
        this.k = k;
        a = nums;
    }
    
    public int add(int val) {
        int[] newArray = Arrays.copyOf(a, a.length+1);
        a = newArray;
        heapSize = a.length-1;
        //System.out.println("Printing after addition of element:"+heapSize);
        a[newArray.length-1] = val;
        //printSortedArray();
        return heapSort();    
    }

    public void buildMaxHeap() {
        //if(a.length == 0) return;
    	for(int i=a.length/2-1;i>=0;i--) {
    		maxHeapify(a, i);
    	}
    }

    public void maxHeapify(int[] a, int i) {
    	int leftChild = 2*i;
    	int rightChild = 2*i+1;
    	int larger = i;
    	if(leftChild <= heapSize && a[leftChild] > a[i])
    		larger = leftChild;

    	if(rightChild <= heapSize && a[rightChild] > a[larger])
    		larger = rightChild;

    	if(larger != i) {
    		swap(a,i,larger);
    		maxHeapify(a,larger);
    	}
    }

    //this is nothing but modified kthLargerElement method
    public int heapSort() {
        int i=0;
        buildMaxHeap();
        //System.out.println(a.length-k);
        
    	for(i=a.length-1;i>=1;i--) {
    		swap(a,0,heapSize);
    		heapSize--;
    		maxHeapify(a,0);

    	}
        
        return a[a.length-k];
    	//return a[i];
    }

    public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void printSortedArray() {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}