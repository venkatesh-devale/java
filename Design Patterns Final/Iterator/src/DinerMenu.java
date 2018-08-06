public class DinerMenu extends Menu {
    MenuItem[] menuItems;
    private static final int MAX_SIZE = 4;
    int countOfMenu = 0;

    public DinerMenu(String name) {
        super(name);
        menuItems = new MenuItem[MAX_SIZE];
        addItem("Bhaji");
        addItem("Chapati");
        addItem("Papad");
        addItem("Rice");
        addItem("lonacha");

    }

    public void addItem(String name) {
        MenuItem menuItem = new MenuItem(name);
        if(countOfMenu < menuItems.length) {
            menuItems[countOfMenu] = menuItem;
            countOfMenu += 1;
            System.out.println("Added " + name + " to Diner Menu Items");
        }
        else {
            System.out.println("Cannot add "+ name +" anymore Menu Items as size is fixed and full now");
        }
    }


    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
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
