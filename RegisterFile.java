package com.company.models;

import java.util.HashMap;
import java.util.Map;

public class RegisterFile {
    private Map<String, String> registerMemory = new HashMap<>();

    private String readAddr1;
    private String readAddr2;
    private String writeAddr;
    private boolean regWrite;

    public RegisterFile() {
        registerMemory.put("0000", "00000000000000000000000000000000");
        registerMemory.put("0001", "00000000000000000000000000000000");
        registerMemory.put("0010", "00000000000000000000000000000000");
        registerMemory.put("0011", "00000000000000000000000000000000");
        registerMemory.put("0100", "00000000000000000000000000000000");
        registerMemory.put("0101", "00000000000000000000000000000000");
        registerMemory.put("0110", "00000000000000000000000000000000");
        registerMemory.put("0111", "00000000000000000000000000000000");
        registerMemory.put("1000", "00000000000000000000000000000000");
        registerMemory.put("1001", "00000000000000000000000000000000");
        registerMemory.put("1010", "00000000000000000000000000000000");
        registerMemory.put("1011", "00000000000000000000000000000000");
        registerMemory.put("1100", "00000000000000000000000000000000");
        registerMemory.put("1101", "00000000000000000000000000000000");
        registerMemory.put("1110", "00000000000000000000000000000000");
        registerMemory.put("1111", "00000000000000000000000000000000");
    }

    public void setup(String readAddr1, String readAddr2, String writeAddr, boolean flag) {
        this.readAddr1 = readAddr1;
        this.readAddr2 = readAddr2;
        this.writeAddr = writeAddr;
        regWrite = flag;
    }

    public String getFirstData() {
        return registerMemory.get(readAddr1);
    }

    public String getSecondData() {
        return registerMemory.get(readAddr2);
    }

    public void write(String registerWriteData) {
        if (regWrite && registerWriteData.length() == 32)
            registerMemory.replace(writeAddr, registerWriteData);
    }
}
