package app;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache
 */
public class LRUCache {

    Node head = null;
    Node tail = null;
    int length = 0;
    int capacity = 0;
    
    class Node {
        int key;
        int val;
        Node next;
        Node previous;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.previous = null;
        }
    }
    
    public void addAtHead(Node node) {
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        }
        this.length++;
    }
    
    public void deleteNode(Node node) {
        if(node == null) 
            return ;
        if(node == head) {
            if(this.head.next == null) {
                this.head = null;
                this.tail = null;
                this.length = 0;
            } else {
                Node next = this.head.next;
                next.previous = null;
                this.head.next = null;
                this.head = next;
                this.length--;
            }
        } else if(node == tail) {
            node = deleteTail();
        } else {
            Node previous = node.previous;
            Node next = node.next;
            previous.next = next;
            next.previous = previous;
            this.length--;
        }
    }

    public Node deleteTail() {
        Node node = null;
        if(this.tail == this.head) {
            node = this.tail;
            this.tail = null;
            this.head = null;
            this.length = 0;
            return node;
        }
        node = this.tail;
        this.tail = this.tail.previous;
        this.tail.next = null;
        this.length--;
        return node;
    }
    
    Map<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            if(this.head.key == key) {
                return this.head.val;
            } else {
                Node node = map.get(key);
                deleteNode(node);
                addAtHead(node);    
                return node.val;
            }
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(this.length < this.capacity) {
            if(map.containsKey(key)) {
                node = map.get(key);
                deleteNode(node);
                node = new Node(key, value);
                map.put(key, node);
                addAtHead(node);
            } else {
                node = new Node(key, value);
                map.put(key, node);
                addAtHead(node);
            }
        } else {
            if(map.containsKey(key)) {
                node = map.get(key);
                deleteNode(node);
                node = new Node(key, value);
                map.put(key, node);
                addAtHead(node);
            } else {
                node = deleteTail();
                map.remove(node.key);
                node = new Node(key, value);
                addAtHead(node);
                map.put(key, node);
            }
        }
        
    }
}