package com.hf.hmrcshop;

import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * HMRC Shop
 *
 */
public class HMRCShopApp
{

    private static ArrayList<ShopItem> basket;

    public static final ShopItem APPLE =
        new ShopItem("Apple", "juicy apple", new BigDecimal("0.60"));
    public static final ShopItem ORANGE =
        new ShopItem("Orange", "orange orange", new BigDecimal("0.25"));

    public static void main( String[] args )
    {
        System.out.println( "\nHello Customer!\nApologies, your basket is hardcoded in the application currently.\n\n" );
        basket = new ArrayList<ShopItem>();

        basket.add(APPLE);
        basket.add(APPLE);
        basket.add(ORANGE);
        basket.add(APPLE);

        System.out.println("Your basket contains the following items:");

        for (ShopItem item: basket) {
            System.out.println("A " + item.getDescription());
        }

        TillReceipt receipt = new TillReceipt();
        receipt.addItems(basket);

        // Add offers
        receipt.addOffer(APPLE, ItemOffer.BUY_1_GET_1_FREE);
        receipt.addOffer(ORANGE, ItemOffer.THREE_FOR_TWO);

        System.out.println("\nTotal cost is:\n£" + receipt.calculateTotal());
        System.out.println("\nOffers value is:\n£" + receipt.calculateDiscount());
        System.out.println("\nTotal is:\n£" + receipt.calculateDiscountedTotal());

        System.out.println("\nHave a nice day :)\n\n");
    }
}
