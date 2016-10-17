// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;

public class QueryPanel extends JPanel
{
    // Data members.
    private JTextArea sqlArea;

    // Constants.
    private final static int ROWS = 10;
    private final static int COLS = 50;

    public QueryPanel()
    {
        // Instantiate objects.
        sqlArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JLabel("SQL Query"), BorderLayout.NORTH);

        sqlArea.setRows(ROWS);

        sqlArea.setColumns(COLS);

        sqlArea.setLineWrap(true);

        add(sqlArea, BorderLayout.SOUTH);
    }

    public String getQuery()
    {
        return sqlArea.getText();
    }
}
