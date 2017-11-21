package com.hf.hmrcshop;

import java.math.BigDecimal;

public enum ItemOffer {

    THREE_FOR_TWO,
    BUY_1_GET_1_FREE;

    BigDecimal calculateItemDiscount(ShopItem item, int count) {

        BigDecimal itemDiscount = new BigDecimal("0.00");

        switch (this) {
            case THREE_FOR_TWO:

                return itemDiscount.add(item.getPrice().multiply(
                  new BigDecimal(count/3)));


            case BUY_1_GET_1_FREE:

                return itemDiscount.add(item.getPrice().multiply(
                    new BigDecimal(count/2)));


            default:
                //TODO: throw new AssertionError("Unknown operations " + this);
                return itemDiscount;

        }
    }
}
