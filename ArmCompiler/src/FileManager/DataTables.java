package FileManager;

import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author Daniel
 */
public class DataTables {
    private Object[][] tablaInstrucciones;
    private Object[][] tablaDatos;
            
    public DataTables()
    {
        this.tablaDatos = new Object[256][2];
        this.tablaInstrucciones = new Object[256][2];
    }

    public Object[][] getTablaInstrucciones() {
        return tablaInstrucciones;
    }

    public Object[][] getTablaDatos() {
        return tablaDatos;
    }
    
    public String[][] getTablaDatosSTR(Object[][] obj)
    {
        String [][] tmp = new String[256][2];
        for (int i = 0; i < 256; i++)
            for (int j = 0; j < 2; j++){
                tmp[i][j] = split0x(obj[i][j].toString());
            }
        return tmp;
    }

    public Object[][] initDataTable()
    {
        int contador = 0;
        String intStr, strHex, hex = null;
        for (int i = 0; i < 256; i++){
            for (int j = 0; j < 2; j++){
                if (j == 0) {
                   intStr = Integer.toString(contador);
                   strHex = Long.toHexString((i*4)+1024);
                   hex = String.format("%8s", strHex).replace(' ', '0');
                   tablaDatos[i][j] = "0x" + hex; 
                }else
                   tablaDatos[i][j] = "0x00000000";
            }
            contador += 4;
        }
        return tablaDatos;
    }
    
    public Object[][] initInstructionTable()
    {
        int contador = 0;
        String intStr, strHex, hex = null;
        for (int i = 0; i < 256; i++){
            for (int j = 0; j < 2; j++){
                if (j == 0) {
                   intStr = Integer.toString(contador);
                   strHex = Long.toHexString(i*4);
                   hex = String.format("%8s", strHex).replace(' ', '0');
                   tablaInstrucciones[i][j] = "0x" + hex; 
                }else
                   tablaInstrucciones[i][j] = "0x00000000";
            }
            contador += 4;
        }
        return tablaInstrucciones;
    }
    
    public void updateTableValues(JTable table, int row, int column)
    {
    // instrucciones y datos row = 256; column = 2
    // registros row = 16; column = 2
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (j == 1) 
                   tablaInstrucciones[i][j] = table.getValueAt(i, j).toString();
    }
    
    public void verifySintaxis()
    {
        String strHex, hex, strTmp = null;
        String valor;
        //Object[][] tmp = new Object[256][2];
        for (int i = 0; i < 256; i++){
            for (int j = 1; j < 2; j++){
                valor = tablaInstrucciones[i][j].toString();
                if (startsWith0x(valor.toString())
                        && valor.toString().length() < 10
                        && valor.toString().length() > 0
                        && (verifyHex(split0x(valor.toString())) || verifyDec(split0x(valor.toString())))) {
                    System.out.println("OK: Detecta 0x, menos de 10 caracteres");
                    strTmp = split0x(valor.toString());
                    completeData(strTmp);
                    
                } else if (!startsWith0x(valor.toString())
                        && valor.toString().length() < 8
                        && valor.toString().length() > 0
                        && (verifyHex(valor) || verifyDec(valor))){
                    System.out.println("OK: No Detecta 0x, hay SÓLO menos de 8 caracteres");
                    completeData(valor);
                
                } else if (startsWith0x(valor.toString())
                        && valor.toString().length() == 10
                        && (verifyHex(split0x(valor.toString())) || verifyDec(split0x(valor.toString())))) {
                    System.out.println("OK: Detecta 0x, más 8 caracteres");
                    strTmp = split0x(valor.toString());
                    
                } else if (!startsWith0x(valor.toString())
                        && valor.toString().length() == 8
                        && (verifyHex(valor) || verifyDec(valor))){
                    System.out.println("OK: No Detecta 0x, hay SÓLO 8 caracteres");
                
                } else {
                    System.out.println("ERROR");
                }
            }//fin for j
        }//fin del fors ij
        //return tmp;
    }
    
    public void verifySintaxis(String valor)
    {
        String strTmp;
        String strHex, hex = null;
                if (startsWith0x(valor.toString())
                        && valor.toString().length() < 10
                        && valor.toString().length() > 0
                        && (verifyHex(split0x(valor.toString())) || verifyDec(split0x(valor.toString())))) {
                    System.out.println("OK: Detecta 0x, menos de 10 caracteres");
                    strTmp = split0x(valor.toString());
                    completeData(strTmp);
                    
                }
                else if (!startsWith0x(valor.toString())
                        && valor.toString().length() < 8
                        && valor.toString().length() > 0
                        && (verifyHex(valor) || verifyDec(valor))){
                    System.out.println("OK: No Detecta 0x, hay SÓLO menos de 8 caracteres");
                    completeData(valor);
                }
                else if (startsWith0x(valor.toString())
                        && valor.toString().length() == 10
                        && (verifyHex(split0x(valor.toString())) || verifyDec(split0x(valor.toString())))) {
                    System.out.println("OK: Detecta 0x, más 8 caracteres");
                    strTmp = split0x(valor.toString());
                    
                }
                else if (!startsWith0x(valor.toString())
                        && valor.toString().length() == 8
                        && (verifyHex(valor) || verifyDec(valor))){
                    System.out.println("OK: No Detecta 0x, hay SÓLO 8 caracteres");
                }
                else
                {
                    System.out.println("ERROR");
                }

        
    }
    
    public String split0x(String value)
    {
        String[] parts = value.split("0x");
        //String part2 = parts[1]; // Elimina 0x, 0xvalue(obtiene value)   
        //System.out.println("A: " + parts[1]);
        return parts[1];
    }

    public boolean startsWith0x(String value)
    {
        if (value.startsWith("0x")) 
            return true;    
        else 
            return false;  
    }

    public boolean verifyHex(String value)
    {
        if (value.matches("-?[0-9a-f]+")) 
            return true;
        else
            return false;
    }
    
    public boolean verifyDec(String value)
    {
        if (value.matches("-?[0-9]+")) 
            return true;
        else
            return false;
    }
    
    public String completeData(String value)
    {
        String newValue = null;
        String ceros = "";
        for (int i = 0; i < (8 - value.length()); i++) {
            ceros += "0";
        }
        newValue = ceros + value;
        //System.out.println("Tamaño value: " + value.length());
        System.out.println("Completado: " + newValue);
        return newValue;
    }


}//fin del clase