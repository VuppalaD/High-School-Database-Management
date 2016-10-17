// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class SQLQuery extends Task
{
    // Data members.
    private Vector vector;
    private Connection connection;
    private QueryPanel queryPanel;

    // Constants.
    private static final String QUERY_CMD = "Run Query";

    public SQLQuery(String name, boolean enabled)
    {
        super(name, enabled);

        vector = new Vector();

        queryPanel = new QueryPanel();
    }

    @Override
    public boolean execute(Connection connection)
    {
        this.connection = connection;

        new PromptFrame(
                "SQL Query Input",
                QUERY_CMD,
                queryPanel,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(actionEvent.getActionCommand().equals(QUERY_CMD))
                        {
                            Vector results = handleQuery(queryPanel.getQuery());

                            if(results != null)
                            {
                                ResultsTablePanel resultsTablePanel = new ResultsTablePanel(results);

                                new ResultsFrame("SQL Query Results", resultsTablePanel);
                            }
                        }
                    }
                });

        return true;
    }

    private Vector handleQuery(String query)
    {
        Vector results = new Vector();

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
                    queryPanel,
                    msg,
                    "Query Failure",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return results;
    }
}