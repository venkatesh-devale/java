public class DinerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }



    @Override
    public boolean hasNext() {
        if(position < menuItems.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        String menuName = menuItems[position++].getName();
        return menuName;
    }
}
