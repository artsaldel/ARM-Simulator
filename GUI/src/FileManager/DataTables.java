package FileManager;

import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author Daniel
 */
public class DataTables {
    
    public DataTables()
    {}
    
    public static void getDataTable(JTable jtable)
    {
        int[] columns = jtable.getSelectedColumns();
        TableModel model = jtable.getModel();
        int rowcount = model.getRowCount();
        String[][] output = new String[columns.length][rowcount];
        for (int i = 0; i < columns.length; i++){
            for (int row = 0; row < rowcount; row++){
                int column = jtable.convertColumnIndexToModel(columns[i]);
                output[i][row] = model.getValueAt(row, column).toString();
                System.out.println(output[i][row] + "\n");
            }
        }
    }
    
}
