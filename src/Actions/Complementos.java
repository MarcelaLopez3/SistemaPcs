/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author marce
 */
public class Complementos 
{
    
    public Boolean StringEsNulo(String variable, String mensaje) 
    {
        //Valor de retorno
        boolean valor;
        valor = false;
        
        if(!variable.equals(""))
        {
            valor = true;
        } 
        else
        {
            JOptionPane.showMessageDialog(null, mensaje + " invalido, agregar nuevo valor. ");
        }
        
        return valor;
        
    }
    
    public Boolean DateEsNulo(Date variable, String mensaje) 
    {
        //Valor de retorno
        boolean valor;
        valor = false;
        
        if( variable != null)
        {
            valor = true;
        } 
        else
        {
            JOptionPane.showMessageDialog(null, mensaje + " invalido, agregar nuevo valor. ");
        }
        
        return valor;
        
    }

  
    
}
