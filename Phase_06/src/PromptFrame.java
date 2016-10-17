// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PromptFrame extends JFrame
{
    // Data members.
    private JPanel frameContainer;
    private JButton promptButton;

    public PromptFrame(
            String title,
            String promptLabel,
            JPanel promptPanel,
            ActionListener promptHandler)
    {
        super(title);

        buildGUI(promptLabel, promptPanel, promptHandler);

        pack();

        setVisible(true);
    }

    private void buildGUI(
            String promptLabel,
            JPanel promptPanel,
            ActionListener promptHandler)
    {
        // Instantiate objects.
        frameContainer = new JPanel();
        promptButton = new JButton(promptLabel);

        frameContainer.setLayout(new BorderLayout());

        frameContainer.add(promptPanel, BorderLayout.NORTH);

        promptButton.addActionListener(promptHandler);

        promptButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        PromptFrame.this.dispose();
                    }
                });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });

        frameContainer.add(promptButton, BorderLayout.SOUTH);

        setContentPane(frameContainer);
    }
}
