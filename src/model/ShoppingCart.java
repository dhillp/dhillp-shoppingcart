/*
 * Pamaldeep Singh Dhillon
 * ShoppingCart.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * ShoppingCart object stores information about the customer's overall purchase.
 * 
 * @author Pamaldeep Dhillon
 * @version 16 October 2015
 */
public class ShoppingCart {
    /** List of ItemOrders.*/
    private final List<ItemOrder> myList;
    /** Boolean representing whether or not customer has membership.*/
    private boolean myMembership;
    
    /**
     * Constructor that creates an empty shopping cart.
     */
    public ShoppingCart() {
        myList = new ArrayList<ItemOrder>();
        myMembership = false;
    }

    /**
     * Adds an order to the shopping cart, replacing any previous order for an
     * equivalent item with the new order.
     * 
     * @param theOrder Item order to be added to the ShoppingCart.
     * @throws NullPointerException if ItemOrder parameter is null.
     */
    public void add(final ItemOrder theOrder) {
        final Iterator<ItemOrder> itr = myList.iterator();
        while (itr.hasNext()) {
            if (itr.next().getItem().equals(theOrder.getItem())) {
                itr.remove();
            }
        }
        myList.add((ItemOrder) Objects.requireNonNull(theOrder));
    }

    /**
     * Sets whether of not the customer for this shopping cart has a store membership.
     * 
     * @param theMembership True if customer has discount membership; false otherwise.
     */
    public void setMembership(final boolean theMembership) {
        if (theMembership) {
            myMembership = true;
        } else {
            myMembership = false;
        }
    }

    /**
     * Returns the total cost of this shopping cart as a BigDecimal.
     * 
     * @return Total cost of items in ShoppingCart.
     */
    public BigDecimal calculateTotal() {
        BigDecimal result = new BigDecimal("0.00");
        BigDecimal discount;
        for (final ItemOrder i : myList) {
            if (i.getItem().isBulk()) {
                result = result.add(i.calculateOrderTotal());
            } else if (myMembership) {
                discount = i.calculateOrderTotal().multiply(new BigDecimal("0.10"));
                result = result.add(i.calculateOrderTotal().subtract(discount));
            } else {
                result = result.add(i.calculateOrderTotal());
            }
        }
        return result.setScale(2, RoundingMode.HALF_EVEN);
    }
    
    /**
     * Removes all orders from the cart.
     */
    public void clear() {
        myList.clear();
    }
    
    /**
     * Returns a String representation of this ShoppingCart.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": ");
        sb.append(myList);
        sb.append(", Total: $");
        sb.append(calculateTotal());
        return sb.toString();
    }

}
