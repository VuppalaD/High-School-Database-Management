// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;

public class ClassIdPanel extends JPanel
{
    // Data members.
    private JTextField classIdField;

    // Constants.
    private static final int FIELD_COLS = 20;

    // Ctor.
    public ClassIdPanel()
    {
        // Instantiate objects.
        classIdField = new JTextField();

        setLayout(new BorderLayout());

        add(new JLabel("Class ID: "), BorderLayout.WEST);

        classIdField.setColumns(FIELD_COLS);

        add(classIdField, BorderLayout.EAST);
    }

    public String getClassId()
    {
        return classIdField.getText();
    }
}
