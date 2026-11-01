package com.bits.leave;

public class LeaveCalculator {

    // Remaining leave balance = entitled - taken
    public static int calculateBalance(int entitled, int taken) {
        if (entitled < 0 || taken < 0) {
            throw new IllegalArgumentException("Leave days cannot be negative");
        }
        if (taken > entitled) {
            throw new IllegalArgumentException("Taken leave exceeds entitlement");
        }
        return entitled - taken;
    }

    // Encashment = balance days x (monthly basic salary / 30)
    public static double calculateEncashment(int balanceDays, double monthlyBasic) {
        if (balanceDays < 0 || monthlyBasic < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        return balanceDays * (monthlyBasic / 30.0);
    }
}
