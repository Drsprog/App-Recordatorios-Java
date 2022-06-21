/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.RecVista;
import Modelo.Recordatorio;
import Modelo.RecordatorioDAO;
import Modelo.Servicio;
import Modelo.ServicioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
public class ContRecordatorio extends HttpServlet {
    CategoriaDAO catDAO= new CategoriaDAO();
    Categoria cat = new Categoria();
    Servicio ser= new Servicio();
    ServicioDAO serDAO= new ServicioDAO();
    Recordatorio rec= new Recordatorio();
    RecordatorioDAO recDAO= new RecordatorioDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        String accion= request.getParameter("accion");
        int ide=Integer.parseInt(String.valueOf(ses.getAttribute("ide")));
            if (accion.equals("ListarServ")) {
            List lista=serDAO.Listar(ide);
            request.setAttribute("servicio",lista);
            request.getRequestDispatcher("CreaRecordatorio.jsp").forward(request, response);
            }
            if (accion.equals("ModificarRec")) {
            int ideRec = Integer.parseInt(request.getParameter("ideRec"));
            List lista=serDAO.Listar(ide);
            request.setAttribute("servicio",lista);
            RecVista recV=recDAO.ListarID(ideRec);
            request.setAttribute("datrecor",recV);
            request.getRequestDispatcher("ModRecordatorio.jsp").forward(request, response);
            }
             if (accion.equals("ListarRec")) {
            List lista=recDAO.ListarInfo(ide);
            request.setAttribute("recordatorio",lista);
            request.getRequestDispatcher("Recordatorio.jsp").forward(request, response);
            }   
            if (accion.equals("EliminarRec")) {
            int ideRec = Integer.parseInt(request.getParameter("ideRec"));
            recDAO.Eliminar(ideRec);
            request.getRequestDispatcher("ContRecordatorio?accion=ListarRec").forward(request, response);
            }   
            if (accion.equals("Buscar")) {
            String txt=request.getParameter("txt");
            List lista=recDAO.Buscar(ide,txt);
            request.setAttribute("recordatorio",lista);
            request.getRequestDispatcher("Recordatorio.jsp").forward(request, response);
            }    
            if (accion.equals("BorrarRec")) {
            int ideser=Integer.parseInt(request.getParameter("servicio"));
            serDAO.Eliminar(ideser);
            request.getRequestDispatcher("ContRecordatorio?accion=ListarServ").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String accion= request.getParameter("accion");
        
         if (accion.equals("Registrar")) {
            int ideser=Integer.parseInt(request.getParameter("servicio"));
            String tit=request.getParameter("titulo");
            String cic=request.getParameter("ciclo");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String pag = request.getParameter("pago"); 
            String ini= request.getParameter("inicio");
            String ala= request.getParameter("alarma");
            Date fecini;
            Date fecala;
            Date fecpag;
            java.util.Date sqlFecpag;
            java.util.Date sqlFecini;
            java.util.Date sqlFecala;
            try {
                sqlFecini = sdf.parse(ini);
                sqlFecala = sdf.parse(ala);
                sqlFecpag = sdf.parse(pag);
                fecini = new java.sql.Date(sqlFecini.getTime());
                fecala = new java.sql.Date(sqlFecala.getTime());
                fecpag = new java.sql.Date(sqlFecpag.getTime());
                
                rec.setTIT_REC(tit);
                rec.setIDE_SRV(ideser);
                rec.setINI_REC(fecini);
                rec.setFPG_REC(fecpag);
                rec.setALR_REC(fecala);
                rec.setCLC_REC(cic);
                recDAO.Agregar(rec);
                request.getRequestDispatcher("ContRecordatorio?accion=ListarRec").forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ContRecordatorio.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        if (accion.equals("Modificar")) {
            int iderec=Integer.parseInt(request.getParameter("ideRec"));
            int ideser=Integer.parseInt(request.getParameter("servicio"));
            String tit=request.getParameter("titulo");
            String cic=request.getParameter("ciclo");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String pag = request.getParameter("pago"); 
            String ini= request.getParameter("inicio");
            String ala= request.getParameter("alarma");
            Date fecini;
            Date fecala;
            Date fecpag;
            java.util.Date sqlFecpag;
            java.util.Date sqlFecini;
            java.util.Date sqlFecala;
            try {
                sqlFecini = sdf.parse(ini);
                sqlFecala = sdf.parse(ala);
                sqlFecpag = sdf.parse(pag);
                fecini = new java.sql.Date(sqlFecini.getTime());
                fecala = new java.sql.Date(sqlFecala.getTime());
                fecpag = new java.sql.Date(sqlFecpag.getTime());
                
                rec.setIDE_REC(iderec);
                rec.setTIT_REC(tit);
                rec.setIDE_SRV(ideser);
                rec.setINI_REC(fecini);
                rec.setFPG_REC(fecpag);
                rec.setALR_REC(fecala);
                rec.setCLC_REC(cic);
                recDAO.Modificar(rec);
                request.getRequestDispatcher("ContRecordatorio?accion=ListarRec").forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ContRecordatorio.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
