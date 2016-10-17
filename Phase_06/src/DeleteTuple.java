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

public class DeleteTuple extends Task implements ActionListener
{
    // Data members.
    private Connection connection;
    private TablePanel tablePanel;
    private ValuePanel valuePanel;
    private String tableName;

    // Constants.
    private static final String SELECT_CMD = "Select Table";
    private static final String DELETE_CMD = "Delete Row";

    // Ctor.
    public DeleteTuple(String name, boolean enabled)
    {
        super(name, enabled);

        // Instantiate objects.
        tablePanel = new TablePanel();
    }

    @Override
    public boolean execute(Connection connection) {

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
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if(cmd.equals(SELECT_CMD))
        {
            tableName = tablePanel.getTableName();

            String[] columnNames = getColumnNames();

            if(columnNames != null)
            {
                valuePanel = new ValuePanel(columnNames);

                new PromptFrame(
                        "Row Value Input",
                        DELETE_CMD,
                        valuePanel,
                        this
                );
            }
        }
        else if (cmd.equals(DELETE_CMD))
        {
            String deleteSQL = "DELETE FROM " + tableName
                    + " " + valuePanel.getDeleteSQLstatement();

            deleteRow(deleteSQL);
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
                    "Delete Row Failure",
                    JOptionPane.ERROR_MESSAGE
            );

            return null;
        }
        else
        {
            return (String[]) columnNames.toArray(new String[0]);
        }
    }

    private void deleteRow(String deleteSql)
    {
        try
        {
            Statement statement = connection.createStatement();

            int count = statement.executeUpdate(deleteSql);

            if(count != 1)
            {
                String msg = "Row deletion failed. Returned "
                        + count + ".";

                JOptionPane.showMessageDialog(
                        null,
                        msg,
                        "Delete Failure",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            else
            {
                String msg = "Row deletion successful.";

                JOptionPane.showMessageDialog(
                        null,
                        msg,
                        "Delete Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
        catch (SQLException ex)
        {
            String msg = "Failed to delete row.\n"
                    + SQLExceptionReader.read(ex);

            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Delete Failure",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
