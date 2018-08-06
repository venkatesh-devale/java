public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }


    @Override
    public void cut() {
        System.out.println("Pizza is served cutting into sqaures");
    }
}
