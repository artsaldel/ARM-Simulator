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
public class MultiplyTranslator {
    
    private static MultiplyTranslator multiply = null;
    private static String cond, op, cmd, S, Rd, Ra, Rm, Rn;
    
    protected MultiplyTranslator(){
        /*solo para ser instanciado una vez*/
    }
    
    public static MultiplyTranslator getMultiplyTranslator(){
        if (multiply == null){
            multiply = new MultiplyTranslator();
            cond = op = cmd = S = Rd = Ra = Rm = Rn = "";
        }
        return multiply;
    }

    public static String getCond() {
        return cond;
    }

    public static void setCond(String cond) {
        MultiplyTranslator.cond = cond;
    }

    public static String getOp() {
        return op;
    }

    public static void setOp(String op) {
        MultiplyTranslator.op = op;
    }

    public static String getCmd() {
        return cmd;
    }

    public static void setCmd(String cmd) {
        MultiplyTranslator.cmd = cmd;
    }

    public static String getS() {
        return S;
    }

    public static void setS(String S) {
        MultiplyTranslator.S = S;
    }

    public static String getRd() {
        return Rd;
    }

    public static void setRd(String Rd) {
        MultiplyTranslator.Rd = Rd;
    }

    public static String getRa() {
        return Ra;
    }

    public static void setRa(String Ra) {
        MultiplyTranslator.Ra = Ra;
    }

    public static String getRm() {
        return Rm;
    }

    public static void setRm(String Rm) {
        MultiplyTranslator.Rm = Rm;
    }

    public static String getRn() {
        return Rn;
    }

    public static void setRn(String Rn) {
        MultiplyTranslator.Rn = Rn;
    }
    
    public void writeInstruction (){
        Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
        Ra = NumberTranslator.integerToBinary(Integer.parseInt(getRa()));
        Rm = NumberTranslator.integerToBinary(Integer.parseInt(getRm()));
        Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
        
        while (Rd.length() != 4){Rd = "0" + Rd;}
        while (Ra.length() != 4){Ra = "0" + Ra;}
        while (Rm.length() != 4){Rm = "0" + Rm;}
        while (Rn.length() != 4){Rn = "0" + Rn;}
        
        String instruction = getCond() + getOp() + "00" + getCmd() + getS() + 
                             getRd() + getRa() + getRm() + "1001" + getRn();
        instruction = NumberTranslator.binaryToHex(instruction);
        BinaryOutput.writeLine(instruction);
    }    
}
