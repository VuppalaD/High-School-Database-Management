// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionInputPanel extends JPanel
{
    // Data members.
    private JLabel hostLabel;
    private JLabel dbNameLabel;
    private JLabel portLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;

    private JTextField hostTextField;
    private JTextField dbNameTextField;
    private JTextField portTextField;
    private JTextField userTextField;
    private JPasswordField passwordField;

    // Accessors.
    public JTextField getHostTextField()
    {
        return hostTextField;
    }

    public JTextField getDbNameTextField()
    {
        return dbNameTextField;
    }

    public JTextField getPortTextField()
    {
        return portTextField;
    }

    public JTextField getUserTextField()
    {
        return userTextField;
    }
    public JPasswordField getPasswordField()
    {
        return passwordField;
    }

    // Ctor.
    public ConnectionInputPanel()
    {
        // Instantiate data members.
        hostLabel = new JLabel("Host Name: ");
        dbNameLabel = new JLabel("Database Name: ");
        portLabel = new JLabel("Port Number: ");
        userLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        hostTextField = new JTextField(20);
        dbNameTextField = new JTextField(20);
        portTextField = new JTextField(6);
        userTextField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Set default values.
        reset();

        // Set layout.
        setLayout(new GridLayout(0, 2, 0, 2));

        add(hostLabel);
        add(hostTextField);

        add(dbNameLabel);
        add(dbNameTextField);

        add(portLabel);
        add(portTextField);

        add(userLabel);
        add(userTextField);

        add(passwordLabel);
        add(passwordField);
    }

    public void reset()
    {
        // Set default values.
        hostTextField.setText("localhost");
        dbNameTextField.setText("hsdb");
        portTextField.setText("3306");

        userTextField.setText("");
        passwordField.setText("");
    }
}
