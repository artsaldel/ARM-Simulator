package Simulator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mario
 */
public class Analizador {
 
    private int numInst;
    
    public String[][] analizeText(String textFile, String[][] programa) throws FileNotFoundException, IOException{
    
        FileInputStream fstream = new FileInputStream(textFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        int index = 0;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            if (strLine.length()==17 && index < 256){
                programa[index][0] = strLine.substring(0, 8);
                programa[index][1] = strLine.substring(9);
                index += 1;
            }
            else{
                System.out.println ("El largo de las instrucciones es incorrecto");
                programa = null;
                break;
            }
        }
        
        numInst = index;
        //Close the input stream
        br.close();
        return programa;
    }
    
    public int getNumInst(){
        return numInst;
    }
}
