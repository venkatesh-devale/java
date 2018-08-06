public class GumballMachine implements State{
    private int count = 0;
    private State noQuarterState;
    private State hasQuarterState;
    private State sellingState;
    private State soldOutState;

    private State currentState;

    public GumballMachine(int count) {
        this.count = count;
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        sellingState = new SellingState(this);
        soldOutState = new SoldOutState(this);
        currentState = noQuarterState;
    }

    public int getCount() {
        return count;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public State getNoQuarterState() {
        return this.noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSellingState() {
        return sellingState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public void insertQuarter() {
        currentState.insertQuarter();
    }

    @Override
    public void dispense() {
        currentState.dispense();
    }

    @Override
    public void turnCrank() {
        currentState.turnCrank();
    }

    @Override
    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void releaseGumball() {
        if(count > 0) {
            count = count - 1;
            System.out.println("Releasing the Gumball...Enjoy");
        }
    }

    @Override
    public String toString() {
        return "Mighty Gumball Inc.\n" +
                "Inventory: " + getCount() + "\nWaiting for quarter ";
    }
}
