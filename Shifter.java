package com.company.models;

public class Shifter {
    public static String shift (String value, int amount) {
        int b1 = Integer.parseInt(value , 2);
        b1 = b1 << amount;
        return Integer.toBinaryString(b1);
    }
}
