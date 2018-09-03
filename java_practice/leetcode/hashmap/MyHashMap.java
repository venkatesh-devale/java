import java.util.*;

class MyHashMap {

	private HashMapNode[] hashTable;

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

	public MyHashMap(){
		hashTable = new HashMapNode[1000];
	}

	private int getHashedIndex(int key) {
		return key%hashTable.length;
	}

	public void put(int key, int value) {
		int index = getHashedIndex(key);
		HashMapNode h = new HashMapNode(key, value);
		if(hashTable[index] == null) {
			hashTable[index] = h;
		}
		else {
			updateNode(hashTable[index],h);
		}
	}

	private void updateNode(HashMapNode head, HashMapNode newNode) {
		HashMapNode p = head;
		HashMapNode q = head;
		while(p != null) {
			if(p.key == newNode.key) {
				p.value = newNode.value;
				return;
			}
			q = p;
			p = p.next;
		}
		q.next = newNode;
	}

	public int get(int key) {
		int index = getHashedIndex(key);
		if(hashTable[index] == null)
			return -1;
		HashMapNode p = hashTable[index];
		while(p!=null) {
			if(p.key == key) 
				return p.value;
			p=p.next;
		}
		return -1;
	}

	public void remove(int key) {
		int index = getHashedIndex(key);
		if(hashTable[index] != null) {
			HashMapNode head = hashTable[index];
			if(head.key == key) {
				hashTable[index] = head.next;
				head.next = null;
			} else {
				HashMapNode temp = head;
				HashMapNode prev = head;
				while(temp != null && temp.key!=key) {
					prev = temp;
					temp = temp.next;
				}
				if(temp != null) {
					prev.next = temp.next;
					temp.next = null;
				}
			}
		}
	}
}

