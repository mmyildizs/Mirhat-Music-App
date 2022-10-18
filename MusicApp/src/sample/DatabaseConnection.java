package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection dbLink;

    public Connection getConnection()
    {
        String dbName = "mirhats_project";
        String dbUser = "root";
        String dbPassword = "root";
        String url = "jdbc:mysql://localhost/" +  dbName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url,dbUser,dbPassword);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

        return dbLink;
    }



}
