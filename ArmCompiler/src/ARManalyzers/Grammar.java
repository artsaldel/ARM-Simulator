/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARManalyzers;

import Translator.*;

/**
 *
 * @author Arturo Salas
 */
public class Grammar {
    
    public static void main (String [] args) throws Exception {
        BinaryOutput.clearOutputFile();
        /*Object c = "#0x21";
        String shamt = Integer.toString(NumberTranslator.hexToInteger(c.toString().split("#0x")[1]));
        System.out.println(shamt);
        */
        parser instParser = new parser ();
        String [] archive = {"C:/Users/Arturo Salas/Desktop/Arquitectura de Computadores 1/Proyecto #1/ArmCompiler/src/ARManalyzers/entry.txt"}; 
        parser.main(archive);
        System.out.println("Ejecutado!");
        /*
        BranchTranslator.getBranchTranslator().insertLabel("Arturo1", 4);
        BranchTranslator.getBranchTranslator().insertLabel("Arturo2", 8);
        BranchTranslator.getBranchTranslator().insertLabel("Arturo3", 12);
        BranchTranslator.getBranchTranslator().insertLabel("Arturo4", 16);
        BranchTranslator.getBranchTranslator().insertLabel("Arturo5", 20);
        int x = BranchTranslator.getBranchTranslator().createImm24(16, 0);
        String bin = NumberTranslator.integerToBinary(x);
        System.out.println(bin);*/
    }
}
