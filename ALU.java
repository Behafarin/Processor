package com.company.models;

public class ALU {
    private Signal zeroSignal;
    Signal ALUop;
    String result;
    String input1;
    String input2;
    public String compute (String val1, String val2, Signal ALUOP) {
        switch (ALUOP.data)
        {
            case 1:
                result = add(val1,val2);
                break;
            case 2:
                result = sub(val1,val2);
                break;
            case 3:
                result = slt(val1,val2);
                break;
            case 4:
                result = or(val1,val2);
                break;
            case 5:
                result = and(val1,val2);
                break;
        }
        return result;
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
    public static String slt(String Reg1, String Reg2)
    {
        boolean flag = false;
        char[] ans = new char[32];
        for(int i=0;i<32;i++)
        {
            ans[i] = 0;
        }
        int b1 = Integer.parseInt(Reg1, 2);
        int b2 = Integer.parseInt(Reg2, 2);
        if(b1 < b2)
        {
            ans[0]=1;
        }
        return String.copyValueOf(ans);
    }
    public Signal getZeroSignal() {
        return zeroSignal;
    }
}
