package com.hf.hmrcshop;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;


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
        BigDecimal expectedPrice = new BigDecimal("0.00");

        ShopItem apple = new ShopItem(expectedName, expectedPrice);
        assertEquals(expectedName, apple.getName());
        assertEquals(expectedPrice, apple.getPrice());
    }
}
