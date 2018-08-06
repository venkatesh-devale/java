public class Client {
    public static void main(String[] args) {
        MenuComponent dinerMenu = new DinerMenu("Diner Menu");

        MenuComponent lunchMenu = new LunchMenu("Lunch Menu");

        MenuComponent allMenus = new Menu("All Menus");
        allMenus.add(dinerMenu);
        allMenus.add(lunchMenu);

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
