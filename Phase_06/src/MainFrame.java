// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame
{
    // Data members.
    private JPanel mainPanel;
    private MainMenuBar mainMenuBar;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem fileExit;
    private ConnectionInputPanel connectionInputPanel;
    private ConnectionButtonPanel connectionButtonPanel;
    private TaskPanel taskPanel;

    public ConnectionInputPanel getConnectionInputPanel()
    {
        return connectionInputPanel;
    }

    public TaskPanel getTaskPanel()
    {
        return taskPanel;
    }

    public MainFrame()
    {
        // Instantiate objects.
        mainPanel               = new JPanel();
        mainMenuBar             = new MainMenuBar();
        connectionInputPanel    = new ConnectionInputPanel();
        connectionButtonPanel   = new ConnectionButtonPanel();
        taskPanel               = new TaskPanel();
    }

    public void run()
    {
        // Build GUI.
        build();

        setConnectionPanel();

        pack();

        setVisible(true);
    }

    private void build()
    {
        mainMenuBar.build();

        //setJMenuBar(menuBar);
        setJMenuBar(mainMenuBar);

        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        setTitle("CSCI 6333 Project Phase 06");

        setLocationRelativeTo(null);

        setPreferredSize(new Dimension(300, 200));
    }

    public void setConnectionPanel()
    {
        mainMenuBar.setVisible(false);

        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout(5, 5));

        connectionInputPanel.reset();

        mainPanel.add(connectionInputPanel, BorderLayout.NORTH);
        mainPanel.add(connectionButtonPanel, BorderLayout.EAST);

        setContentPane(mainPanel);
    }

    public void setTaskPanel()
    {
        mainMenuBar.setVisible(true);

        mainPanel.removeAll();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(taskPanel, BorderLayout.NORTH);

        setContentPane(mainPanel);
    }
}
