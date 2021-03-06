/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import java.math.BigInteger;

/**
 *
 * @author Arturo Salas
 */
public class NumberTranslator {
    
    public static String integerToBinary (int integer){
        return Integer.toBinaryString(integer);
    }
    
    public static String hexToBinary2 (String hex){
        hex = removeZerox(hex);
        int i = Integer.parseInt(hex, 16);
        String bin = Integer.toBinaryString(i);
        return bin;
    }
    
    public static String hexToBinary (String hex){
        hex = removeZerox(hex);
        BigInteger i = new BigInteger(hex, 16);
        String bin = i.toString(2);
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
    
    public static int hexToInteger (String number){
        return (int)Long.parseLong(number,16);
        
        //return Integer.parseInt(number, 16);  
    }
    
    public static int integerToHex (int number){
        return Integer.valueOf(String.valueOf(number), 16);
    }
    
    public static String binaryToHex(String number){
        String hex = Long.toHexString(Long.parseLong(number, 2));
        while (hex.length() != 8) { hex = "0" + hex; }
        return hex;
    }
    
    public static String integerToHexBytes (int number){
        String result = Integer.toHexString(number);
        while(result.length() < 8){result = "0" + result;}
        return result;
    }
}
