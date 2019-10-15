package app;

/*
["LRUCache","put","get","put","get","get"]
[[1],[2,1],[2],[3,2],[2],[3]]
*/

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        System.out.println(lruCache.get(2));
        lruCache.put(3,2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }

    
}