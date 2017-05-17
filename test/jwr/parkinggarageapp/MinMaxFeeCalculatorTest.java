/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwr.parkinggarageapp;

import jwrparkinggarageapp.MinMaxFeeCalculator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author jordanrehbein
 */
public class MinMaxFeeCalculatorTest {
    private MinMaxFeeCalculator instance;
    
    public MinMaxFeeCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
    @Before
    public void setUp() {
        instance = new MinMaxFeeCalculator(20, 1, 2);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of calculateFee method, of class MinMaxFeeCalculator.
     */
    @Test
    public void testCalculateFee() {
        double fee = 0;
        for(int i=0; i < 99; i++) {
            try {
                if(i < instance.getMax()){
                    fee = instance.getMinFee();
                } else {
                    fee = instance.getMinFee();
                }

            } catch(IllegalArgumentException iae) {
                fail("Arguments from 0 to max should be legal, "
                        + "but fails with IllegalArgumentException.");
            }
        }
    }
    
    /**
     * Test of setMax method, of class MinMaxFeeCalculator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMaxShouldNotBeLessThanZero() {
        instance.setMax(-1);
    }

    /**
     * Test of setMinFee method, of class MinMaxFeeCalculator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMinFeeShouldNotBeLessThanZero() {
        instance.setMinFee(-1);
    }

    /**
     * Test of setMaxFee method, of class MinMaxFeeCalculator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMaxFeeShouldNotBeLessThanOne() {
        instance.setMaxFee(0);
    }
}
