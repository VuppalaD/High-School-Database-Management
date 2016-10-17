// ==========================================
// Created by Gabriel Villanueva
// CSCI 6333
// Phase 06
// ==========================================

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector
{
    // Data members.
    private String host;
    private String dbName;
    private String port;
    private String user;
    private String password;
    private Connection connection;

    // Ctor.
    public Connector()
    {
    }

    // Accesors.
    public String getUser()
    {
        return user;
    }

    public String getPassword()
    {
        return password;
    }

    public Connection getConnection()
    {
        return connection;
    }

    public String getURL()
    {
        StringBuilder stringBuilder = new StringBuilder("jdbc:mysql://");

        stringBuilder.append(host);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("/");
        stringBuilder.append(dbName);

        return stringBuilder.toString();
    }

    // Mutators.
    public void setHost(String host)
    {
        this.host = host;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    // Methods.
    public boolean connect()
    {
        try
        {
            connection = DriverManager.getConnection(
                    getURL(),
                    getUser(),
                    getPassword());
        }
        catch (SQLException ex)
        {
            System.out.println(SQLExceptionReader.read(ex));

            return false;
        }
        
        return true;
    }

    public void closeConnection()
    {
        try
        {
            if(connection != null)
                connection.close();
        }
        catch (SQLException ex)
        {
            System.out.println(SQLExceptionReader.read(ex));
        }
    }
}
