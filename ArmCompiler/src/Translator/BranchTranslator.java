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
public class BranchTranslator {
    private static BranchTranslator branch = null;
    private static String cond, op, L1, imm24;
    
    protected BranchTranslator (){
        /*solo para ser instanciado una vez*/
    }
    
    public static BranchTranslator getBranchTranslator(){
        if (branch == null){
            branch = new BranchTranslator();
            cond = op = L1 = imm24 = "";
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
    
    public void getInstruction (){
        
    }
}
