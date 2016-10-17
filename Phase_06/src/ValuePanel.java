// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;

public class ValuePanel extends JPanel
{
    // Data members.
    private String[] columnNames;
    private JTextField[] valueFields;

    // Constants.
    private static final int FIELD_COLS = 20;

    // Ctor.
    public ValuePanel(String[] columnNames)
    {
        int columnCount = columnNames.length;

        setLayout(new GridLayout(columnCount, 2));

        valueFields = new JTextField[columnCount];

        for(int i = 0; i < columnCount; i++)
        {
            add(new JLabel(columnNames[i] + ":"));

            valueFields[i] = new JTextField(FIELD_COLS);

            add(valueFields[i]);
        }

        this.columnNames = columnNames;
    }

    public String getValuesAsSQL()
    {
        StringBuilder cols = new StringBuilder("(");
        StringBuilder vals = new StringBuilder("VALUES(");

        boolean isFirst = true;

        for(int i = 0; i < columnNames.length; i++)
        {
            String value = valueFields[i].getText();

            if(value.length() == 0)
            {
                continue;
            }

            if(!isFirst)
            {
                cols.append(",");
                vals.append(",");
            }
            else
            {
                isFirst = false;
            }

            cols.append(columnNames[i]);
            vals.append("\"").append(value).append("\"");
        }

        cols.append(")");
        vals.append(")");

        return cols.toString() + " " + vals.toString();
    }

    public String getDeleteSQLstatement()
    {
        StringBuilder statement = new StringBuilder("WHERE ");

        boolean isFirst = true;

        for(int i = 0; i < columnNames.length; i++)
        {
            String value = valueFields[i].getText();

            if(value.length() == 0)
            {
                continue;
            }

            if(!isFirst)
            {
                statement.append(" AND ");
            }
            else
            {
                isFirst = false;
            }

            statement.append(columnNames[i]);
            statement.append("=").append(value);
        }

        statement.append(";");

        return statement.toString();
    }
}
