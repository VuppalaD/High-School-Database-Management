// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class TablePanel extends JPanel
{
    // Data members.
    private JTextField tableNameField;

    // Constants.
    private static final int FIELD_COLS = 20;

    // Ctor.
    public TablePanel()
    {
        // Instantiate objects.
        tableNameField = new JTextField();

        setLayout(new BorderLayout());

        add(new JLabel("Table Name: "), BorderLayout.WEST);

        tableNameField.setColumns(FIELD_COLS);

        add(tableNameField, BorderLayout.EAST);
    }

    public String getTableName()
    {
        return tableNameField.getText();
    }
}
