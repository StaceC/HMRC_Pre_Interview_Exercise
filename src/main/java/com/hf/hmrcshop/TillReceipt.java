package com.hf.hmrcshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
* Till Receipt Model Object.
*
* <P>Various attributes that personify a Till Receipt you would receive at checkout
*
* <P>Note that {@link BigDecimal} is used to model the price - not double or float.
* See {@link #TillReceipt()} for more information.
*
* @author Stace C
* @version 0.1
*/
public class TillReceipt {

    private static int DECIMALS = 2;
    private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;

    private LocalDate created;
    private ArrayList<ShopItem> items;

    /**
      * Constructor.
      *
      * <P> Returns a zero item TillReceipt with total
      * set to zero; and the created time set to now.
      */
    public TillReceipt() {

        this.created = LocalDate.now();
        this.items = new ArrayList<ShopItem>();

    }

    /**
     * Add items to the receipt.
     *
     * Convinience method that calls addItem for each item in the list.
     * See {@link #TillReceipt.addItem(ShopItem)}
     *
     * @param newItems (required) new ShopItems to add to the receipt.
     */
    public void addItems(ArrayList<ShopItem> newItems) {

        for (ShopItem item: newItems) {
            this.addItem(item);
        }
    }

    /**
     * Add a new item to the receipt.
     *
     * @param newItem (required) new ShopItem to add to the receipt.
     */
    public void addItem(ShopItem newItem) {
        this.items.add(newItem);
    }

    /**
     * Calculate total cost of items on receipt
     *
     * @return <tt>BigDecimal</tt> total price of all items in basket.
     */
    public BigDecimal calculateTotal() {

        BigDecimal receiptTotal = new BigDecimal("0.00");

        for (ShopItem item: items) {
            receiptTotal = receiptTotal.add(item.getPrice());
        }

        return receiptTotal.setScale(DECIMALS, ROUNDING_MODE);
    }
}
