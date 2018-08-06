public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtIndex(0,1);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));

    }

}
