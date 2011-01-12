package com.helkaerea.patterns.animals;
/**
 * Mllard duck looks funny
 * @author cvicol
 *
 */
public class MallardDuck extends Duck {
   
    public MallardDuck(String nameOfDuck) {
        super(nameOfDuck);
    }
    @Override
    public void performQuak() {
        this.getQuackBehaviour().quack();
    }
    
    @Override
    public void performFly() {
        this.getFlyBehaviour().fly();
    }
    
    @Override
    public void display() {
       System.out.println("My name is " + this.getDuckName());
    }
    
}
