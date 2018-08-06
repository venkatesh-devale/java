public class NoQuarterState implements State {
    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("Got a quarter...");
        gumballMachine.setCurrentState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void dispense() {
        System.out.println("Please insert a quarter first...");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please insert a quarter first...");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Please insert a quarter first...");
    }
}
