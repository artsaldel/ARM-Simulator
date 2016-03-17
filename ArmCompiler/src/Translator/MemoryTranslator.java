/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

/**
 *
 * @author Arturo Salas
 */
public class MemoryTranslator {
    
    private static MemoryTranslator memory = null;
    private static String cond, op, negI, P, U, B, W, L, Rn, Rd, imm12, shamt5, sh, Rm;
    
    protected MemoryTranslator (){
        /*solo para ser instanciado una vez*/
    }
    
    public static MemoryTranslator getMemoryTranslator (){
        if (memory == null){
            memory = new MemoryTranslator();
            cond = op = negI = P = U = B = W = L = Rn = Rd =
            imm12 = shamt5 = sh = Rm = "";
        }
        return memory;
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

    public String getNegI() {
        return negI;
    }

    public void setNegI(String negI) {
        this.negI = negI;
    }

    public String getP() {
        return P;
    }

    public void setP(String P) {
        this.P = P;
    }

    public String getU() {
        return U;
    }

    public void setU(String U) {
        this.U = U;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getW() {
        return W;
    }

    public void setW(String W) {
        this.W = W;
    }

    public String getL() {
        return L;
    }

    public void setL(String L) {
        this.L = L;
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
    
    public static String getImm12() {
        return imm12;
    }

    public static void setImm12(String imm12) {
        MemoryTranslator.imm12 = imm12;
    }

    public static String getShamt5() {
        return shamt5;
    }

    public static void setShamt5(String shamt5) {
        MemoryTranslator.shamt5 = shamt5;
    }

    public static String getSh() {
        return sh;
    }

    public static void setSh(String sh) {
        MemoryTranslator.sh = sh;
    }

    public static String getRm() {
        return Rm;
    }

    public static void setRm(String Rm) {
        MemoryTranslator.Rm = Rm;
    }
    
    public void writeInstructionImmediate (){
        Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
        Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
        imm12 = NumberTranslator.integerToBinary(Integer.parseInt(getImm12()));
        
        while (Rn.length() != 4){Rn = "0" + Rn;}
        while (Rd.length() != 4){Rd = "0" + Rd;}
        while (imm12.length() != 12){imm12 = "0" + imm12;}
        
        String instruction = getCond() + getOp() + getNegI() + getP() + getU() + 
                             getB() + getW() + getL() + getRn() + getRd() + getImm12();
        instruction = NumberTranslator.binaryToHex(instruction);
        BinaryOutput.writeLine(instruction);
    }
    
    public void writeInstructionRegister (){
        Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
        Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
        Rm = NumberTranslator.integerToBinary(Integer.parseInt(getRm()));
        shamt5 = NumberTranslator.integerToBinary(Integer.parseInt(getShamt5()));
        
        while (Rn.length() != 4){Rn = "0" + Rn;}
        while (Rd.length() != 4){Rd = "0" + Rd;}
        while (Rm.length() != 4){Rm = "0" + Rm;}
        while (shamt5.length() != 5){shamt5 = "0" + shamt5;}
        
        String instruction = getCond() + getOp() + getNegI() + getP() + getU() + 
                             getB() + getW() + getL() + getRn() + getRd() + 
                             getShamt5() + getSh() + "1" + getRm();
        instruction = NumberTranslator.binaryToHex(instruction);
        BinaryOutput.writeLine(instruction);
    }
}
