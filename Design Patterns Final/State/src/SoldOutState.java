public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("You can't insert the quarter, the machine is sold out");
    }

    @Override
    public void dispense() {
        System.out.println("Cannot dispense the gumballs, the machine is sold out");
    }

    @Override
    public void turnCrank() {
        System.out.println("Cannot turn the crank, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Cannot eject quarter as machine does not has one");
    }
}

