/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.DisciplinaJpaController;
import Controller.ProfessorJpaController;
import Model.Disciplina;
import Model.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.TypeConverter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edu
 */
public class CrudAdminDisciplina extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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
        Disciplina d = new Disciplina();
        DisciplinaJpaController dControl = new DisciplinaJpaController();
        ProfessorJpaController pControl = new ProfessorJpaController();

        Professor professor = (Professor) request.getAttribute("professor");

        if (professor != null) {
            d.setNome(request.getParameter("nome"));
            d.setCargaHoraria(request.getParameter("carga"));
            d.setHorario(request.getParameter("hora"));
            d.setDias(request.getParameter("dias"));
            d.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
            d.setRequisito(request.getParameter("disciplinas"));
            d.setProfessorSiape(professor);
            //d.setProfessorSiape(pControl.findProfessor(professor).get(0));
            try {
                dControl.create(d);
                RequestDispatcher page = request.getRequestDispatcher("administrador");
                page.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(CrudAdminProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        processRequest(request, response);
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
