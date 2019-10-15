package app;

import app.DLL.Node;



public class App {
    public static void main(String[] args) throws Exception {
        DLL dll = new DLL();

        dll.printDLL();
        dll.addAtTail(10);
        

        dll.addAtHead(5);
        dll.insertAfter(dll.getHead(), 4);
        Node nextNode = dll.getHead();
        dll.insertBefore(dll.getNext(nextNode), 1);
        dll.printDLL();
        dll.deleteNode(dll.getHead());
        dll.printDLL();
    }
}