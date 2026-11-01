package com.bits.leave;

import static org.junit.Assert.*;
import org.junit.Test;

public class LeaveCalculatorTest {

    @Test
    public void testLeaveBalance() {
        assertEquals(12, LeaveCalculator.calculateBalance(30, 18));
    }

    @Test
    public void testLeaveEncashment() {
        assertEquals(10000.0, LeaveCalculator.calculateEncashment(10, 30000), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakenExceedsEntitled() {
        LeaveCalculator.calculateBalance(10, 15);
    }
}
