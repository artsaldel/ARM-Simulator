/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import ARManalyzers.ModuloError;
import ARManalyzers.parser;
import java.util.Arrays;

/**
 *
 * @author Arturo Salas
 */
public class DataTranslator {
    
    private static DataTranslator data = null;
    private static String cond, op, I, cmd, S, Rn, Rd, rot, imm8, shamt5, sh, Rm, Rs;
    
    protected DataTranslator (){
        /*solo para ser instanciado una vez*/
    }
    
    public static DataTranslator getDataTranslator (){
        if (data == null){
            data = new DataTranslator();
            cond = op = cmd = S = Rn = Rd =
            rot = imm8 = shamt5 = sh = Rm = Rs = "";
        }
        return data;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
    
    public String getI() {
        return I;
    }

    public void setI(String I) {
        this.I = I;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }

    public String getRn() {
        return Rn;
    }

    public void setRn(String Rn) {
        this.Rn = Rn;
    }

    public String getRd() {
        return Rd;
    }

    public void setRd(String Rd) {
        this.Rd = Rd;
    }
    
    public static String getRot() {
        return rot;
    }

    public static void setRot(String rot) {
        DataTranslator.rot = rot;
    }

    public static String getImm8() {
        return imm8;
    }

    public static void setImm8(String imm8) {
        DataTranslator.imm8 = imm8;
    }

    public static String getShamt5() {
        return shamt5;
    }

    public static void setShamt5(String shamt5) {
        DataTranslator.shamt5 = shamt5;
    }

    public static String getSh() {
        return sh;
    }

    public static void setSh(String sh) {
        DataTranslator.sh = sh;
    }

    public static String getRm() {
        return Rm;
    }

    public static void setRm(String Rm) {
        DataTranslator.Rm = Rm;
    }

    public static String getRs() {
        return Rs;
    }

    public static void setRs(String Rs) {
        DataTranslator.Rs = Rs;
    }
    
    private void createRot (){
        //el inmediato ingresa como un numero binario
        if (imm8.length() <= 8){
            while (imm8.length() != 8){imm8 = "0" + imm8;}
            rot = "0000";
        }
        else{
            String tempImm8 = "";
            String originalImm8 = imm8;
            while (originalImm8.length() != 32){originalImm8 = "0" + originalImm8;}
            int bits8Ctdr = 0;
            for (int ctdr = 0; ctdr < imm8.length() && bits8Ctdr < 8; ctdr++){
                if (imm8.charAt(ctdr) == '1'){
                    tempImm8 = tempImm8 + imm8.charAt(ctdr);
                    bits8Ctdr++;
                }
            }
            imm8 = tempImm8;
            String bits32 = "000000000000000000000000" + imm8;
            String[] array1 = bits32.split("");
            String[] array2 = originalImm8.split("");
            int shift = circularShift(array1, array2);
            rot = NumberTranslator.integerToBinary(shift/2);
            while (rot.length() != 4) {rot = "0" + rot;}
        }
    }
    
    private int circularShift(String[] array, String[] original) {  
         String[] tempArray = new String[32];
         int shift = 0;
         for (int i = 0; !Arrays.equals(tempArray, original) && i<32; i++){
             tempArray[0] = array[31];
             for (int j = 1; j<32; j++){
                 tempArray[j] = array[j-1];
             }
             System.arraycopy( tempArray, 0, array, 0, tempArray.length );
             shift++;
         }
         return shift;
    }  
    
    public void writeInstructionImmediate(){
        try{
            Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
            Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
            imm8 = NumberTranslator.integerToBinary(Integer.parseInt(getImm8()));
            while (Rn.length() != 4){Rn = "0" + Rn;}
            while (Rd.length() != 4){Rd = "0" + Rd;}
            //Primero se crea el rot, luego se edita el imm8, respetar ese orden
            createRot ();
            String instruction = getCond() + getOp() + getI() + getCmd() + getS() +
                                 Rn + Rd + getRot() + imm8; 
            instruction = NumberTranslator.binaryToHex(instruction);
            BinaryOutput.write(NumberTranslator.integerToHexBytes(parser.PC));
            BinaryOutput.writeLine(instruction);
        }
        catch(Exception e){
            ModuloError.insertError("Error semántico, por favor verificar código.");
        }
    }
    
    public void writeInstructionRegister (){
        try{
            Exception e = new Exception("Este es mi propio error.");
            Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
            Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
            Rm = NumberTranslator.integerToBinary(Integer.parseInt(getRm()));
            shamt5 = NumberTranslator.integerToBinary(Integer.parseInt(getShamt5()));
            if (shamt5.length() > 5){
                ModuloError.insertError("Error: No funciona un shamt5 ingresado.");
                parser.isError = true;
                throw e;
            }
            while (Rn.length() != 4){Rn = "0" + Rn;}
            while (Rd.length() != 4){Rd = "0" + Rd;}
            while (Rm.length() != 4){Rm = "0" + Rm;}
            while (shamt5.length() < 5){ shamt5 = "0" + shamt5;}
            String instruction = getCond() + getOp() + getI() + getCmd() + getS() +
                                 getRn() + getRd() + getShamt5() + getSh() + "0" + getRm(); 
            instruction = NumberTranslator.binaryToHex(instruction);
            BinaryOutput.write(NumberTranslator.integerToHexBytes(parser.PC));
            BinaryOutput.writeLine(instruction);
        }
        catch(Exception e){
            ModuloError.insertError("Error semántico, por favor verificar código.");
        }
    }
    
    public void writeInstructionRegisterShifted(){
        try{
            Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
            Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
            Rm = NumberTranslator.integerToBinary(Integer.parseInt(getRm()));
            Rs = NumberTranslator.integerToBinary(Integer.parseInt(getRs()));

            while (Rn.length() != 4){Rn = "0" + Rn;}
            while (Rd.length() != 4){Rd = "0" + Rd;}
            while (Rm.length() != 4){Rm = "0" + Rm;}
            while (Rs.length() != 4){Rs = "0" + Rs;}

            String instruction = getCond() + getOp() + getI() + getCmd() + getS() +
                                 getRn() + getRd() + getRs() + "0" + getSh() + "1" + getRm(); 
            instruction = NumberTranslator.binaryToHex(instruction);
            BinaryOutput.write(NumberTranslator.integerToHexBytes(parser.PC));
            BinaryOutput.writeLine(instruction);
        }
        catch(Exception e){
            ModuloError.insertError("Error semántico, por favor verificar código.");
        }
    }
}
