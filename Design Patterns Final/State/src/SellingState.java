public class SellingState implements State {
    private GumballMachine gumballMachine;

    public SellingState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("Please wait, machine is releasing the gumball");
    }

    @Override
    public void dispense() {
        if(gumballMachine.getCount() > 0) {
            gumballMachine.releaseGumball();
            if(gumballMachine.getCount() > 0) {
                gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
            }
            else {
                System.out.println("Sorry the machine is out of gumball now");
                gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
            }
        }
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning crank will not get you another gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry you cannot eject the quarter after turning the crank");
    }
}
