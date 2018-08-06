public class ChicagoPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        if(type.equalsIgnoreCase("cheese"))
            return new ChicagoStyleCheesePizza();
        else
            return null;
    }
}
