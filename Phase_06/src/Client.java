// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.util.ArrayList;

public class Client extends JFrame
{
    // Data members.
    private MainFrame mainFrame;
    private Connector connector;

    private static Client client;

    // Accessors.
    public static Client getInstance()
    {
        if(client == null)
        {
            client = new Client();
        }

        return client;
    }

    public MainFrame getMainFrame()
    {
        return mainFrame;
    }

    public Connector getConnector()
    {
        return connector;
    }

    // Ctor.
    private Client()
    {
        // Instantiate objects.
        mainFrame = new MainFrame();
        connector = new Connector();
    }

    public void run()
    {
        // Launch Login Frame.
        mainFrame.run();
    }

    public boolean connect()
    {
        ConnectionInputPanel inputPanel = mainFrame.getConnectionInputPanel();

        connector.setHost(inputPanel.getHostTextField().getText());
        connector.setDbName(inputPanel.getDbNameTextField().getText());
        connector.setPort(inputPanel.getPortTextField().getText());
        connector.setUser(inputPanel.getUserTextField().getText());

        String password = new String(inputPanel.getPasswordField().getPassword());

        connector.setPassword(password);

        return connector.connect();
    }
}
