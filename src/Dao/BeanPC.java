/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author marce
 */
public class BeanPC 
{
    
     private Integer Id;
     private String Marca;
     private String Modelo;
     private String Anio;
     private String Estaus;
     private String FechaRegistro;
     private String FechaGarantia;
     private String Especificaciones;
     private String Condiciones;
     private String VersionWinddows;
     private String VersionOffice;
     private String DetalleVersiones;

    /*public BeanPC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    public String getEstaus() {
        return Estaus;
    }

    public void setEstaus(String Estaus) {
        this.Estaus = Estaus;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getFechaGarantia() {
        return FechaGarantia;
    }

    public void setFechaGarantia(String FechaGarantia) {
        this.FechaGarantia = FechaGarantia;
    }

    public String getEspecificaciones() {
        return Especificaciones;
    }

    public void setEspecificaciones(String Especificaciones) {
        this.Especificaciones = Especificaciones;
    }

    public String getCondiciones() {
        return Condiciones;
    }

    public void setCondiciones(String Condiciones) {
        this.Condiciones = Condiciones;
    }

    public String getVersionWinddows() {
        return VersionWinddows;
    }

    public void setVersionWinddows(String VersionWinddows) {
        this.VersionWinddows = VersionWinddows;
    }

    public String getVersionOffice() {
        return VersionOffice;
    }

    public void setVersionOffice(String VersionOffice) {
        this.VersionOffice = VersionOffice;
    }

    public String getDetalleVersiones() {
        return DetalleVersiones;
    }

    public void setDetalleVersiones(String DetalleVersiones) {
        this.DetalleVersiones = DetalleVersiones;
    }
       
 
}
