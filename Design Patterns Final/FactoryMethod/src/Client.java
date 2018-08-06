public class Client {


    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();


        //Ethan's Order
        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan Ordered: " + pizza.getName());

        //Paul's Order
        pizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Paul Ordered: " + pizza.getName());
    }






}
