/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Legion 5
 */
public class DatabaseHelper {
    public static Connection getConnection() throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=demo";
        String username = "sa";
        String password = "261001";
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
