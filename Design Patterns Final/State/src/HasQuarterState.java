public class HasQuarterState implements State {

    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You have already inserted the quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You cannot dispense a gumball before turning crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned the crank");
        gumballMachine.setCurrentState(gumballMachine.getSellingState());
        gumballMachine.getCurrentState().dispense();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter Returned");
        gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
    }
}
