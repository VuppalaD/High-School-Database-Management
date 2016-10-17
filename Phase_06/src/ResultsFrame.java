// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResultsFrame extends JFrame
{
    // Data members.
    private String title;
    private JPanel resultPanel;
    private JPanel frameContainer;
    private JButton closeButton;

    // Ctor.
    public ResultsFrame(String title, JPanel resultPanel)
    {
        super(title);

        this.title = title;
        this.resultPanel = resultPanel;

        frameContainer = new JPanel();
        closeButton = new JButton("Close");

        buildGUI();

        pack();

        setVisible(true);
    }

    private void buildGUI()
    {
        frameContainer.setLayout(new BorderLayout());

        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        e.getWindow().dispose();
                    }
                }
        );
        closeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ResultsFrame.this.dispose();
                    }
                }
        );

        frameContainer.add(resultPanel, BorderLayout.NORTH);
        frameContainer.add(closeButton, BorderLayout.SOUTH);

        setContentPane(frameContainer);
    }
}
