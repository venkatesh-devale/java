package app;

/**
 * DLL
 */
public class DLL {

    private Node head = null;
    private int length = 0;

    class Node {
        private int val;
        private Node next;
        private Node previous;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.previous = null;
        }
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(this.head != null) {
            newNode = new Node(val);
            newNode.next = this.head;
            this.head.previous = newNode;
        }
        this.head = newNode;
        this.length++;
    }

    public void addAtTail(int val) {
        if(this.head == null) {
            addAtHead(val);
            return ;
        }
        Node newNode = new Node(val);
        Node p = this.head;
        while(p.next != null) {
            p = p.next;
        } 
        p.next = newNode;
        newNode.previous = p;
        this.length++;
    }

    public void insertAfter(Node previousNode, int val) {
        
        if(previousNode == null) {
            return ;
        }
        
        if(previousNode.next == null) {
            addAtTail(val);
            return ;
        }
        Node newNode = new Node(val);
        newNode.next = previousNode.next;
        previousNode.next.previous = newNode;
        newNode.previous = previousNode;
        previousNode.next = newNode;
        this.length++;
    }

    public void insertBefore(Node nextNode, int val) {
    
        if(nextNode == null) {
            return ;
        }

        if(nextNode.previous == null) {
            addAtHead(val);
            return ;
        }

        Node newNode = new Node(val);
        newNode.next = nextNode;
        newNode.previous = nextNode.previous;
        nextNode.previous.next = newNode;
        nextNode.previous = newNode;
        this.length++;
    }

    public void printDLL() {
        if(this.head == null) {
            System.out.println("The DLL is empty");
            return ;
        }

        Node p = this.head;

        while(p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }

        System.out.println();
    }

    public int getLengthOfDLL() {
        return this.length;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getNext(Node node) {
        return node.next;
    }

    public Node getPrevious(Node node) {
        return node.previous;
    }

    public void deleteNode(Node node) {
        if(node == null) {
            return ;
        }

        if(node == head) {
            if(head.next == null) {
                this.head = null;
                this.length = 0;
            } else {
                this.head.next.previous = null;
                this.head = this.head.next;
                this.length--;
            }
            return ;
        }

        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = null;
        node.previous = null;

    }
    
}