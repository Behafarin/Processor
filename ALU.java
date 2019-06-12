package com.company;
import java.util.HashMap;
import java.util.Map;
public class ALU {
    Signal ALUop;
    String result;
    byte Zero;
    String input1;
    String input2;

    public void init(Signal ALUop,String input1 ,String input2) {
        this.ALUop = ALUop;
        this.input1 = input1;
        this.input2 = input2;
    }
    public static String add(String Reg1, String Reg2)
    {
        int b1 = Integer.parseInt(Reg1, 2);
        int b2 = Integer.parseInt(Reg2, 2);
        int sum = b1 + b2;
        return Integer.toBinaryString(sum);
    }
    public static String sub(String Reg1, String Reg2)
    {
        int b1 = Integer.parseInt(Reg1, 2);
        int b2 = Integer.parseInt(Reg2, 2);
        int sum = b1 - b2;
        return Integer.toBinaryString(sum);
    }
    public static String and(String Reg1, String Reg2)
    {
        int b1 = Integer.parseInt(Reg1, 2);
        int b2 = Integer.parseInt(Reg2, 2);
        int sum = b1 & b2;
        return Integer.toBinaryString(sum);
    }
    public static String or(String Reg1, String Reg2)
    {
        int b1 = Integer.parseInt(Reg1, 2);
        int b2 = Integer.parseInt(Reg2, 2);
        int sum = b1 | b2;
        return Integer.toBinaryString(sum);
    }
    public static boolean slt(String Reg1, String Reg2)
    {
        boolean flag = false;
        int b1 = Integer.parseInt(Reg1, 2);
        int b2 = Integer.parseInt(Reg2, 2);
        if(b1 < b2)
        {
            flag = true;
        }
        return flag;
    }
}
