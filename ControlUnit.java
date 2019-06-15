package com.company.models;

public class ControlUnit {
    Signal REGDES;
    Signal REGWRITE;
    Signal ALUSRC;
    Signal BRANCH;
    Signal JUMP;
    Signal MEMTOREG;
    Signal MEMREAD;
    Signal ALUOP;
    Signal MEMWRITE;
    public void firstInitial()
    {
        REGDES.data = 0;
        REGWRITE.data = 0;
        ALUOP.data = 0;
        ALUSRC.data = 0;
        BRANCH.data = 0;
        JUMP.data = 0;
        MEMREAD.data = 0;
        MEMWRITE.data = 0;
        MEMTOREG.data = 0;
    }
    public void setup(String oppCode) {
        switch (oppCode)
        {
            case "0000":        //add
                ALUOP.data = 1;
                REGDES.data = 1;
                REGWRITE.data = 1;
                break;
            case "0001":        //sub
                ALUOP.data = 2;
                REGDES.data = 1;
                REGWRITE.data = 1;
                break;
            case "0010":        //slt
                ALUOP.data = 3;
                REGDES.data = 1;
                REGWRITE.data = 1;
                break;
            case "0011":        //or
                ALUOP.data = 4;
                REGDES.data = 1;
                REGWRITE.data = 1;
                break;
            case "0100":        //and
                ALUOP.data = 5;
                REGDES.data = 1;
                REGWRITE.data = 1;
                break;
            case "1001":        //lw
                ALUOP.data = 1; //add
                ALUSRC.data = 1;
                MEMTOREG.data = 1;
                MEMREAD.data = 1;
                REGWRITE.data = 1;
                break;
            case "1010":        //sw
                ALUOP.data = 1; //add
                ALUSRC.data = 1;
                MEMWRITE.data = 1;
                break;
            case "1011":        //beq
                ALUOP.data = 2; //SUB
                BRANCH.data = 1;
                break;
            case "1101":        //jump
                JUMP.data = 1;
                break;
        }
    }
}
