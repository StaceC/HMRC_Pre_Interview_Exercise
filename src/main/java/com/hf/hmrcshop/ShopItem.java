package com.hf.hmrcshop;

import java.math.BigDecimal;

/**
* Shop Item Model Object.
*
* <P>Various attributes that personify a ShopItem you can buy in the HMRC Shop.
*
* <P>Note that {@link BigDecimal} is used to model the price - not double or float.
* See {@link #ShopItem()} for more information.
*
* @author Stace C
* @version 0.1
*/
public class ShopItem {

    private String name;
    private String description;
    private BigDecimal price;

    /**
      * Constructor.
      *
      * <P> Returns a zero item TillReceipt with total and count
      * set to zero; and the created time set to now.
      */
    public ShopItem(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /** Return name passed into constructor. */
    public String getName() {
        return name;
    }

    /** Return description passed into constructor. */
    public String getDescription() {
        return description;
    }

    /** Return price passed into constructor. */
    public BigDecimal getPrice() {
        return price;
    }

}
