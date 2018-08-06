import java.util.ArrayList;

public class Menu implements MenuComponent{
    private ArrayList<MenuComponent> menuComponentArrayList;
    protected String name;


    public Menu(String name) {
        this.name = name;
        menuComponentArrayList = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentArrayList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentArrayList.remove(menuComponent);
    }

    @Override
    public MenuComponent getMenuItem(int index) {
        if(index>=0 && index < menuComponentArrayList.size()) {
            return menuComponentArrayList.get(index);
        }

        System.out.println("Index out of bound");
        return null;
    }

    @Override
    public void print() {
        System.out.println(name);
        for (MenuComponent m: menuComponentArrayList) {
            m.print();
        }
    }


}
