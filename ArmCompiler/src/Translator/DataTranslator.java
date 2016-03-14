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
    private static String cond, op, cmd, S, Rn, Rd, Src2, rot, imm8, shamt5, sh, Rm, Rs;
    
    protected DataTranslator (){
        /*solo para ser instanciado una vez*/
    }
    
    public static DataTranslator getDataTranslator (){
        if (data == null){
            data = new DataTranslator();
            cond = op = cmd = S = Rn = Rd = Src2 =
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

    public String getSrc2() {
        return Src2;
    }

    public void setSrc2(String Src2) {
        this.Src2 = Src2;
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
    
    public String getInstruction (){
        return null;
    }
}
