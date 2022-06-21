/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
public class Validar extends HttpServlet {
    UsuarioDAO usuDAO= new UsuarioDAO();
    Usuario usu= new Usuario();
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
//        HttpSession ses= request.getSession();
//        String accion= request.getParameter("accion");
//        int ide=Integer.parseInt(String.valueOf(ses.getAttribute("ide")));
//        if (accion.equals("ListarInfo")) {
//            List lista=serDAO.Listar(ide);
//            request.setAttribute("servicio",lista);
//            request.getRequestDispatcher("CreaRecordatorio.jsp").forward(request, response);
//        }
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
         HttpSession ses= request.getSession();
         int conf=Integer.parseInt(request.getParameter("conf"));
         if (conf==0){
           ses.removeAttribute("corr");
            ses.removeAttribute("nomb");
            ses.removeAttribute("apel");
            ses.invalidate();
            request.getRequestDispatcher("Index.jsp").forward(request, response);
         }   
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
            String nom=request.getParameter("nombres");
            String ape=request.getParameter("apellidos");  
            String cor=request.getParameter("email");
            String pass=request.getParameter("password");
            usu.setNOM_USU(nom);
            usu.setAPE_USU(ape);
            usu.setCOR_USU(cor);
            usu.setCON_USU(pass);
            usuDAO.Agregar(usu);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    
        if(accion.equalsIgnoreCase("Ingresar")){
            String cor=request.getParameter("email");
            String pass=request.getParameter("password");
            usu= usuDAO.Validar(cor, pass);
            if (usu.getCOR_USU()!=null) {
//                response.sendRedirect("Controlador?accion=Index2");
                HttpSession ses= request.getSession();
                ses.setAttribute("ide", usu.getIDE_USU());
                ses.setAttribute("corr", usu.getCOR_USU());
                ses.setAttribute("nomb", usu.getNOM_USU());
                ses.setAttribute("apel", usu.getAPE_USU());
                request.getRequestDispatcher("Index2.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
        
        if(accion.equalsIgnoreCase("Modificar")){
        HttpSession ses= request.getSession();
        int ide=Integer.parseInt(String.valueOf(ses.getAttribute("ide")));
        String nom=request.getParameter("nombres");
        String ape=request.getParameter("apellidos");
        String cor=request.getParameter("email");
        usu.setIDE_USU(ide);
        usu.setNOM_USU(nom);
        usu.setAPE_USU(ape);
        usu.setCOR_USU(cor);
        ses.setAttribute("nomb", usu.getNOM_USU());
        ses.setAttribute("apel", usu.getAPE_USU());
        ses.setAttribute("corr", usu.getCOR_USU());
        usuDAO.Modificar(usu);
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);
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
