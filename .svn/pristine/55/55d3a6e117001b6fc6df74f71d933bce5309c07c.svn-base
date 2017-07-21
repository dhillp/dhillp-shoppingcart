/*
 * Pamaldeep Singh Dhillon
 * ItemTest.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 2 - ShoppingCart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import model.Item;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the Item class.
 * 
 * @author Pamaldeep Dhillon
 * @version 16 October 2015
 */
public class ItemTest {
    /** An Item that has bulk pricing to be used in the tests.*/
    private Item myItem;
    /** An Item that doesn't have bulk pricing to be used in the tests.*/
    private Item myItem2;

    /**
     * A method to initialize the test fixture before each test.
     */
    @Before
    public void setUp() {
        myItem = new Item("Test", new BigDecimal("1.00"), 2, new BigDecimal("1.50"));
        myItem2 = new Item("Other", new BigDecimal("1.50"));
    }
    
    /**
     * Tests constructor for when price parameter is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegPrice() {
        new Item("NegPrice", new BigDecimal("-1.00"));
    }
    
    /**
     * Tests constructor for when name parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullName() {
        new Item(null, new BigDecimal("1.00"));
    }
    
    /**
     * Tests constructor for when price parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorNullPrice() {
        new Item("aName", null);
    }
    
    /**
     * Tests constructor for when name parameter is an empty string.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmptyString() {
        new Item("", new BigDecimal("1.00"));
    }
    
    /**
     * Tests bulk item constructor for when price parameter is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBulkConstructorNegPrice() {
        new Item("Neg", new BigDecimal("-1.00"), 2, new BigDecimal("1.00"));
    }
    
    /**
     * Tests bulk item constructor for when name parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBulkConstructorNullName() {
        new Item(null, new BigDecimal("1.00"), 2, new BigDecimal("1.50"));
    }
    
    /**
     * Tests bulk item constructor for when price parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBulkConstructorNullPrice() {
        new Item("bName", null, 2, new BigDecimal("1.00"));
    }
    
    /**
     * Tests bulk item constructor for when name parameter is empty string.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBulkConstructorEmptyString() {
        new Item("", new BigDecimal("1.00"), 2, new BigDecimal("1.50"));
    }
    
    /**
     * Tests bulk item constructor for when bulk price parameter is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBulkConstructorNegBulkPrice() {
        new Item("cName", new BigDecimal("1.00"), 2, new BigDecimal("-1.50"));
    }
    
    /**
     * Tests bulk item constructor for when bulk quantity parameter is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBulkConstructorNegQuantity() {
        new Item("dName", new BigDecimal("1.00"), -2, new BigDecimal("1.50"));
    }
    
    /**
     * Tests bulk item constructor for when bulk price parameter is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBulkConstructorNullBulkPrice() {
        new Item("bName", new BigDecimal("1.00"), 2, null);
    }
    
    /**
     * Test method for hashCode().
     */
    @Test
    public void testHashCode() {
        final Item item2 = new Item("Test", new BigDecimal("1.00"), 2, new BigDecimal("1.50"));
        final Item item3 = new Item("Other", new BigDecimal("1.50"));
        assertEquals("hashCode() fails to produce identical vaules!", myItem.hashCode(),
                     item2.hashCode());
        assertEquals("hashCode() fails to produce identical vaules!", myItem2.hashCode(),
                item3.hashCode());
    }

    /**
     * Test method for {@link model.Item#calculateItemTotal(int)}.
     */
    @Test
    public void testCalculateItemTotal() {
        //Bulk item with enough quantity for bulk price.
        assertEquals("Calculated total not right for bulk price!", new BigDecimal("4.00"),
                     myItem.calculateItemTotal(5));
        //Bulk item with not enough quantity for bulk price.
        assertEquals("Calculated total not right for bulk but not enough quantity!",
                     new BigDecimal("1.00"), myItem.calculateItemTotal(1));
        //Non-bulk item.
        assertEquals("Calculated total not right!", new BigDecimal("1.50"),
                     myItem2.calculateItemTotal(1));
    }
    
    /**
     * Test method for calculateItemTotal() when parameter is negative.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateItemTotalNegativeQuantity() {
        myItem.calculateItemTotal(-1);
    }

    /**
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulk() {
        //Bulk item.
        assertEquals(true, myItem.isBulk());
        //Non-bulk item.
        assertEquals(false, myItem2.isBulk());
    }

    /**
     * Test method for toString().
     */
    @Test
    public void testToString() {
        //Bulk item.
        assertEquals("toString() incorrect!", "Test, $1.00 (2 for $1.50)", myItem.toString());
        //Non-bulk item.
        assertEquals("toString() incorrect!", "Other, $1.50", myItem2.toString());
    }

    /**
     * Test method for equals().
     */
    @Test
    public void testEqualsObject() {
        //Bulk item is equal to itself.
        assertEquals("equals() fails a test of the reflexive property.", myItem, myItem);
        //Non bulk item is equal to itself.
        assertEquals("equals() fails a test of the reflexive property,", myItem2, myItem2);
        //Should return false if the parameter is null.
        assertNotEquals("equals() fails to return false when passed a null parameter",
                myItem, null);
        //Should return false if the parameter is a different type.
        assertNotEquals("equals() fails to return false when passed the wrong parameter type",
                myItem, new Object());
        //Bulk item.
        final Item item2 = new Item("Test", new BigDecimal("1.00"), 2, new BigDecimal("1.50"));
        assertEquals("equals() fails a test of the symmetric property.",
                myItem, item2);
        assertEquals("equals() fails a test of the symmetric property.",
                item2, myItem);
        //Non-bulk item.
        final Item item3 = new Item("Other", new BigDecimal("1.50"));
        assertEquals("equals() fails a test of the symmetric property.",
                myItem2, item3);
        assertEquals("equals() fails a test of the symmetric property.",
                item3, myItem2);
        //Bulk item.
        assertFalse("equals() fails to return false when item name does not match.",
                myItem.equals(new Item("Test2", new BigDecimal("1.00"), 2,
                                       new BigDecimal("1.50"))));
        //Non-bulk item.
        assertFalse("equals() fails to return false when item name does not match.",
                myItem2.equals(new Item("Other2", new BigDecimal("1.50"))));
        //Bulk item.
        assertFalse("equals() fails to return false when item price does not match.",
                myItem.equals(new Item("Test", new BigDecimal("2.00"), 2,
                                       new BigDecimal("1.50"))));
        //Non-bulk item.
        assertFalse("equals() fails to return false when item price does not match.",
                myItem2.equals(new Item("Other", new BigDecimal("1.00"))));
        //Bulk item.
        assertFalse("equals() fails to return false when bulk quantity does not match.",
                myItem.equals(new Item("Test", new BigDecimal("1.00"), 3,
                                       new BigDecimal("1.50"))));
        //Non-bulk item.
        assertFalse("equals() fails to return false when bulk price does not match.",
                myItem.equals(new Item("Test", new BigDecimal("1.00"), 2,
                                       new BigDecimal("1.75"))));
    }

}
