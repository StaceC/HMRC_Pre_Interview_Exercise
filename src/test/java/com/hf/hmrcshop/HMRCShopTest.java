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
}
