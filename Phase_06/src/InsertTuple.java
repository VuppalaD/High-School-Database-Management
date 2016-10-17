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

public class InsertTuple extends Task implements ActionListener
{
    // Data members.
    private Connection connection;
    private TablePanel tablePanel;
    private ValuePanel valuePanel;
    private String tableName;

    // Constants.
    private static final String SELECT_CMD = "Select Table";
    private static final String INSERT_CMD = "Insert Row";

    // Ctor.
    public InsertTuple(String name, boolean enabled)
    {
        super(name, enabled);

        // Instantiate objects.
        tablePanel = new TablePanel();
    }

    @Override
    public boolean execute(Connection connection)
    {
        this.connection = connection;

        new PromptFrame(
                "Table Name",
                SELECT_CMD,
                tablePanel,
                this
        );

        return true;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String cmd = actionEvent.getActionCommand();

        if(cmd.equals(SELECT_CMD))
        {
            tableName = tablePanel.getTableName();

            String[] columnNames = getColumnNames();

            if(columnNames != null)
            {
                valuePanel = new ValuePanel(columnNames);

                new PromptFrame(
                        "Row Value Input",
                        INSERT_CMD,
                        valuePanel,
                        this
                );
            }
        }
        else if (cmd.equals(INSERT_CMD))
        {
            String insertSQL = "INSERT INTO " + tableName
                    + " " + valuePanel.getValuesAsSQL();

            insertRow(insertSQL);
        }
    }

    private String[] getColumnNames()
    {
        String msg = "";

        Vector columnNames = new Vector();

        try
        {
            DatabaseMetaData metaData = connection.getMetaData();

            ResultSet resultSet = metaData.getColumns(
                    null,
                    null,
                    tableName,
                    "%"
            );

            while(resultSet.next())
            {
                columnNames.add(resultSet.getString("COLUMN_NAME"));
            }

            if(columnNames.size() == 0)
            {
                columnNames = null;
            }
        }
        catch (SQLException ex)
        {
            columnNames = null;

            msg = SQLExceptionReader.read(ex);
        }

        if(columnNames == null)
        {
            String msgx = "Failed to access table (" +
                    tableName + ")\n" + msg;

            JOptionPane.showMessageDialog(
                    tablePanel,
                    msgx,
                    "Insert Row Failure",
                    JOptionPane.ERROR_MESSAGE
            );

            return null;
        }
        else
        {
            return (String[]) columnNames.toArray(new String[0]);
        }
    }

    private void insertRow(String insertSql)
    {
        try
        {
            Statement statement = connection.createStatement();

            int count = statement.executeUpdate(insertSql);

            if(count != 1)
            {
               String msg = "Row insert failed. Returned "
                       + count + ".";

                JOptionPane.showMessageDialog(
                        null,
                        msg,
                        "Insert Failure",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            else
            {
                String msg = "Row insert succesful.";

                JOptionPane.showMessageDialog(
                        null,
                        msg,
                        "Insert Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
        catch (SQLException ex)
        {
            String msg = "Failed to insert row.\n"
                    + SQLExceptionReader.read(ex);

            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Insert Failure",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
