import java.util.*;

class MyHashMap {

    class HashMapNode {
        int key;
        int value;
        HashMapNode next;

        public HashMapNode(int k, int v) {
            key = k;
            value = v;
            next = null;
        }
    }


    LinkedList<HashMapNode>[] hashMap;

    public MyHashMap(){
        hashMap = new LinkedList[1000];
    }

    private int getHashedIndex(int key) {
        return key%1000;
    }

    public void put(int key, int value) {
        int hashedIndex = getHashedIndex(key);
        if(hashMap[hashedIndex] == null) {
            hashMap[hashedIndex] = new LinkedList<HashMapNode>();
            HashMapNode newNode = new HashMapNode(key,value);
            hashMap[hashedIndex].add(newNode);
            System.out.println("New node added with value "+ value +" for Key: "+ key);
        }
        else { //collision handling
            HashMapNode searchedNode = searchKey(hashMap[hashedIndex], key);
            if(searchedNode == null) { //if key not found
                HashMapNode newNode = new HashMapNode(key,value);
                hashMap[hashedIndex].add(newNode);
                System.out.println("New node added with value "+ value +" for Key: "+ key);
            }
            else { //if key found update it's value
                int oldvalue = searchedNode.value;
                searchedNode.value = value;
                System.out.println("Previous value "+ oldvalue +"updated to "+ searchedNode.value +" for Key: "+ key);
            }
        }
    }

    private HashMapNode searchKey(LinkedList<HashMapNode> head, int key) {
        HashMapNode temp = head.getFirst();
        while(temp != null) {
            if(temp.key == key) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

//    public int get(int key) {
//
//    }
//
//    public void remove(int key) {
//
//    }
}

