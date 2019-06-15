package com.company.models;

public class Adder {
    public static String compute(String val1, String val2){
    int b1 = Integer.parseInt(val1, 2);
    int b2 = Integer.parseInt(val2, 2);
    int sum = b1 + b2;
    return Integer.toBinaryString(sum);
    }
}
