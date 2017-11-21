package com.hf.hmrcshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Set;

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

    private HashMap<ShopItem, Integer> itemsCount;
    private HashMap<ShopItem, ItemOffer> offers;


    /**
      * Constructor.
      *
      * <P> Returns a zero item TillReceipt with total
      * set to zero; and the created time set to now.
      */
    public TillReceipt() {

        this.created = LocalDate.now();
        this.items = new ArrayList<ShopItem>();

        this.itemsCount = new HashMap<ShopItem, Integer>();
        this.offers = new HashMap<ShopItem, ItemOffer>();

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

        int count = this.itemsCount.containsKey(newItem) ?
            this.itemsCount.get(newItem) : 0;
        this.itemsCount.put(newItem, count + 1);
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

    /**
     * Add an offer...probably belongs to the shop...
     *
     */
    public void addOffer(ShopItem item, ItemOffer offer ) {
        this.offers.put(item, offer);
    }

    /**
     * Calculate the total discounts from offers in the receipt.
     */
    public BigDecimal calculateDiscount() {

        BigDecimal discount = new BigDecimal("0.00");

        for (Entry<ShopItem, Integer> entry : itemsCount.entrySet())
        {
            if(offers.containsKey(entry.getKey())) {

              discount =
                discount.add(
                offers.get(
                entry.getKey()).calculateItemDiscount(
                entry.getKey(), entry.getValue()));
            }
        }
        return discount;
    }

}
