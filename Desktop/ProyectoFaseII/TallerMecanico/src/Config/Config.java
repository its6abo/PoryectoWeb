/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

/**
 *
 * @author gabri
 */
public class Config {
    public static String getConnectionString() throws ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return "jdbc:sqlserver://localhost;databaseName=CR_Taller;user=sa;password=sa";
    }
}
