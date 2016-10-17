// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.table.AbstractTableModel;
import java.util.Objects;
import java.util.Vector;

public class ResultTableModel extends AbstractTableModel
{
    // Data Members.
    private String[] columnNames;
    private String[][] tableData;

    public ResultTableModel(Vector vector)
    {
        columnNames = (String[]) vector.get(0);

        vector.remove(0);

        int rowCount = vector.size();
        int columnCount = columnNames.length;

        tableData = new String[rowCount][columnCount];

        for(int i = 0; i < rowCount; i++)
        {
            tableData[i] = (String[]) vector.get(i);
        }
    }

    public String getColumnName(int columnIndex)
    {
        return columnNames[columnIndex];
    }

    public int getColumnCount()
    {
        return columnNames.length;
    }

    public int getRowCount()
    {
        return tableData.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    {
        return tableData[rowIndex][columnIndex];
    }
}
