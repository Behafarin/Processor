package com.company;

public class Controller {
    String Opcode;
    Signal RegDst;
    Signal Jump;
    Signal Branch;
    Signal MemRead;
    Signal MemtoReg;
    Signal MemWrite;
    Signal ALUSrc;
    Signal RegWrite;
    Signal ALUadd;
    Signal ALUsub;
    Signal ALUand;
    Signal ALUor;
    Signal ALUslt;
    public Controller(String Opcode)
    {
        this.Opcode = Opcode;
    }
    public void SignalInitial(String Opcode)
    {
        switch (Opcode)
        {
            case "000000":
                ALUadd.data = 1;
                break;
            case "000001":
                ALUand.data = 1;
                break;
            case "000010":
                ALUor.data = 1;
                break;
            case "000011":
                ALUslt.data = 1;
                break;
            case "000100":
                ALUsub.data = 1;
                break;
            case "000101":
                ALUSrc.data = 1;
        }
    }
}
