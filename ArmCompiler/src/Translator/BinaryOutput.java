/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Arturo Salas
 */
public class BinaryOutput {
    
    private static File outputFile;
      
    public static void CreateFile(){
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
    
    public static void write (String line){
        try(PrintWriter output = new PrintWriter(new FileWriter("out.txt",true))) 
        {
            output.printf("%s\t", line);
        } 
        catch (Exception e) {}
    }
    
    public static void DestroyFile() throws IOException{
        try{
            outputFile = new File("out.txt");
            outputFile.delete();
        }
        catch (Exception e){}
    }
}
