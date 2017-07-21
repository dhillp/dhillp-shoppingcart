/*
 * Pamaldeep Singh Dhillon
 * Item.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 2 - ShoppingCart
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Item object that stores information about an individual item.
 * 
 * @author Pamaldeep Dhillon
 * @version 16 October 2015
 */
public final class Item {
    /** Name of the item.*/
    private final String myName;
    /** Price of the item.*/
    private final BigDecimal myPrice;
    /** Bulk quantity of the item.*/
    private int myBulkQuantity;
    /** Bulk price of the item.*/
    private BigDecimal myBulkPrice;
    
    /**
     * Constructs an Item using the provided name and price.
     * 
     * @param theName Name of the item.
     * @param thePrice Price of the item.
     * @throws IllegalArgumentException if price is negative or name is an empty string.
     * @throws NullPointerException if a parameter is null.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        if (thePrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Price must be a positive value!");
        }
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Name of item can't be an empty string!");
        }
        myName = (String) Objects.requireNonNull(theName);
        myPrice = (BigDecimal) Objects.requireNonNull(thePrice);
    }

    /**
     * Constructs an Item using the provided name, price, bulk quantity, and bulk price.
     * 
     * @param theName Name of the item.
     * @param thePrice Price of the item.
     * @param theBulkQuantity Bulk quantity of the item.
     * @param theBulkPrice Bulk price of the item.
     * @throws IllegalArgumentException if price/bulk price/bulk quantity are negative or if
     * name is an empty string.
     * @throws NullPointerException if price/name/bulk price parameters are null.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        if (thePrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Price must be positive!");
        }
        if (theBulkPrice.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Bulk price must be a positive value!");
        }
        if (theBulkQuantity < 0) {
            throw new IllegalArgumentException("Bulk quantity must be a positive value!");
        }
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Name of item can't be empty!");
        }
        myName = (String) Objects.requireNonNull(theName);
        myPrice = (BigDecimal) Objects.requireNonNull(thePrice);
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = (BigDecimal) Objects.requireNonNull(theBulkPrice);
    }

    /**
     * Returns the price as a BigDecimal for a given quantity of the item
     * (taking into account bulk price, if applicable).
     * 
     * @param theQuantity Quantity of the item.
     * @return Price for quantity of item.
     * @throws IllegalArgumentException if parameter is negative.
     */
    public BigDecimal calculateItemTotal(final int theQuantity) {
        if (theQuantity < 0) {
            throw new IllegalArgumentException("Quantity must be a positive value!");
        }
        BigDecimal totalPrice = new BigDecimal("0.00");
        BigDecimal tempPrice;
        int temp;
        int newQuantity = theQuantity;
        if (isBulk() && theQuantity >= myBulkQuantity) {
            temp = theQuantity / myBulkQuantity;
            totalPrice = myBulkPrice.multiply(new BigDecimal(temp));
            newQuantity = theQuantity - (myBulkQuantity * temp);
        }
        tempPrice = myPrice.multiply(new BigDecimal(newQuantity));
        totalPrice = totalPrice.add(tempPrice);
        return totalPrice.setScale(2, RoundingMode.HALF_EVEN);
    }
    
    /**
     * Returns True if the Item has bulk pricing; false otherwise.
     * 
     * @return bulk True if the Item has bulk pricing.
     */
    public boolean isBulk() {
        boolean bulk = false;
        if (myBulkPrice != null) {
            bulk = true;
        }
        return bulk;
    }

    /**
     * Returns a string representation of this Item.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(myName);
        sb.append(", $");
        sb.append(myPrice);
        if (isBulk()) {
            sb.append(" (");
            sb.append(myBulkQuantity);
            sb.append(" for $");
            sb.append(myBulkPrice);
            sb.append(')');
        }
        return sb.toString();
    }

    /**
     * Returns true if the specified object is equal to this Item; false otherwise.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOther) {
        boolean result = false;
        if ((theOther != null) && (theOther.getClass() == this.getClass())) {
            final Item otherItem = (Item) theOther;
            if (isBulk()) {
                result = myName.equals(otherItem.myName) && myPrice.equals(otherItem.myPrice)
                      && myBulkQuantity == otherItem.myBulkQuantity 
                      && myBulkPrice.equals(otherItem.myBulkPrice);
            } else {
                result = myName.equals(otherItem.myName) && myPrice.equals(otherItem.myPrice);
            }
        }
        return result;
    }

    /**
     * Returns an integer hash code for this item.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }

}
