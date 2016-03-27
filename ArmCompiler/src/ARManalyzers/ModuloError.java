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
public class ModuloError {

    private static String error;
    
    public static String getError() {
        return error;
    }

    public static void insertError(String error) {
        ModuloError.error += "\n\n" + error;
    }
    
    public static void resetError() {
        ModuloError.error = "";
    }
}
