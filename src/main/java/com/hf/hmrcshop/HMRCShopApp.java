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

    public static void main( String[] args )
    {
        System.out.println( "\nHello Customer!\nApologies, your basket is hardcoded in the application currently.\n\n" );
        basket = new ArrayList<ShopItem>();

        basket.add(new ShopItem("Apple", "juicy apple", new BigDecimal("0.30")));
        basket.add(new ShopItem("Pear", "ripe pear", new BigDecimal("0.35")));
        basket.add(new ShopItem("Orange", "orange orange", new BigDecimal("0.50")));

        System.out.println("Your basket contains the following items:");

        for (ShopItem item: basket) {
            System.out.println("A " + item.getDescription());
        }

        TillReceipt receipt = new TillReceipt();
        receipt.addItems(basket);

        System.out.println("\nThe total is £" + receipt.calculateTotal());
    }
}
