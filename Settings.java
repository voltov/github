package com.voltov.catalogcreatorsandbox.settings;

/**
 * Empty by default. You must call fillSettingsFromVoltov() to fill settings.
 */
public class Settings {

    public static String Host;
    public static int Port;
    public static String User;
    public static String Password;
    public static String DatabaseName;

    public static String getHost() {
        return Host;
    }

    public static int getPort() {
        return Port;
    }

    public static String getUser() {
        return User;
    }

    public static String getPassword() {
        return Password;
    }

    public static String getDatabaseName() {
        return DatabaseName;
    }

    public static void fillSettingsFromVoltov() {
        Host = SettingsOfVoltov.HOST;
        Port = SettingsOfVoltov.PORT;
        User = SettingsOfVoltov.USER;
        Password = SettingsOfVoltov.PASSWORD;
        DatabaseName = SettingsOfVoltov.DATABASE_NAME;
    }

}
