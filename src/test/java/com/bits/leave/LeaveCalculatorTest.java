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

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeEntitled() { LeaveCalculator.calculateBalance(-1, 0); }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeTaken() { LeaveCalculator.calculateBalance(10, -1); }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeBalanceDays() { LeaveCalculator.calculateEncashment(-1, 30000); }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSalary() { LeaveCalculator.calculateEncashment(5, -1); }

    @Test
    public void testZeroBalance() { assertEquals(0, LeaveCalculator.calculateBalance(10, 10)); }
}
