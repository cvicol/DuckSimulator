package com.helkaerea.patterns.animals;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.easymock.EasyMock.*;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.helkaerea.patterns.behaviours.FlyBehaviour;
import com.helkaerea.patterns.behaviours.QuackBehaviour;

/**
 * unittest for Mallardduck
 * @author cvicol
 *
 */
public class MallardDuckTest {
    private static final String TEST_NAME_DUCK = "testMallardDuck";    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    Duck testMallardDuck;
    
    @Before
    public void beforeAny() {
       testMallardDuck = new MallardDuck(TEST_NAME_DUCK);
       System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void shouldHaveANameWhenCreated() throws Exception {
        assertThat(testMallardDuck.getDuckName(), Matchers.is(TEST_NAME_DUCK));
    }
    
    @Test
    public void shouldCallFlyingBehaviourFlyWhenPerformingAFly() {
        FlyBehaviour fbMock = createMock(FlyBehaviour.class);
        
        fbMock.fly();
        expectLastCall().times(1);
        testMallardDuck.setFlyBehaviour(fbMock);
        
        replay(fbMock);        
        testMallardDuck.performFly();
        verify(fbMock); 
    }
    
    @Test
    public void shouldCallQuackBehaviourWhenPerformingAQuack() {
        QuackBehaviour quackBehaviourMock = createMock(QuackBehaviour.class);
        
        quackBehaviourMock.quack();
        expectLastCall().times(1);
        testMallardDuck.setQuackBehaviour(quackBehaviourMock);
        
        replay(quackBehaviourMock);
        testMallardDuck.performQuak();
        verify(quackBehaviourMock);
    }
    
    @Test
    public void shouldDisplayTheDuckNameWhenDisplayIsPerformed() {
        testMallardDuck.display();
        assertEquals("My name is " + TEST_NAME_DUCK, outContent.toString().replaceAll("\\n", ""));
    }
    @After
    public void afterAny() {
        testMallardDuck = null;
        System.setOut(null);
    }
    
}
