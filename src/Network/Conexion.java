/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class Conexion 
{
    //Variable conexion
    private static Connection connect = null;
    
    //Valor de retorno
    private static boolean valor;
        
    //Variables para conectividad
    private static String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/BDPCSV";
                
    //Metodo de conexion
    public static Connection Conectar()
    {
        //Resetear valores de conexion
        valor = false;        
        
        try
        {
            Class.forName(driver);
            
            // Nos conectamos a la bd
            connect = (Connection) DriverManager.getConnection(url, user, password);
            
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (connect != null)
            {
                //System.out.println("Conexion establecida");
                JOptionPane.showMessageDialog(null,"Conexion establecida");
                valor = true;
            }
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            //System.out.println("Error de conexion" + e);
            JOptionPane.showMessageDialog(null,"Error con el driver JDBC");
        }
        catch (SQLException exception) 
        {
            try 
            {
                JOptionPane.showMessageDialog(null, "Error en la conexion" + exception);
                connect.close();
            } 
            catch (SQLException ex) 
            {
                //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en la conexion 2" + ex);
            }
        }
           
        return connect;
    }
    
    //Metodo de conexion
    public static void Desconectar() throws SQLException
    {        
        connect.close();

    }
    
    public Connection getConexion() 
    {
        return connect;
    }
}
