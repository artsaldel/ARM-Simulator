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
        String instruction;
    }
    
    public void writeInstructionRegister (){
        String instruction;
    }
}
