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
public class NumberTranslator {
    
    public static String integerToBinary (int integer){
        return Integer.toBinaryString(integer);
    }
    
    public static String hexToBinary (String hex){
        hex = removeZerox(hex);
        int i = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(i);
        return bin;
    }
    
    public static int stringToInteger (String number){
        return Integer.parseInt(number);
    }
    
    public static String appendZerox (String number){
        return "0x" + number;
    }
    
    public static String removeZerox (String number) {
        String [] division = number.split("0x");
        return division[1];
    }
}
