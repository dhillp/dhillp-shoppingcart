/*
 * Pamaldeep Singh Dhillon
 * ItemOrderTest.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 2 - ShoppingCart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the ItemOrder class.
 * 
 * @author Pamaldeep
 * @version 16 October 2015
 */
public class ItemOrderTest {
    
    /** Item order to be used in unit test.*/
    private ItemOrder myTestOrder;
    
    /** Item to be used in unit tests.*/
    private Item myTestItem;
    
    /**
     * A method to initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myTestItem = new Item("testItem", new BigDecimal("1.00"));
        myTestOrder = new ItemOrder(myTestItem, 5);
    }

    /**
     * Tests constructor for when quantity parameter is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegPrice() {
        new ItemOrder(myTestItem, -1);
    }
    
    /**
     * Tests constructor for when item parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullItem() {
        new ItemOrder(null, 1);
    }


    /**
     * Test method for {@link model.ItemOrder#calculateOrderTotal()}.
     */
    @Test
    public void testCalculateOrderTotal() {
        assertEquals("Calculated order total is wrong!", new BigDecimal("5.00"),
                        myTestOrder.calculateOrderTotal());
    }

    /**
     * Test method for {@link model.ItemOrder#getItem()}.
     */
    @Test
    public void testGetItem() {
        assertEquals(myTestItem, myTestOrder.getItem());
    }

    /**
     * Test method for {@link model.ItemOrder#getQuantity()}.
     */
    @Test
    public void testGetQuantity() {
        assertEquals(5, myTestOrder.getQuantity());
    }

    /**
     * Test method for {@link model.ItemOrder#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("ItemOrder: " + myTestItem + "; 5 for $5.00", myTestOrder.toString());
    }

}
