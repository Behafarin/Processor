package com.company.models;

public class DataPathDriver {
	private InstructionMem instructionMem;
	private ControlUnit controlUnit;
	private RegisterFile registerFile;
	private MainMemory mainMemory;
	private ALU alu;

	private String pc;
	private String nextPc;
	private String instruction;
	//decoded instruction
	private String oppCode;
	private String regAddr1;
	private String regAddr2;
	private String regWAddr;
	private String immValue;
	private String funcCode;
	private String jumpValue;
	//data that's shared between stages
	private String regReadData1;
	private String regReadData2;
	private String mainMemoryRead;
	private String extendedOffset;

	private String aluResult;

	public String executeLine(String pc) {
		this.pc = pc;
		stageIF();
		stageID();
		stageEXE();
		stageMEM();
		stageWB();
		return nextPc;
	}

	private void stageIF() {
		instruction = instructionMem.getInstruction(pc);
		nextPc = Adder.compute(pc, "00000000000000000000000000000001"); //pc + 1
	}

	private void stageID() {
		//decoding the instruction TODO: fix for miniature processor
		oppCode = instruction.substring(0, 5); // oppCode
		regAddr1 = instruction.substring(6, 10); // R-rt
		regAddr2 = instruction.substring(11, 15); // R-rs
		regWAddr = instruction.substring(16, 20); // R-rd
		funcCode = instruction.substring(26, 31); // R-func
		immValue = instruction.substring(11, 31); // I-immediate/offset
		jumpValue = instruction.substring(6, 31); // J-JumpOffset

		//setup control unit
		controlUnit.setup(oppCode);

		//setup register file
		String writeRegisterMux = Mux.compute(regAddr2, regWAddr, controlUnit.REGDES);                        //mux TODO: flag = REGDST
		registerFile.setup(regAddr1, regAddr2, writeRegisterMux, true);                     	 //TODO: flag = REGWRITE
		regReadData1 = registerFile.getFirstData();
		regReadData2 = registerFile.getSecondData();

		//extend the offset value
		extendedOffset = Extendor.singExtend(immValue);
	}

	private void stageEXE() {
		//ALU
		String aluInput2 = Mux.compute(regReadData1, extendedOffset,controlUnit.ALUSRC);                    //mux TODO: flag = ALUSRC
		aluResult = alu.compute(regReadData1, aluInput2,controlUnit.ALUOP);         //TODO: fix alu signal

		//calculate addresses
		String jumpAddr = nextPc.substring(0, 3) + Shifter.shift(jumpValue, 2);             //next pc when instruction is jump

		String shiftedImm = Shifter.shift(extendedOffset, 2);                               //shifter result
		String pcPlusOffset = Adder.compute(nextPc, shiftedImm);                                    //adder result
		boolean isBranchTaken = AndUnit.and(alu.getZeroSignal(), controlUnit.BRANCH);                             //and TODO: flag = BRANCH
		nextPc = Mux.compute(nextPc, pcPlusOffset,controlUnit.JUMP );                                  //mux TODO: flag =
		nextPc = Mux.compute(nextPc, jumpAddr, controlUnit.JUMP);                                          //mux TODO: flag = JUMP
	}

	private void stageMEM() {
		mainMemory.setup(aluResult, controlUnit.MEMREAD, controlUnit.MEMWRITE);                        //TODO: signals from control unit
		mainMemory.writeData(regReadData2);
		mainMemoryRead = mainMemory.readData();
	}

	private void stageWB() {
		String registerWriteData = Mux.compute(aluResult, mainMemoryRead, controlUnit.MEMTOREG);                //mux TODO: flag = MEMTOREG
		registerFile.write(registerWriteData);
	}
}
