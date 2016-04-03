/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARManalyzers;

import Translator.*;
import proyecto1_arqui1_gui.mainWindow;

/**
 *
 * @author Arturo Salas
 */
public class Grammar {
    
    public static void main (String [] args) throws Exception {
        //String path = "C:/Users/artsa/Desktop/Arquitectura de Computadores 1/Proyecto #1/ArmCompiler/src/ARManalyzers/entry.txt";
        //ExecuteGrammar(path);
        new mainWindow().setVisible(true);
    }
    
    public static void ExecuteGrammar(String path) throws Exception {
        String [] archive = {path}; 
        parser.entryPath = path;
        parser.main(archive, false);
        System.out.println(ModuloError.getError());
    }
}
