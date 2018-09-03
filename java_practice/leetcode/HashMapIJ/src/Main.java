class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(1, 3);
        hashMap.put(2, 4);

        // System.out.println(hashMap.get(1));				// returns 1
        // System.out.println(hashMap.get(2));            // returns 2
        // System.out.println(hashMap.get(3));            // returns -1 (not found)
        // hashMap.put(2, 1);          // update the existing value
        // System.out.println(hashMap.get(2));            // returns 1
        // hashMap.remove(2);          // remove the mapping for 2
        // System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}