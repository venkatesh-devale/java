class Main {
	public static void main(String[] args) {
		int[] a = new int[]{14,16,17,1,2,3,4,5};

		HeapSort h = new HeapSort(a);
		h.printSortedArray();
		h.heapSort();
		h.printSortedArray();
	}
}