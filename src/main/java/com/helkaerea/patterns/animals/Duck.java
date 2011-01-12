package com.helkaerea.patterns.animals;

import com.helkaerea.patterns.behaviours.FlyBehaviour;
import com.helkaerea.patterns.behaviours.QuackBehaviour;

public abstract class Duck {
    private static final String SWIM_ABSTRACT_MESSAGE = "Feels good to swim";
    private FlyBehaviour flyBehaviour;
    private QuackBehaviour quackBehaviour;
    private String duckName;
    
    /**
     * Default contructor
     */
    public Duck(String duckNameArg) {
       this.duckName = duckNameArg;
    }
    
    /**
     * a duck needs to quack
     */
    public abstract void performQuak();
    
    /**
     * a duck needs to fly
     */
    public abstract void performFly();
    
    /**
     * My name is ...
     */
    public abstract void display();
    
    /**
     * all ducks know how to swim
     */
    public void swim() {
        System.out.println(SWIM_ABSTRACT_MESSAGE);
    }
    
    public void setDuckName(String duckName) {
        this.duckName = duckName;
    }
    
    public String getDuckName() {
        return this.duckName;
    }
    
    /**
     * a duck must quack
     * 
     * @param quackBehaviour
     */
    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
    
    /**
     * a duck must know how it quacks
     * 
     * @return
     */
    public QuackBehaviour getQuackBehaviour() {
        return quackBehaviour;
    }
    
    /**
     * set a fly behaviour to a duck
     * 
     * @param fb
     */
    public void setFlyBehaviour(FlyBehaviour fb) {
        this.flyBehaviour = fb;
    }
    
    /**
     * get how a duck flyes
     */
    public FlyBehaviour getFlyBehaviour() {
        return this.flyBehaviour;
    }
}
