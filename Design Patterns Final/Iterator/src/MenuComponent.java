public interface MenuComponent {
    void add(MenuComponent menuComponent);
    void remove(MenuComponent menuComponent);
    MenuComponent getMenuItem(int index);
    void print();
}
