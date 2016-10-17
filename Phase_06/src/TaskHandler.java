// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLClientInfoException;

public class TaskHandler implements ActionListener
{
    public void actionPerformed(ActionEvent actionEvent)
    {
        Connector connector = Client.getInstance().getConnector();

        if(connector.getConnection() == null)
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

            return;
        }

        JButton sourceButton = (JButton) actionEvent.getSource();
        String taskName = sourceButton.getText();

        int taskCount = Client.getInstance().getMainFrame().getTaskPanel().getTasks().size();

        boolean dispatched = false;

        for(int i = 0; i < taskCount; i++)
        {
            Task task = Client.getInstance().getMainFrame().getTaskPanel().getTasks().get(i);

            if(!task.isEnabled())
            {
                continue;
            }

            if(taskName.equals(task.getName()))
            {
                dispatched = task.execute(connector.getConnection());

                if(!dispatched)
                {
                    String msg = "Could not execute task: \n"
                            + task.getName();

                    JOptionPane.showMessageDialog(
                            Client.getInstance().getMainFrame(),
                            msg,
                            "Task Failure",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                break;
            }
        }

        if(!dispatched)
        {
            connector.closeConnection();
        }
    }
}
