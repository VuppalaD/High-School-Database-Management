// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import java.sql.SQLException;

public class SQLExceptionReader
{
    public static String read(SQLException ex)
    {
        StringBuffer stringBuffer = new StringBuffer(1024);

        SQLException nextEx;

        int exceptionNumber = 0;

        do
        {
            stringBuffer.append("Exception " + exceptionNumber + ": \n");
            stringBuffer.append("\tMessage: " + ex.getMessage() + "\n");
            stringBuffer.append("\tState: " + ex.getSQLState() + "\n");
            stringBuffer.append("\tCode: " + ex.getErrorCode() + "\n");

            nextEx = ex.getNextException();
        }
        while(nextEx != null);

        return stringBuffer.toString();
    }
}
