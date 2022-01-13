/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Dao.BeanPC;
import Network.Conexion;
import Views.Home;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author marce
 */
public class Entradas 
{
    //Conexion a base de datos
    Conexion con = new Conexion();       
    Connection connect; 
    
    //Metodo1: Ingreso de registros de PC
    public void InsertRegistroPC(String Marca, String Modelo,String Anio, String Status,
            String FechaRegistro, String FechaGarantiaString,String Especificaciones, 
            String Condiciones, String VersionWindows, String VersionOffice,
            String DetallesVersiones) throws SQLException 
    {      
       
        connect = con.Conectar();
               
        try 
        {

            String Query = "INSERT INTO `pc`(`id_pc`, `marca`, `modelo`, `anio`, `estatus`, `fecha_registro`, "
                + "`fecha_garantia`, `especificaciones`, `condiciones`, `version_windows`, `version_office`,"
                + " `detalles_versiones`) VALUES (null,'" + Marca.toUpperCase() + "','" + Modelo.toUpperCase() + "','" + Anio.toUpperCase() + "','"
                + Status.toUpperCase() + "','" + FechaRegistro.toUpperCase() + "','" + FechaGarantiaString.toUpperCase() + "','" + Especificaciones.toUpperCase() + "','" 
                + Condiciones.toUpperCase() + "','" + VersionWindows.toUpperCase() + "','" + VersionOffice.toUpperCase() + "','" + DetallesVersiones.toUpperCase() + "')";
        
            //System.out.println(Query);
            //JOptionPane.showMessageDialog(null, " Query insert " + connect);
            try (Statement St = (Statement) connect.createStatement())
            {
                St.executeUpdate(Query);
                JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                St.close();
                con.Desconectar();
                connect.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        finally 
        {
            if (connect != null) 
            {
                try 
                {
                    con.Desconectar();
                    connect.close();
                } 
                catch (SQLException sqle) 
                {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
                    Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, sqle);
                }
            }
        }  
    }
    
    //public void BuscarRegistroPC(String ParametroBusqueda) throws SQLException 
    //public String[] BuscarRegistroPC(String ParametroBusqueda) throws SQLException 
    public ArrayList<String> BuscarRegistroPC(String ParametroBusqueda) throws SQLException 
    {

        connect = con.Conectar(); 
        
        //Creacion de arreglo que devuelve informacion
        String []registro = new String[12];
        String []registroP = new String[12];
        String []registroP2 = new String[12];
        ArrayList listado = new ArrayList();
        
        //Formato de campo busqueda
        ParametroBusqueda = ParametroBusqueda.toUpperCase();
        
        //Variables
        Integer id_pc = 0;
        String marca =  "";
        String modelo = "";
        String anio  = "";
        String estatus =  "";
        String fecha_registro;
        String fecha_garantia;
        String especificaciones = "";
        String condiciones = "";
        String version_windows = "";
        String version_office = "";
        String detalles_versiones = "";
                
        try 
        {

            String Query = "SELECT `id_pc`, `marca`, `modelo`, `anio`, `estatus`, `fecha_registro`,"
                    + " `fecha_garantia`, `especificaciones`, `condiciones`, `version_windows`,"
                    + " `version_office`, `detalles_versiones` FROM `pc` "
                    + " WHERE "
                    + " marca LIKE '%" + ParametroBusqueda + "%' OR modelo LIKE '%" + ParametroBusqueda 
                    + "%' OR anio LIKE '%" + ParametroBusqueda + "%' OR estatus  LIKE '%" + ParametroBusqueda
                    + "%' OR especificaciones LIKE '%" + ParametroBusqueda + "%' OR  condiciones LIKE '%" + ParametroBusqueda
                    + "%' OR version_windows LIKE '%" + ParametroBusqueda + "%' OR  version_office LIKE '%" + ParametroBusqueda 
                    + "%' OR detalles_versiones LIKE '%" + ParametroBusqueda + "%' ";
        
            System.out.println(Query);
            //JOptionPane.showMessageDialog(null, " Query select " + connect);
            
            Statement St = (Statement) connect.createStatement();
            //JOptionPane.showMessageDialog(null, " Query select 2");
                     
            try (ResultSet Rs = St.executeQuery(Query))
            {//JOptionPane.showMessageDialog(null, " Query select 3 ");
                
                int contador = 0;
                                
                while (Rs.next()) 
                {JOptionPane.showMessageDialog(null, " RS.NEXT +1");
                
                    //Objeto a llenar por cada registro
                    /*Object dato = new Object[12];
                    for (int i = 1; i <= 12; i++) 
                    {                      
                        dato = Rs.getObject(i);
                        JOptionPane.showMessageDialog(null, " RS.NEXT +1");
                    }
                    listado.add(dato);*/
                    
                    //Objeto 
                    BeanPC pc = new BeanPC();
                    pc.setId(Rs.getInt("id_pc"));
                    pc.setMarca(Rs.getString("marca"));
                    pc.setModelo(Rs.getString("modelo"));
                    pc.setAnio(Rs.getString("anio"));
                    pc.setEstaus(Rs.getString("estatus"));
                    pc.setFechaRegistro(Rs.getString("fecha_registro"));
                    pc.setFechaGarantia(Rs.getString("fecha_garantia"));
                    pc.setEspecificaciones(Rs.getString("especificaciones"));
                    pc.setCondiciones(Rs.getString("condiciones"));
                    pc.setVersionWinddows(Rs.getString("version_windows"));
                    pc.setVersionOffice(Rs.getString("version_office"));
                    pc.setDetalleVersiones(Rs.getString("detalles_versiones"));
                    
                    /*id_pc = Rs.getInt("id_pc");
                    marca = Rs.getString("marca");
                    modelo = Rs.getString("modelo");
                    anio = Rs.getString("anio");
                    estatus = Rs.getString("estatus");
                    fecha_registro = Rs.getString("fecha_registro");
                    fecha_garantia = Rs.getString("fecha_garantia");
                    especificaciones = Rs.getString("especificaciones");
                    condiciones = Rs.getString("condiciones");
                    version_windows = Rs.getString("version_windows");
                    version_office = Rs.getString("version_office");
                    detalles_versiones = Rs.getString("detalles_versiones");*/
                    
                    JOptionPane.showMessageDialog(null, " contador=" + contador);
                    
                    /*registro[0] = Integer.toString(id_pc);
                    registro[1] = marca;
                    registro[2] = modelo;
                    registro[3] = anio;
                    registro[4] = estatus;
                    registro[5] = fecha_registro;
                    registro[6] = fecha_garantia;
                    registro[7] = especificaciones;
                    registro[8] = condiciones;
                    registro[9] = version_windows;
                    registro[10] = version_office;
                    registro[11] = detalles_versiones;*/
                    
                    //JOptionPane.showMessageDialog(null, " id , marca = " +  registro[0] + "," + registro[1]);
                                 
                    listado.add(pc);
                    //listado.add(0, connect);
                   
                    //listado.add(contador,registro[]);  
                    //contador = contador + 1;
                    
                    /*JOptionPane.showMessageDialog(null, " listado.size() " +  listado.size());
                    System.out.println("=---------INICIO ARRAY--------------------------=");
                    for (int i = 0; i < registro.length;  i++) 
                    {
                        JOptionPane.showMessageDialog(null, " in array = " +  i);
                        System.out.println(registro[i]);          
                        
                    }                 
                    System.out.println("=----------FIN ARRAY-------------------------=");
                    
                    System.out.println("=----------INCIO ARRAYLIST-------------------------=");
                    /*JOptionPane.showMessageDialog(null, " IN listado" +  contador);
                    registroP = (String[]) listado.get(contador -1);
                
                    for(int j=0;j<12;j++)
                    {
                        System.out.println(registroP[j]);
                    }*/
                    /*for (int i = 0; i < listado.size(); i++) 
                    {
                        System.out.println(" IN listado" +  i);
                        registroP2 = (String[]) listado.get(i);
                
                        for(int j=0;j<12;j++)
                        {
                            System.out.println(registroP2[j]);
                        }
                    }
                    System.out.println("=----------FIN ARRAYLIST-------------------------=");*/
                }
                
                
                   
                
                /*for (int i = 0; i < listado.size(); i++) 
                    {
                        System.out.println(" IN listado" +  i);
                        registroP2 = (String[]) listado.get(i);
                
                        for(int j=0;j<12;j++)
                        {
                            System.out.println(registroP2[j]);
                        }
                    }*/
                
                
                
                   System.out.println("-----------------------------------");
                   System.out.println("-----------------------------------");
                   System.out.println("-----------------------------------");
                JOptionPane.showMessageDialog(null, " out");
                
                Rs.close();
                St.close();
                
                connect.close();
                
                return listado;
            } 
            catch (SQLException sqle) 
            {
                JOptionPane.showMessageDialog(null, "Error en la consulta MySQL");
                Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
        finally 
        {
            if (connect != null) 
            {
                try 
                {
                    connect.close();
                } 
                catch (SQLException sqle) 
                {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
                    Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, sqle);
                }
            }
        }  
        return null;
    }
    
}
