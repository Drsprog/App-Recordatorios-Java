/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ServicioDAO {
    Conexion cn= new Conexion();
    Connection con;
    
    int r;
    ResultSet rs;
    CallableStatement cs;
    
    public int Agregar(Servicio s){
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_NUEVOSERVICIO(?, ?, ?, ?, ?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setString(1,s.getNOM_SRV());
            cs.setInt(2,s.getIDE_CAT());
            cs.setInt(3,s.getIDE_USU());
            cs.setString(4,s.getMON_SRV());
            cs.setDouble(5,s.getPAG_SRV());
            cs.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
        finally{
            try {
                if(con!=null) con.close();
                if(cs!=null) cs.close();       
            } catch (Exception e) {
                System.err.println("Error:" + e);
            }
        }
        return r;
    }
    
    public List Listar(int ide){
        List<Servicio> lista= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_LISTASERVICIOS(?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setInt(1,ide);
            rs=cs.executeQuery();
            while(rs.next()){
                Servicio ser= new Servicio();
                ser.setIDE_SRV(rs.getInt("Ide"));
                ser.setNOM_SRV(rs.getString("Nombre"));  
                lista.add(ser);
            }    

        } catch (Exception e) { 
            System.err.println("Error:" + e);
        } 
        finally{
            try {
                if(con!=null) con.close();
                if(rs!=null)  rs.close();
                if(cs!=null) cs.close();       
            } catch (Exception e) {
                System.err.println("Error:" + e);
            }
        }      
        return lista; 
    } 
    
    public void Eliminar(int ide){
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_ELIMINARSERVICIO(?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setInt(1,ide);
            cs.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
        finally{
            try {
                if(con!=null) con.close();
                if(cs!=null) cs.close();       
            } catch (Exception e) {
                System.err.println("Error:" + e);
            }
        }
    } 
}
