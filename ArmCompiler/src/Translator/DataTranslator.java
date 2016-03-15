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
    
    public void writeInstructionImmediate(){
        Rn = NumberTranslator.integerToBinary(Integer.parseInt(getRn()));
        Rd = NumberTranslator.integerToBinary(Integer.parseInt(getRd()));
        imm8 = NumberTranslator.integerToBinary(Integer.parseInt(getImm8()));
        while (Rn.length() != 4){Rn = "0" + Rn;}
        while (Rd.length() != 4){Rd = "0" + Rd;}
        while (imm8.length() != 8){imm8 = "0" + imm8;}
        while (rot.length() != 4){rot = "0" + rot;}
        String instruction = getCond() + getOp() + getI() + getCmd() + getS() +
                             Rn + Rd + getRot() + imm8; 
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
        
        String instruction = getCond() + getOp() + getI() + getCmd() + getS() +
                             getRn() + getRd() + getShamt5() + getSh() + "0" + getRm(); 
        BinaryOutput.writeLine(instruction);
    }
    
    public void writeInstructionRegisterShifted(){
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
        BinaryOutput.writeLine(instruction);
    }
}
