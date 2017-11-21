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

        System.out.println("\nThe total is £" + receipt.calculateTotal());
    }
}
