package com.bits.leave;

public class App {
    public static void main(String[] args) {
        String env = System.getenv("APP_ENV") != null ? System.getenv("APP_ENV") : "default";
        System.out.println("Employee Leave Service started in " + env + " environment");
    }
}
