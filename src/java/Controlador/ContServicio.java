/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Servicio;
import Modelo.ServicioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
public class ContServicio extends HttpServlet {

    CategoriaDAO catDAO= new CategoriaDAO();
    Categoria cat = new Categoria();
    Servicio ser= new Servicio();
    ServicioDAO serDAO= new ServicioDAO();
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
             String menu =request.getParameter("accion");
            if (menu.equals("Categoria")){
                List lista=catDAO.Listar();
                request.setAttribute("categoria",lista);
                request.getRequestDispatcher("CreaCategoria.jsp").forward(request, response);
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
        String accion= request.getParameter("accion");
        
         if (accion.equals("Registrar")) {
            int ide=Integer.parseInt(request.getParameter("ide"));
            String nom=request.getParameter("nombre");
            int categ=Integer.parseInt(request.getParameter("categoria"));  
            String mon=request.getParameter("moneda");
            double pago=Double.parseDouble(request.getParameter("pago"));
            
            ser.setNOM_SRV(nom);
            ser.setIDE_CAT(categ);
            ser.setIDE_USU(ide);
            ser.setMON_SRV(mon);
            ser.setPAG_SRV(pago);
            serDAO.Agregar(ser);
            request.getRequestDispatcher("ContRecordatorio?accion=ListarServ").forward(request, response);
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
