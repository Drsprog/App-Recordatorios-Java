/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class RecordatorioDAO {
    
    Conexion cn= new Conexion();
    Connection con;
    
    int r;
    ResultSet rs;
    CallableStatement cs;
    
    public List ListarInfo(int ide){
        List<RecVista> lista= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_LISTARECORDATORIOS(?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setInt(1,ide);
            rs=cs.executeQuery();
            while(rs.next()){
                RecVista rec= new RecVista();
                rec.setIDE_REC(rs.getInt("Ide"));
                rec.setTIT_REC(rs.getString("Titulo"));
                rec.setNOM_SRV(rs.getString("Servicio")); 
                rec.setINI_REC(rs.getDate("Inicio"));    
                rec.setFPG_REC(rs.getDate("Pago"));
                rec.setALR_REC(rs.getDate("Alerta"));  
                rec.setCLC_REC(rs.getString("Ciclo"));  
                lista.add(rec);
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
    
      public RecVista ListarID(int ide){
        RecVista rec= new RecVista();
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_LISTARECOIDE(?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setInt(1,ide);
            rs=cs.executeQuery();
            while(rs.next()){           
                rec.setIDE_REC(rs.getInt("Ide"));
                rec.setTIT_REC(rs.getString("Titulo"));
                rec.setNOM_SRV(rs.getString("Servicio")); 
                rec.setINI_REC(rs.getDate("Fecha de inicio"));    
                rec.setFPG_REC(rs.getDate("Fecha de pago"));
                rec.setALR_REC(rs.getDate("Fecha de alerta"));  
                rec.setCLC_REC(rs.getString("Ciclo"));  
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
        return rec;     
    }
    
    
    public List Buscar(int ide, String txt){
        List<RecVista> lista= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_BUSCARRECORDATORIO(?, ?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setInt(1,ide);
            cs.setString(2,txt);
            rs=cs.executeQuery();
            while(rs.next()){
                RecVista rec= new RecVista();
                rec.setIDE_REC(rs.getInt("Ide"));
                rec.setTIT_REC(rs.getString("Titulo"));
                rec.setNOM_SRV(rs.getString("Servicio")); 
                rec.setINI_REC(rs.getDate("Inicio"));    
                rec.setFPG_REC(rs.getDate("Pago"));
                rec.setALR_REC(rs.getDate("Alerta"));  
                rec.setCLC_REC(rs.getString("Ciclo"));  
                lista.add(rec);
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
    
    public void Agregar(Recordatorio rec){
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_NUEVORECORDATORIO(?, ?, ?, ?, ?, ?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setString(1,rec.getTIT_REC());
            cs.setInt(2,rec.getIDE_SRV());
            cs.setDate(3,rec.getINI_REC());
            cs.setDate(4,rec.getFPG_REC());
            cs.setDate(5, rec.getALR_REC());
            cs.setString(6,rec.getCLC_REC());
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
     
       public void Modificar(Recordatorio rec){
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_ACTUALIZARECORDATORIO(?, ?, ?, ?, ?, ?, ?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setInt(1,rec.getIDE_REC());
            cs.setString(2,rec.getTIT_REC());
            cs.setInt(3,rec.getIDE_SRV());
            cs.setDate(4,rec.getINI_REC());
            cs.setDate(5,rec.getFPG_REC());
            cs.setDate(6, rec.getALR_REC());
            cs.setString(7,rec.getCLC_REC());
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
     
    public void Eliminar(int ide){
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_ELIMINARECORDATORIO(?)}");
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
