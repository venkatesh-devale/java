class MyLinkedList {
    Node head;
    static int size;
    /** Initialize your data structure here. */
    class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
            next = null;
        }
    }
    public MyLinkedList() {
        head = null;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i=0;
        if(head == null) {
            return -1;
        }

        Node temp = head;

        while(i<index && temp.next != null) {
            temp = temp.next;
            i++;
        }
        if(i == index)
            return temp.val;
        return -1;

    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null) {
            head = new Node(val);
            MyLinkedList.size++;
        }
        else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            MyLinkedList.size++;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            MyLinkedList.size++;
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            MyLinkedList.size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int i=0;
        if(index == 0) {
            addAtHead(val);
        }
        else if(index == MyLinkedList.size) {
            addAtTail(val);
        }
        else if(index > 0 && index < MyLinkedList.size){
            Node temp = head;
            Node newNode  = new Node(val);
            while(i < index-1) {
                temp = temp.next;
                i++;
            }
            System.out.println("hi");
            newNode.next = temp.next;
            temp.next = newNode;
            MyLinkedList.size++;
        }
    }


    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int i = 0;
        if(index == 0) {
            if(head.next == null) {
                head = null;
            }
            else {
                Node temp = head.next;
                head = temp;
            }
            MyLinkedList.size--;
        }
        else if(index > 0 && index < MyLinkedList.size) {
            Node temp = head;
            while(i!=index-1) {
                temp = temp.next;
                i++;
            }
            if(temp.next.next == null) {
                temp.next = null;
            }
            else {
                temp.next = temp.next.next;
            }
            MyLinkedList.size--;
        }
    }
}