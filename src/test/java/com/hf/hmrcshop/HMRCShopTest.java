package com.hf.hmrcshop;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class HMRCShopTest
    extends TestCase
{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HMRCShopTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HMRCShopTest.class );
    }

    /**
     * Test ShopItem Model.
     */
    public void testCreateShopItems()
    {
        String expectedName = "Apple";
        String expectedDescription = "Red and juicy";
        BigDecimal expectedPrice = new BigDecimal("0.00");

        ShopItem apple = new ShopItem(expectedName, expectedDescription, expectedPrice);
        assertEquals(expectedName, apple.getName());
        assertEquals(expectedDescription, apple.getDescription());
        assertEquals(expectedPrice, apple.getPrice());
    }

    /**
     * Test that a new Till Receipt with no items has a total price of zero.
     */
    public void testEmptyTillReceipt()
    {
        BigDecimal expectedReceiptTotal = new BigDecimal("0.00");
        TillReceipt receipt = new TillReceipt();
        assertEquals(expectedReceiptTotal, receipt.calculateTotal());
    }

    /**
     * Test adding ShopItems to TillReceipt.
     */
    public void testAddingItems()
    {
      ArrayList<ShopItem> items = new ArrayList<ShopItem>();
      items.add(new ShopItem("Apple", "Red and juicy", new BigDecimal("0.15")));
      items.add(new ShopItem("Orange", "It's an orange orange", new BigDecimal("0.30")));

      TillReceipt receipt = new TillReceipt();
      receipt.addItems(items);
    }

    /**
     * Test getting the total price from a TillReceipt
     */
    public void testTotalPrice()
    {
        BigDecimal expectedFirstTotalPrice = new BigDecimal("0.45");
        BigDecimal expectedSecondTotalPrice = new BigDecimal("1.05");
        BigDecimal expectedThirdTotalPrice = new BigDecimal("1.35");

        ShopItem apple = new ShopItem("Apple", "Red and juicy", new BigDecimal("0.15"));
        ShopItem orange = new ShopItem("Orange", "It's an orange orange", new BigDecimal("0.30"));

        ArrayList<ShopItem> items = new ArrayList<ShopItem>();
        items.add(apple);
        items.add(orange);

        TillReceipt receipt = new TillReceipt();
        receipt.addItems(items);
        // Check price of an orange and apple, first total
        assertEquals(expectedFirstTotalPrice, receipt.calculateTotal());

        // Add two more oranges and check the total price
        receipt.addItem(orange);
        receipt.addItem(orange);
        assertEquals(expectedSecondTotalPrice, receipt.calculateTotal());

        // Add two more apples and check the total
        receipt.addItem(apple);
        receipt.addItem(apple);
        assertEquals(expectedThirdTotalPrice, receipt.calculateTotal());
    }

    /**
     * Test ItemOffer Enum
     */
    public void test_BUY_1_GET_1_FREE_Discount()
    {

        // One apple, no discounts
        assertEquals(new BigDecimal("0.00"),
            ItemOffer.BUY_1_GET_1_FREE.calculateItemDiscount(HMRCShopApp.APPLE, 1));
        // Two apples, one free
        assertEquals(new BigDecimal("0.60"),
            ItemOffer.BUY_1_GET_1_FREE.calculateItemDiscount(HMRCShopApp.APPLE, 2));
        // Three apples one free
        assertEquals(new BigDecimal("0.60"),
            ItemOffer.BUY_1_GET_1_FREE.calculateItemDiscount(HMRCShopApp.APPLE, 3));
        // Four apples two free
        assertEquals(new BigDecimal("1.20"),
            ItemOffer.BUY_1_GET_1_FREE.calculateItemDiscount(HMRCShopApp.APPLE, 4));
        // 1001 apples, 500 free
        assertEquals(new BigDecimal("300.00"),
            ItemOffer.BUY_1_GET_1_FREE.calculateItemDiscount(HMRCShopApp.APPLE, 1001));

    }

    /**
     *
     */
     public void test_THREE_FOR_TWO_DiscountOffer()
     {
        // One orange, no discount
        assertEquals(new BigDecimal("0.00"),
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 1));
        assertEquals(new BigDecimal("0.00"),
        // Two oranges, no discount
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 2));
        // Three oranges, one free
        assertEquals(new BigDecimal("0.25"),
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 3));
        //...
        // 276 Oranges, 92 free
        assertEquals(new BigDecimal("23.00"),
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 276));
        assertEquals(new BigDecimal("23.00"),
        // 277 Oranges, 92 free
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 277));
        // 278 Oranges, 92 free
        assertEquals(new BigDecimal("23.00"),
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 278));
        // 279 Oranges, 93 free
        assertEquals(new BigDecimal("23.25"),
            ItemOffer.THREE_FOR_TWO.calculateItemDiscount(HMRCShopApp.ORANGE, 279));
     }

}
