public class Main {
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();

        l.addAtHead(0);
        l.print();
        System.out.println(l.get(1));
        l.addAtTail(2);
        l.print();
        l.addAtIndex(1,4);
        l.print();
        l.addAtHead(4);
        l.print();
        l.addAtIndex(1,4);
        l.print();
        l.addAtTail(5);
        l.print();
        l.addAtTail(2);
        l.print();
        l.addAtIndex(2,0);
        l.print();
        System.out.println(l.get(2));
        l.addAtTail(1);
        l.print();
    }
}
