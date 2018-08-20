public class Main {
    public static void main(String[] args) {
        MyCircularQueue c = new MyCircularQueue(5);
        System.out.println(c.Front());
        System.out.println(c.Rear());

        c.enQueue(1);
        c.enQueue(2);
        c.enQueue(3);
        c.enQueue(4);
        c.enQueue(5);
        System.out.println(c.Front());
        System.out.println(c.Rear());
        System.out.println("-----------------");
        c.deQueue();
        System.out.println(c.Front());
        System.out.println(c.Rear());
        System.out.println("-----------------");
        c.deQueue();
        System.out.println(c.Front());
        System.out.println(c.Rear());
        System.out.println("-----------------");
        c.enQueue(6);
        System.out.println(c.Front());
        System.out.println(c.Rear());
        System.out.println("-----------------");
        c.enQueue(7);
        System.out.println(c.Front());
        System.out.println(c.Rear());
        System.out.println("-----------------");
        c.enQueue(8);
        System.out.println(c.Front());
        System.out.println(c.Rear());
        System.out.println("-----------------");
    }
}
