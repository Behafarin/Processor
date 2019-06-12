package com.company;

import java.util.HashMap;
import java.util.Map;

public class RegisterFile {
    Map<String, String> regMem = new HashMap<>();
    String readAddr1, readAddr2, writeAddr,writeData,readdata1,readdata2;

//    public RegisterFile() {
//        for (int i = 0; i < 16; i++)
//
//    }

    public void init (String readAddr1, String readAddr2, String writeAddr){
        this.readAddr1 = readAddr1;
        this.readAddr2 = readAddr2;
        this.writeAddr = writeAddr;
    }

    public String getDate1 (){
        return regMem.get(readAddr1);
    }

    public String getDate2 (){
        return regMem.get(readAddr2);
    }

    public void  setDate (String date){
        regMem.replace(writeAddr, writeData);
    }
}
