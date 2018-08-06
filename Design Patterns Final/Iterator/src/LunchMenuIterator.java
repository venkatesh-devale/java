import java.util.ArrayList;

public class LunchMenuIterator implements Iterator {
    ArrayList<MenuItem> menuItemArrayList;
    int i = 0;

    public LunchMenuIterator(ArrayList<MenuItem> menuItemArrayList) {
        this.menuItemArrayList = menuItemArrayList;
    }

    @Override
    public boolean hasNext() {
        if(i < menuItemArrayList.size() && menuItemArrayList.get(i) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        return menuItemArrayList.get(i++).getName();
    }
}
