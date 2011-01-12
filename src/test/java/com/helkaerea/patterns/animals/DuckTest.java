package com.helkaerea.patterns.animals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.helkaerea.patterns.animals.Duck;
import com.helkaerea.patterns.behaviours.FlyBehaviour;
import com.helkaerea.patterns.behaviours.QuackBehaviour;

/**
 * Unit test for Duck Class.
 */
public class DuckTest {

    private static final String TEST_DUCK_NAME = "testDuck";
    private static final String DUCK_NAME_AFTER_DIVORCE = "testDivorcedDuck";
    private static final String SWIM_ABSTRACT_MESSAGE = "Feels good to swim";
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    private IMockBuilder<Duck> duckMock = EasyMock.createMockBuilder(Duck.class).withConstructor(TEST_DUCK_NAME);
    private FlyBehaviour fbTestMock = EasyMock.createMock(FlyBehaviour.class);
    private QuackBehaviour qbMock = EasyMock.createMock(QuackBehaviour.class); 
    private Duck testDuck;
    
    @Before
    public void beforeAny() {
        testDuck = duckMock.createMock();
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldReturnADuckWithANameWhenCreatingANewDuck() {
        assertThat(testDuck.getDuckName(), is(TEST_DUCK_NAME));        
    }
    
    @Test
    public void shouldSetAFlyBehaviour() {
        testDuck.setFlyBehaviour(fbTestMock);
        assertThat(testDuck.getFlyBehaviour(), is(fbTestMock));        
    }
    
    @Test
    public void shouldSetAQuackBehaviour() {
        testDuck.setQuackBehaviour(qbMock);
        assertThat(testDuck.getQuackBehaviour(), is(qbMock));
    } 
    
    @Test
    public void shouldSetADuckName() {
        testDuck.setDuckName(DUCK_NAME_AFTER_DIVORCE);
        assertThat(testDuck.getDuckName(), is(DUCK_NAME_AFTER_DIVORCE));
    }
    
    @Test
    public void shouldPrintAMessageIfSwimIsCalled(){
        testDuck.swim();
        assertNotNull(outContent);
        assertEquals(SWIM_ABSTRACT_MESSAGE, outContent.toString().replaceAll("\\n", ""));
    }
    @After
    public void afterEach(){
        testDuck = null;
        System.setOut(null);
    }
}
