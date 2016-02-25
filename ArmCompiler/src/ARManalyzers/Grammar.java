/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARManalyzers;

/**
 *
 * @author Arturo Salas
 */
public class Grammar {
    
    public static void main (String [] args) throws Exception {
        parser instParser = new parser ();
        String [] archive = {"C:/Users/Arturo Salas/Desktop/Arquitectura de Computadores 1/Proyecto #1/ArmCompiler/src/ARManalyzers/entry.txt"}; //"C:/Users/Arturo Salas/Desktop/Arquitectura de Computadores 1/Proyecto #1/ArmCompiler/src/ARManalyzers/"
        parser.main(archive);
        System.out.println("Ejecutado!");
    }
}
