// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;

public class MainMenuBar extends JMenuBar
{
    // Data Members.
    private JMenu fileMenu;
    private JMenu showMenu;
    private JMenu testResultsMenu;

    private JMenu studentsEnrolledMenu;
    private JMenu classIdMenu;
    private JMenu averageScoresMenu;

    private JMenu overallMenu;
    private JMenu byClassIdMenu;

    private JMenuItem disconnectMenuItem;
    private JMenuItem exitMenuItem;

    private JMenuItem[] sYMenuItems;

    private JMenuItem notPassedMenuItem;

    private MenuItemHandler menuItemHandler;

    // Constants.
    private static final int MAX_SY_ITEMS = 20;

    // Ctor.
    public MainMenuBar()
    {
        // Instantiate objects.
        fileMenu                = new JMenu("File");
        showMenu                = new JMenu("Show");
        testResultsMenu         = new JMenu("Test Results");

        studentsEnrolledMenu    = new JMenu("Students Enrolled");
        classIdMenu             = new JMenu("Class ID's");
        averageScoresMenu       = new JMenu("Average Score");

        overallMenu             = new JMenu("Overall");
        byClassIdMenu           = new JMenu("By Class ID");

        disconnectMenuItem      = new JMenuItem("Disconnect");
        exitMenuItem            = new JMenuItem("Exit");

        sYMenuItems             = new JMenuItem[MAX_SY_ITEMS];

        for(int i = 0; i < MAX_SY_ITEMS; i += 4)
        {
            sYMenuItems[i] = new JMenuItem("2011-2012");
            sYMenuItems[i + 1] = new JMenuItem("2012-2013");
            sYMenuItems[i + 2] = new JMenuItem("2013-2014");
            sYMenuItems[i + 3] = new JMenuItem("2014-2015");
        }

        notPassedMenuItem       = new JMenuItem("Not Passed");

        menuItemHandler         = new MenuItemHandler();
    }

    public void build()
    {
        // Add JMenuItems to JMenus.
        fileMenu.add(disconnectMenuItem);
        fileMenu.add(exitMenuItem);

        for (int i = 0; i < 4; i++)
        {
            studentsEnrolledMenu.add(sYMenuItems[i]);
        }

        for (int i = 4; i < 8; i++)
        {
            classIdMenu.add(sYMenuItems[i]);
        }

        for (int i = 8; i < 12; i++)
        {
            averageScoresMenu.add(sYMenuItems[i]);
        }

        for (int i = 12; i < 16; i++)
        {
            overallMenu.add(sYMenuItems[i]);
        }

        overallMenu.add(notPassedMenuItem);

        for (int i = 16; i < MAX_SY_ITEMS; i++)
        {
            byClassIdMenu.add(sYMenuItems[i]);
        }

        // Add JMenus to JMenus.
        showMenu.add(studentsEnrolledMenu);
        showMenu.add(classIdMenu);

        testResultsMenu.add(overallMenu);
        testResultsMenu.add(byClassIdMenu);
        testResultsMenu.add(averageScoresMenu);


        // Add JMenus to JMenuBar.
        this.add(fileMenu);
        this.add(showMenu);
        this.add(testResultsMenu);

        // Add listener to JMenuItems.
        disconnectMenuItem.addActionListener(menuItemHandler);
        exitMenuItem.addActionListener(menuItemHandler);

        for (int i = 0; i < MAX_SY_ITEMS; i++)
        {
            sYMenuItems[i].addActionListener(menuItemHandler);
        }

        notPassedMenuItem.addActionListener(menuItemHandler);
    }
}
