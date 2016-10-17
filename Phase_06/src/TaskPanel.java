// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskPanel extends JPanel
{
    // Data members.
    private JButton[] taskButtons;
    private TaskHandler taskHandler;
    private ArrayList<Task> tasks;

    // Constants.
    final static int COLS = 2;

    // Accessors.
    public ArrayList<Task> getTasks()
    {
        return tasks;
    }

    public TaskPanel()
    {
        // Instantiate ArrayList.
        tasks = new ArrayList<>();

        // Add tasks.
        tasks.add( new SQLQuery("SQL Query", true));
        tasks.add(new InsertTuple("Insert Row", true));
        tasks.add(new DeleteTuple("Delete Row", true));

        int taskCount = tasks.size();

        int rows = (taskCount % COLS == 0)
                ? (taskCount / COLS )
                : (taskCount / COLS + 1);

        setLayout(new GridLayout(rows, COLS, 10, 10));

        taskButtons = new JButton[taskCount];

        taskHandler = new TaskHandler();

        for(int i = 0; i < taskCount; i++)
        {
            Task task = tasks.get(i);

            if(!task.isEnabled())
            {
                continue;
            }

            String taskName = task.getName();

            taskButtons[i] = new JButton(taskName);

            taskButtons[i].addActionListener(taskHandler);

            add(taskButtons[i]);
        }
    }
}
