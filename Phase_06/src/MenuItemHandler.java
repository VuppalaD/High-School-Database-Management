// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class MenuItemHandler implements ActionListener
{
    // Data members.
    private ClassIdPanel classIdPanel;
    private String schoolYear;

    // Constants.
    private static final String SELECT_CMD = "Select Class ID";
    private static final String QUERY_CMD = "Query";

    // Ctor.
    public MenuItemHandler()
    {
        classIdPanel = new ClassIdPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        onMenuItem(e);
    }

    private void onMenuItem(ActionEvent e)
    {
        JMenu menu          = null;
        String query        = null;
        String tableTitle   = null;
        Vector results      = null;

        if(e.getActionCommand().equals("Disconnect"))
        {
            Client.getInstance().getMainFrame().setConnectionPanel();

            return;
        }

        if(e.getSource() instanceof JMenuItem)
        {
            JMenuItem menuItem = (JMenuItem) e.getSource();

            JPopupMenu parent = (JPopupMenu) menuItem.getParent();

            Component invoker = parent.getInvoker();

            menu = (JMenu) invoker;
        }

        if(e.getActionCommand().equals("2011-2012"))
        {
            if(menu.getActionCommand().equals("Students Enrolled"))
            {
                query = "SELECT *\n" +
                        "FROM Student s, EnrollsIn e, Classes c\n" +
                        "WHERE s.studentId = e.studentId\n" +
                        "AND e.classId = c.classId\n" +
                        "AND c.schoolYear = '2011-2012';";

                tableTitle = "Students Enrolled in Classes (2011-2012)";
            }
            else if(menu.getActionCommand().equals("Class ID's"))
            {
                query = "SELECT c.classId\n" +
                        "FROM Classes c\n" +
                        "WHERE c.schoolYear = '2011-2012'\n" +
                        "AND c.section_ = '1.1' OR c.section_ = '1.2';";

                tableTitle = "Class ID's (2011-2012)";
            }
            else if(menu.getActionCommand().equals("Average Score"))
            {
                query = "SELECT AVG(t.score) AS Average\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2011-2012';";

                tableTitle = "Average Test Score (2011-2012)";
            }
            else if(menu.getActionCommand().equals("Overall"))
            {
                query = "SELECT k.subject, COUNT(s.studentId) AS StudentCount, t.hasPassed\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2011-2012'\n" +
                        "GROUP BY k.subject\n" +
                        "HAVING t.hasPassed = 'Y';\n";

                tableTitle = "Students that Passed Tests (2011-2012)";
            }
            else if(menu.getActionCommand().equals("By Class ID"))
            {
                new PromptFrame(
                        "Class ID",
                        QUERY_CMD,
                        classIdPanel,
                        this
                );

                schoolYear = "2011-2012";

                return;
            }
        }
        else if(e.getActionCommand().equals("2012-2013"))
        {
            if(menu.getActionCommand().equals("Students Enrolled"))
            {
                query = "SELECT *\n" +
                        "FROM Student s, EnrollsIn e, Classes c\n" +
                        "WHERE s.studentId = e.studentId\n" +
                        "AND e.classId = c.classId\n" +
                        "AND c.schoolYear = '2012-2013';";

                tableTitle = "Students Enrolled in Classes (2012-2013)";
            }
            else if(menu.getActionCommand().equals("Class ID's"))
            {
                query = "SELECT c.classId\n" +
                        "FROM Classes c\n" +
                        "WHERE c.schoolYear = '2012-2013'\n" +
                        "AND c.section_ = '1.1' OR c.section_ = '1.2';";

                tableTitle = "Class ID's (2012-2013)";
            }
            else if(menu.getActionCommand().equals("Average Score"))
            {
                query = "SELECT AVG(t.score) AS Average\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2012-2013';";

                tableTitle = "Average Test Score (2012-2013)";
            }
            else if(menu.getActionCommand().equals("Overall"))
            {
                query = "SELECT k.subject, COUNT(s.studentId) AS StudentCount, t.hasPassed\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2012-2013'\n" +
                        "GROUP BY k.subject\n" +
                        "HAVING t.hasPassed = 'Y';\n";

                tableTitle = "Students that Passed Tests (2012-2013)";
            }
            else if(menu.getActionCommand().equals("By Class ID"))
            {
                new PromptFrame(
                        "Class ID",
                        QUERY_CMD,
                        classIdPanel,
                        this
                );

                schoolYear = "2012-2013";

                return;
            }
        }
        else if(e.getActionCommand().equals("2013-2014"))
        {
            if(menu.getActionCommand().equals("Students Enrolled"))
            {
                query = "SELECT *\n" +
                        "FROM Student s, EnrollsIn e, Classes c\n" +
                        "WHERE s.studentId = e.studentId\n" +
                        "AND e.classId = c.classId\n" +
                        "AND c.schoolYear = '2013-2014';";

                tableTitle = "Students Enrolled in Classes (2013-2014)";
            }
            else if(menu.getActionCommand().equals("Class ID's"))
            {
                query = "SELECT c.classId\n" +
                        "FROM Classes c\n" +
                        "WHERE c.schoolYear = '2013-2014'\n" +
                        "AND c.section_ = '1.1' OR c.section_ = '1.2';";

                tableTitle = "Class ID's (2013-2014)";
            }
            else if(menu.getActionCommand().equals("Average Score"))
            {
                query = "SELECT AVG(t.score) AS Average\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2013-2014';";

                tableTitle = "Average Test Score (2013-2014)";
            }
            else if(menu.getActionCommand().equals("Overall"))
            {
                query = "SELECT k.subject, COUNT(s.studentId) AS StudentCount, t.hasPassed\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2013-2014'\n" +
                        "GROUP BY k.subject\n" +
                        "HAVING t.hasPassed = 'Y';\n";

                tableTitle = "Students that Passed Tests (2013-2014)";
            }
            else if(menu.getActionCommand().equals("By Class ID"))
            {
                new PromptFrame(
                        "Class ID",
                        QUERY_CMD,
                        classIdPanel,
                        this
                );

                schoolYear = "2013-2014";

                return;
            }
        }
        else if(e.getActionCommand().equals("2014-2015"))
        {
            if(menu.getActionCommand().equals("Students Enrolled"))
            {
                query = "SELECT *\n" +
                        "FROM Student s, EnrollsIn e, Classes c\n" +
                        "WHERE s.studentId = e.studentId\n" +
                        "AND e.classId = c.classId\n" +
                        "AND c.schoolYear = '2014-2015';";

                tableTitle = "Students Enrolled in Classes (2014-2015)";
            }
            else if(menu.getActionCommand().equals("Class ID's"))
            {
                query = "SELECT c.classId\n" +
                        "FROM Classes c\n" +
                        "WHERE c.schoolYear = '2014-2015'\n" +
                        "AND c.section_ = '1.1' OR c.section_ = '1.2';";

                tableTitle = "Class ID's (2014-2015)";
            }
            else if(menu.getActionCommand().equals("Average Score"))
            {
                query = "SELECT AVG(t.score) AS Average\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2014-2015';";

                tableTitle = "Average Test Score (2014-2015)";
            }
            else if(menu.getActionCommand().equals("Overall"))
            {
                query = "SELECT k.subject, COUNT(s.studentId) AS StudentCount, t.hasPassed\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear = '2014-2015'\n" +
                        "GROUP BY k.subject\n" +
                        "HAVING t.hasPassed = 'Y';\n";

                tableTitle = "Students that Passed Tests (2014-2015)";
            }
            else if(menu.getActionCommand().equals("By Class ID"))
            {
                new PromptFrame(
                        "Class ID",
                        QUERY_CMD,
                        classIdPanel,
                        this
                );

                schoolYear = "2014-2015";

                return;
            }
        }
        else if(e.getActionCommand().equals("Not Passed"))
        {
            query = "SELECT s.name\n" +
                    "FROM Student s, Takes t, Test k\n" +
                    "WHERE s.studentId = t.studentId\n" +
                    "AND t.testId = k.testId\n" +
                    "AND t.hasPassed = 'N'\n" +
                    "AND s.studentId NOT IN (\n" +
                        "SELECT s.studentId\n" +
                        "FROM Student s\n" +
                        "WHERE s.level_ IN (9, 10, 11));";

            tableTitle = "Students That Haven't Pass Tests";
        }
        else if(e.getActionCommand().equals(QUERY_CMD))
        {
            String classID = classIdPanel.getClassId();

            query = "SELECT s.name, c.classId, t.hasPassed\n" +
                    "FROM Student s, EnrollsIn e, Classes c, Takes t\n" +
                    "WHERE s.studentId = e.studentId\n" +
                    "AND e.classId = c.classId\n" +
                    "AND c.schoolYear ='" + schoolYear + "'\n" +
                    "AND c.classId =" + classID + "\n" +
                    "AND s.studentId IN (\n" +
                        "SELECT s.studentId\n" +
                        "FROM Student s, Takes t, Test k\n" +
                        "WHERE s.studentId = t.studentId\n" +
                        "AND t.testId = k.testId\n" +
                        "AND k.schoolYear ='" + schoolYear + "'\n" +
                        "AND t.hasPassed = 'Y');";

            tableTitle = "Students that Passed Classes & Tests (" + schoolYear +")";
        }
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

        if(query != null)
        {
            results = handleQuery(query);
        }

        if(results != null)
        {
            ResultsTablePanel resultsTablePanel = new ResultsTablePanel(results);

            new ResultsFrame(tableTitle, resultsTablePanel);
        }
    }

    private Vector handleQuery(String query)
    {
        Vector results = new Vector();

        Connection connection = Client.getInstance().getConnector().getConnection();

        try
        {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];

            for(int i = 0; i < columnCount; i++)
            {
                columnNames[i] = metaData.getColumnName(i + 1);
            }

            results.add(columnNames);

            while (resultSet.next())
            {
                String[] values = new String[columnCount];

                for(int i = 0; i < columnCount; i++)
                {
                    values[i] = resultSet.getString(i + 1);
                }

                results.add(values);
            }
        }
        catch (SQLException ex)
        {
            results = null;

            String msg = "Failed to execute query.\n"
                    + SQLExceptionReader.read(ex);

            JOptionPane.showMessageDialog(
                    Client.getInstance().getMainFrame().getTaskPanel(),
                    msg,
                    "Query Failure",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return results;
    }
}
