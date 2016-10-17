// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionButtonPanel extends JPanel
{
    // Data members.
    private JButton connectButton;

    public ConnectionButtonPanel()
    {
        // Instantiate data members.
        connectButton = new JButton("Connect");

        // Set layout.
        setLayout(new FlowLayout());

        // Add connection button.
        add(connectButton);

        connectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if (Client.getInstance().connect())
                        {
                            Client.getInstance().getMainFrame().setTaskPanel();
                        }
                        else
                        {
                            String msg = "Could not build connection. Check\n"
                                    + "provided connection data and verify\n"
                                    + "server availability.";

                            JOptionPane.showMessageDialog(
                                    Client.getInstance().getMainFrame(),
                                    msg,
                                    "Connection Failure",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                }
        );
    }


}
