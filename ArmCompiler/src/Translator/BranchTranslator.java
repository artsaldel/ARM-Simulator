/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import ARManalyzers.ModuloError;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Arturo Salas
 */
public class BranchTranslator {
    private static BranchTranslator branch = null;
    private static String cond, op, L1, imm24;
    private static List<Map.Entry<String,Integer>> labelList;
    
    protected BranchTranslator (){
        /*solo para ser instanciado una vez*/
    }
    
    public static BranchTranslator getBranchTranslator(){
        if (branch == null){
            branch = new BranchTranslator();
            cond = op = L1 = imm24 = "";
            labelList = new ArrayList<>();
        }
        return branch;
    }

    public static String getCond() {
        return cond;
    }

    public static void setCond(String cond) {
        BranchTranslator.cond = cond;
    }

    public static String getOp() {
        return op;
    }

    public static void setOp(String op) {
        BranchTranslator.op = op;
    }

    public static String getL1() {
        return L1;
    }

    public static void setL1(String L1) {
        BranchTranslator.L1 = L1;
    }

    public static String getImm24() {
        return imm24;
    }

    public static void setImm24(String imm24) {
        BranchTranslator.imm24 = imm24;
    }
    
    public void insertLabel(String label, int PC){
        if (!alreadyExistLabel(label)){
            Map.Entry<String,Integer> pair = new AbstractMap.SimpleEntry<>(label,PC);
            labelList.add(pair);
        }
        else{
            System.out.println("Error la etiqueta " + label +" ya existe");
        }
    }
    
    public boolean alreadyExistLabel(String label){
        for (int i=0; i<labelList.size();i++){
            if (labelList.get(i).getKey() == null ? label == null : labelList.get(i).getKey().equals(label))
                return true;
        }
        return false;
    }
    
    public int getLabelPC(String label){
        for (int i=0; i<labelList.size();i++){
            if (labelList.get(i).getKey() == null ? label == null : labelList.get(i).getKey().equals(label))
                return labelList.get(i).getValue();
        }
        return 0;
    }
    
    public int createImm24(int actualPc, int labelPc){
        int pcPlus8 = actualPc + 8;
        return (labelPc - pcPlus8)/4;
    }
    
    private void make24bitsImm24(){
        String temp = "";
        int i = imm24.length()-1;
        while (i!=(imm24.length()-25)){
            temp = imm24.charAt(i) + temp;
            i --;
        }
        imm24 = temp;
    }
    
    public void writeInstruction (){
        try{
            if (Integer.parseInt(imm24) < 0){
                imm24 = NumberTranslator.integerToBinary(Integer.parseInt(getImm24()));
                if (imm24.length()<24)
                    while (imm24.length() != 24) { imm24 = "1" + imm24;} 
            }
            else if (Integer.parseInt(imm24) >= 0){
                imm24 = NumberTranslator.integerToBinary(Integer.parseInt(getImm24()));
                if (imm24.length()<24)
                    while (imm24.length() != 24) { imm24 = "0" + imm24;} 
            }
            make24bitsImm24();
            String instruction = getCond() + getOp() + getL1() + getImm24();
            instruction = NumberTranslator.binaryToHex(instruction);
            BinaryOutput.writeLine(instruction);
        }
        catch(Exception e){
            ModuloError.insertError("Error semántico, por favor verificar código.");
        }
    }
}
