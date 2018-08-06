import java.util.ArrayList;

public class LunchMenu extends Menu {
    ArrayList<MenuItem> menuItemArrayList;

    public LunchMenu(String name) {
        super(name);
        menuItemArrayList = new ArrayList<>();
        MenuItem menuItem = new MenuItem("usal");
        menuItemArrayList.add(menuItem);
        menuItem = new MenuItem("varan");
        menuItemArrayList.add(menuItem);
        menuItem = new MenuItem("bhat");
        menuItemArrayList.add(menuItem);
    }


    public Iterator createIterator() {
        return new LunchMenuIterator(menuItemArrayList);
    }

    @Override
    public void print() {
        System.out.println(name);
        Iterator iterator = this.createIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
