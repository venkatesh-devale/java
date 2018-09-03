import java.util.*;

class HashSet {
	/** Initialize your data structure here. */
	LinkedList<Integer>[] hashtable;

    public HashSet() {
         hashtable = new LinkedList[1000];
         //System.out.println("HashTable Initialized");
    }

    public int getHashIndex(int key) {
        //my hash function
        return key%1000;
    }

    public void add(int key) {
        int hashIndex = getHashIndex(key);
        if(!contains(key)) {
            if(hashtable[hashIndex] == null) {
                hashtable[hashIndex] = new LinkedList<Integer>();
            }
            hashtable[hashIndex].add(key);
            //System.out.println("Key inserted: "+key);
        }
        // else
        //     System.out.println("Key already present: "+key);
    }
    
    public void remove(int key) {

        int hashIndex = getHashIndex(key);
        //System.out.println("Hashed Index:"+ hashIndex + " and Key is:" + key);
        if(contains(key)) {
            hashtable[hashIndex].remove(new Integer(key));
            if(hashtable[hashIndex].size()==0)
                hashtable[hashIndex] = null;
            //System.out.println("Key removed: "+key);   
        }
        // else {
        //     System.out.println("Key not present to remove: "+key);
        // }
    }
    
    //Returns true if this set contains the specified element 
    public boolean contains(int key) {
        int hashIndex = getHashIndex(key);
        LinkedList<Integer> temp = hashtable[hashIndex];
        if(temp == null)
            return false;
        for(int i=0;i<temp.size();i++) {
            if(temp.get(i) == key)
                return true;
        }
        return false;
    }
}
