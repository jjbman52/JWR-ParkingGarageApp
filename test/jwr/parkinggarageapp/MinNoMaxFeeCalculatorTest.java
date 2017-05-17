/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwr.parkinggarageapp;

import jwrparkinggarageapp.MinNoMaxFeeCalculator;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author jordanrehbein
 */
public class MinNoMaxFeeCalculatorTest {
    private MinNoMaxFeeCalculator instance;
    
    public MinNoMaxFeeCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
    @Before
    public void setUp() {
        instance = new MinNoMaxFeeCalculator(20, 1, 2);
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of setMinFee method, of class MinMaxFeeCalculator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMinFeeShouldNotBeLessThanZero() {
        instance.setMinFee(-1);
    }
}
