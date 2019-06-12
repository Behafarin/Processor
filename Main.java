package com.company;

public class Main {

    public static String MUX32(String Reg1, String Reg2, Signal control)
    {
        if(control.data==0) return Reg1;
        else return Reg2;
    }
    public static String MUX5(String Reg1, String Reg2, Signal control)
    {
        if(control.data==0) return Reg1;
        else return Reg2;
    }
    public static String ShiftLeft2(String address)
    {
        int b1 = Integer.parseInt(address , 2);
        b1 = b1 << 2;
        return Integer.toBinaryString(b1);
    }
    public static String SignExtand(String offset)
    {
        char[] address = new char[32];
        address = offset.toCharArray();
        if(address[15] == 0)
        {
            for(int i=16;i<32;i++)
            {
                address[i]=0;
            }
        }
        else
        {
            for(int i=16;i<32;i++)
            {
                address[i]=1;
            }
        }
        offset = String.copyValueOf(address);
        return offset;
    }
    public static void main(String[] args) {
    }
}
