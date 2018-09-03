class Main {
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.get(1));
		hashMap.put(1,2);
		hashMap.put(10,4);
		System.out.println(hashMap.get(10));
		System.out.println(hashMap.get(1));
		hashMap.remove(11);
		hashMap.remove(10);
		System.out.println(hashMap.get(10));
		
	}
}