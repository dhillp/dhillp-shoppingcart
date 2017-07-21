/*
 * Pamaldeep Singh Dhillon
 * ShoppingCartTest.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 2 - ShoppingCart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import model.ItemOrder;
import model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for ShoppingCart class.
 * 
 * @author Pamaldeep Dhillon
 * @version 16 October 2015
 */
public class ShoppingCartTest {
    
    /** ShoppingCart that will be used for testing.*/
    private ShoppingCart myTestCart;

    /**
     * A method to initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myTestCart = new ShoppingCart();
        myTestCart.add(new ItemOrder(new Item("aItem", new BigDecimal("1.00")), 2));
    }

    /**
     * Tests add for when parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullItemOrder() {
        new ShoppingCart().add(null);
    }
    
    /**
     * Tests if add method removes equivalent ItemOrders and adds the new one.
     */
    @Test
    public void testAdd() {
        final ItemOrder tOrder = new ItemOrder(new Item("aItem", new BigDecimal("1.00")), 4);
        myTestCart.add(tOrder);
        assertEquals(new BigDecimal("4.00"), myTestCart.calculateTotal());
    }
    
    /**
     * Tests if add method doesn't remove ItemOrders if items are not equal.
     */
    @Test
    public void testAdd2() {
        final ItemOrder tOrder = new ItemOrder(new Item("bItem", new BigDecimal("0.50")), 2);
        myTestCart.add(tOrder);
        assertEquals(new BigDecimal("3.00"), myTestCart.calculateTotal());
    }

    /**
     * Test method for setMembership and calculateTotal of customer with membership.
     */
    @Test
    public void testSetMembershipTrue() {
        myTestCart.setMembership(true);
        assertEquals("Didn't set membership!", new BigDecimal("1.80"),
                     myTestCart.calculateTotal());
    }
    
    /**
     * Test method for setMembership and calculateTotal of customer without membership.
     */
    @Test
    public void testSetMembershipFalse() {
        myTestCart.setMembership(false);
        assertEquals("Didn't set membership!", new BigDecimal("2.00"),
                     myTestCart.calculateTotal());
    }

    /**
     * Test method for calculateTotal() when Item is a non-bulk item.
     */
    @Test
    public void testCalculateTotal() {
        assertEquals("Wrong total!", new BigDecimal("2.00"), myTestCart.calculateTotal());
    }
    
    /**
     * Test method for calculateTotal() when Item is a bulk item.
     */
    @Test
    public void testCalculateTotalBulkItem() {
        final Item tItem = new Item("b", new BigDecimal("0.50"), 2, new BigDecimal("0.75"));
        final ShoppingCart tCart = new ShoppingCart();
        tCart.add(new ItemOrder(tItem, 2));
        assertEquals("Wrong total!", new BigDecimal("0.75"), tCart.calculateTotal());
    }

    /**
     * Test method for {@link model.ShoppingCart#clear()}.
     */
    @Test
    public void testClear() {
        myTestCart.clear();
        assertTrue(myTestCart.calculateTotal().equals(new BigDecimal("0.00")));
    }

    /**
     * Test method for {@link model.ShoppingCart#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("ShoppingCart: [ItemOrder: aItem, $1.00; 2 for $2.00]"
                        + ", Total: $2.00", myTestCart.toString());
    }

}
