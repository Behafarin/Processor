package com.company.models;

public class Extendor {
    public static String singExtend(String offset) {
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
}
