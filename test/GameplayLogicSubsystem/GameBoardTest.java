/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameplayLogicSubsystem;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jon
 */
public class GameBoardTest {
    
    public GameBoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDeathMatch method, of class GameBoard.
     */
    @Test
    public void testSetDeathMatch() {
        System.out.println("setDeathMatch");
        boolean val = false;
        GameBoard instance = new GameBoard();
        instance.setDeathMatch(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class GameBoard.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        GameBoard instance = new GameBoard();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class GameBoard.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int index = 0;
        GameBoard instance = new GameBoard();
        boolean expResult = false;
        boolean result = instance.move(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shift method, of class GameBoard.
     */
    @Test
    public void testShift() {
        System.out.println("shift");
        GameBoard instance = new GameBoard();
        instance.shift();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGameOver method, of class GameBoard.
     */
    @Test
    public void testIsGameOver() {
        System.out.println("isGameOver");
        GameBoard instance = new GameBoard();
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class GameBoard.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        GameBoard instance = new GameBoard();
        GameBoard.State[][] expResult = null;
        GameBoard.State[][] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTurn method, of class GameBoard.
     */
    @Test
    public void testGetTurn() {
        System.out.println("getTurn");
        GameBoard instance = new GameBoard();
        GameBoard.State expResult = null;
        GameBoard.State result = instance.getTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWinner method, of class GameBoard.
     */
    @Test
    public void testGetWinner() {
        System.out.println("getWinner");
        GameBoard instance = new GameBoard();
        GameBoard.State expResult = null;
        GameBoard.State result = instance.getWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableMoves method, of class GameBoard.
     */
    @Test
    public void testGetAvailableMoves() {
        System.out.println("getAvailableMoves");
        GameBoard instance = new GameBoard();
        HashSet<Integer> expResult = null;
        HashSet<Integer> result = instance.getAvailableMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeepCopy method, of class GameBoard.
     */
    @Test
    public void testGetDeepCopy() {
        System.out.println("getDeepCopy");
        GameBoard instance = new GameBoard();
        GameBoard expResult = null;
        GameBoard result = instance.getDeepCopy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GameBoard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameBoard instance = new GameBoard();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
