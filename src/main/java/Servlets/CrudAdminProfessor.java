/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.EnderecoprofessorJpaController;
import Controller.ProfessorJpaController;
import Controller.TelefoneprofessorJpaController;
import Model.Enderecoprofessor;
import Model.Professor;
import Model.Telefoneprofessor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edu
 */
public class CrudAdminProfessor extends HttpServlet {

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
        Professor professor = new Professor();
        Telefoneprofessor telProfessor = new Telefoneprofessor();
        Enderecoprofessor endProfessor = new Enderecoprofessor();

        ProfessorJpaController professorControl = new ProfessorJpaController();
        EnderecoprofessorJpaController endControl = new EnderecoprofessorJpaController();
        TelefoneprofessorJpaController telControl = new TelefoneprofessorJpaController();

        professor.setSiape(request.getParameter("siape"));

        professor.setNome(request.getParameter("nome"));
        professor.setCpf(request.getParameter("cpf"));
        professor.setSenha(request.getParameter("senha"));
        professor.setSexo(request.getParameter("genero"));
        professor.setCurso(request.getParameter("curso"));

        endProfessor.setEstado(request.getParameter("estado"));
        endProfessor.setCidade(request.getParameter("cidade"));
        endProfessor.setBairro(request.getParameter("bairro"));
        endProfessor.setCep(request.getParameter("cep"));
        endProfessor.setRua(request.getParameter("rua"));
        endProfessor.setNumero(request.getParameter("numero"));
        professor.setEnderecoprofessor(endProfessor);

        telProfessor.setTelefone(request.getParameter("professor"));
        telProfessor.setProfessorSiape(professor);

        try {
            professorControl.create(professor);
            telControl.create(telProfessor);
            RequestDispatcher page = request.getRequestDispatcher("administrador");
            page.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CrudAdminProfessor.class.getName()).log(Level.SEVERE, null, ex);
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
