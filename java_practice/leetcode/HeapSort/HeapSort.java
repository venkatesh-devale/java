class HeapSort {

	int heapSize;
	int[] a;

	public HeapSort(int[] a) {
		heapSize = a.length-1;
		this.a = a;
		// for(int i:a) {
		// 	System.out.print(i+" ");
		// }
	}

	public void maxHeapify(int[] a, int index) {
		int left = 2*index;
		int right = 2*index+1;
		int larger = index;
		
		if(left <= heapSize && a[left] > a[index])
			larger = left;

		if(right <= heapSize && a[right] > a[larger])
			larger = right;

		if(larger != index) {
				swap(a, larger, index);
				maxHeapify(a,larger);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void buildHeap(int[] a) {
		for(int i=a.length/2-1; i>=0; i--) {
			maxHeapify(a,i);
		}
	}

	public void heapSort() {
	
		buildHeap(a);

		for(int i=a.length-1;i>=1;i--) {
			swap(a,0,heapSize);
			heapSize--;
			maxHeapify(a,0);
		}
	}

	public void printSortedArray() {
		for(int i:a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}