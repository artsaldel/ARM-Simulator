/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.Writer;


/**
 *
 * @author Arturo Salas
 */
public class BinaryOutput {
    
    private static File outputFile;
    
    public BinaryOutput (){;
        try{
            outputFile = new File("out.txt");
            outputFile.createNewFile();
        }
        catch (IOException e){
        }
    }
    
    public static void writeLine (String line){
        try(PrintWriter output = new PrintWriter(new FileWriter("out.txt",true))) 
        {
            output.printf("%s\r\n", line);
        } 
        catch (Exception e) {}
    }
    
    public static void clearOutputFile () throws IOException{
        try (FileWriter fwOb = new FileWriter("out.txt", false); 
             PrintWriter pwOb = new PrintWriter(fwOb, false)) {
            pwOb.flush();
        }
    }
}
