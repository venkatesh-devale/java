public class MenuItem implements MenuComponent{
    String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        //do nothing
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        //do nothing
    }

    @Override
    public MenuComponent getMenuItem(int index) {
        //do nothing
        return null;
    }

    @Override
    public void print() {
        System.out.println(name);
    }
}
