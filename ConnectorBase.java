package com.voltov.catalogcreatorsandbox.database;

import com.voltov.catalogcreatorsandbox.settings.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Knows how to open connection to MySQL database. Uses Settings class to get username and etc.
 */
public class ConnectorBase  {

    public Connection connection;

    public boolean openConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + Settings.Host + ":" + String.valueOf(Settings.Port) + "/" + Settings.DatabaseName,
                    Settings.User,
                    Settings.Password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
