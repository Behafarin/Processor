package com.company.models;

import java.util.*;

public class InstructionMem {
    final static int bits = 16;
    private Map<String, String> instructionMemory = new HashMap<>();

    public String getInstruction(String pc) {
        return instructionMemory.get(pc);
    }

    public void load(String codeText) {
        Scanner scanner = new Scanner(codeText);
        List<String> instructions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            instructions.add(scanner.nextLine());
        }
        for (int i = 0; i < instructions.size(); i++) {
            String key = String.format("%" + bits + "s", Integer.toBinaryString(i)).replace(' ', '0');
            instructionMemory.put(key, instructions.get(i));
        }
        scanner.close();
    }
}
