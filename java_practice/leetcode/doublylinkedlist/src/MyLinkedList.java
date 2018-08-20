public class MyLinkedList {
    Node head = null;
    int size = 0;

    class Node {
        int val;
        Node next, prev;

        public Node(int v) {
            val = v;
            next = null;
            prev = null;
        }
    }

    public void print() {
        Node p = head;
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void printReverse() {
        Node p = head;
        while(p.next != null) {
            p = p.next;
        }
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.prev;
        }
        System.out.println();
    }

    public int get(int index) {
        Node p = head;
        if(index >= 0 && index < size) {
            for(int i=0;i<index;i++) {
                p = p.next;
            }
            return p.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        Node new_node = new Node(val);
        if(index == 0) {
            if(head == null) {
                head = new_node;
                size++;
            }
            else {
                new_node.next = head;
                head.prev = new_node;
                head = new_node;
                size++;
            }
        }
        else if(index == size) {
            Node p = head;
            while(p.next != null)
                p = p.next;
            p.next = new_node;
            new_node.prev = p;
            size++;
        }
        else if(index > 0 && index < size) {
            Node p = head;
            for(int i=1;i<index;i++) {
                p = p.next;
            }
            new_node.next = p.next;
            p.next.prev = new_node;
            p.next = new_node;
            new_node.prev = p;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        //head deletion
        //last node deletion
        //deletion of indexed node

        if(index == 0) {
            if(head != null) {
                if(head.next == null) {
                    head = null;
                    size--;
                }
                else {
                    head = head.next;
                    head.prev = null;
                    size --;
                }

            }
        }
        else if(index > 0 && index < size) {
            Node p = head;
            for(int i=0;i<index;i++)
                p = p.next;
            p.prev.next = p.next;
            if(p.next != null)
                p.next.prev = p.prev;
            else
                p.prev = null;
            size--;
        }
    }
}
