// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import javax.sound.sampled.Port;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class ResultsTablePanel extends JPanel
{
    // Data members.
    private ResultTableModel resultTableModel;
    private JTable resultsTable;
    private JScrollPane scrollPane;
    private Dimension viewPort;

    // Constants.
    final static int PORT_WIDTH = 800;
    final static int PORT_HEIGHT = 600;

    // Ctor.
    public ResultsTablePanel(Vector vector)
    {
        resultTableModel = new ResultTableModel(vector);

        resultsTable = new JTable(resultTableModel);

        resultsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        setColumnWidths();

        scrollPane = new JScrollPane(resultsTable);

        viewPort = new Dimension(PORT_WIDTH, PORT_HEIGHT);

        resultsTable.setPreferredScrollableViewportSize(viewPort);

        add(scrollPane);
    }

    private void setColumnWidths()
    {
        TableCellRenderer renderer = resultsTable.getTableHeader().getDefaultRenderer();

        for(int i = 0; i < resultsTable.getColumnCount(); i++)
        {
            TableColumn tableColumn = resultsTable.getColumnModel().getColumn(i);

            Object headerValueObject = tableColumn.getHeaderValue();

            Component headerComponent = renderer.getTableCellRendererComponent(
                    resultsTable,
                    headerValueObject,
                    false,
                    false,
                    -1,
                    i
            );

            tableColumn.setPreferredWidth(
                    headerComponent.getPreferredSize().width
            );
        }
    }
}
