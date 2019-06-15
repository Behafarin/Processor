package com.company.models;

public class AndUnit {
    public static boolean and(Signal val1, Signal val2) {
        if(val2.data == 1 && val1.data == 1) return true;
        else return false;

    }
}
