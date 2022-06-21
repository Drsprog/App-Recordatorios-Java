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
public class CategoriaDAO {
    Conexion cn= new Conexion();
    Connection con;
    
    int r;
    ResultSet rs;
    CallableStatement cs;
    
    public List Listar(){
        List<Categoria> lista= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        sb.append("{CALL SP_LISTACATEGORIAS()}");
        con=cn.Conexion();
        try {
            cs=con.prepareCall(sb.toString());
            rs=cs.executeQuery();
            while(rs.next()){
                Categoria cat= new Categoria();
                cat.setIde_cat(rs.getInt("Ide"));
                cat.setNom_cat(rs.getString("Nombre"));  
                lista.add(cat);
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
}
