/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO {
    Conexion cn= new Conexion();
    Connection con;
    
    ResultSet rs;
    CallableStatement cs;
    
    public Usuario Validar(String correo, String contra){
        Usuario usu= new Usuario();
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_LISTAUSUARIOS(?, ?)}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            cs.setString(1,correo);
            cs.setString(2,contra);
            rs=cs.executeQuery();
            
            while(rs.next()){
                usu.setCOR_USU(rs.getString("Correo"));
                usu.setCON_USU(rs.getString("Contraseña"));   
                usu.setNOM_USU(rs.getString("Nombres"));
                usu.setAPE_USU(rs.getString("Apellidos"));
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
        
        return usu;
        
    }
    
   
}
