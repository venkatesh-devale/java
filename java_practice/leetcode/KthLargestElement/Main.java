class Main {
	public static void main(String[] args) {
		int[] a = new int[]{};

		KthLargestElement k = new KthLargestElement(1, a);
		k.printSortedArray();
		//System.out.println(k.heapSort());
		System.out.println(k.add(-3));
		System.out.println(k.add(-2));
		System.out.println(k.add(-4));
		System.out.println(k.add(0));
		System.out.println(k.add(4));
		k.printSortedArray();
	}
}