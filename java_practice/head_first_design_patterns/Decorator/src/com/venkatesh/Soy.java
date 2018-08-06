package com.venkatesh;

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage b) {
        this.beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Soy ";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
