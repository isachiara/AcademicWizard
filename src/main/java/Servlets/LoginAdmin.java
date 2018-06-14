/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.AdministradorJpaController;
import Controller.DisciplinaJpaController;
import Controller.ProfessorJpaController;
import Model.Administrador;
import Model.Disciplina;
import Model.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edu
 */
public class LoginAdmin extends HttpServlet {

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
        RequestDispatcher page = request.getRequestDispatcher("loginAdm.jsp");
        page.forward(request, response);
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
        Administrador adm = new Administrador();
        AdministradorJpaController admControll = new AdministradorJpaController();
        adm.setUsuario(request.getParameter("usuario"));
        adm.setSenha(request.getParameter("senha"));

        if (admControll.findAdm(adm.getUsuario(), adm.getSenha())) {
            DisciplinaJpaController disciControll = new DisciplinaJpaController();
            List<Disciplina> disciplinas = disciControll.getAllDisciplinas();

            ProfessorJpaController profControll = new ProfessorJpaController();
            List<Professor> professores = profControll.getAllProfessores();

            request.setAttribute("listDisciplina", disciplinas);
            request.setAttribute("listProfessor", professores);
            RequestDispatcher page = request.getRequestDispatcher("administrador.jsp");
            page.forward(request, response);
        } else { // Erro de login
            request.setAttribute("erroLogin", "Usuario ou senha inválidos.");
            RequestDispatcher login = request.getRequestDispatcher("loginAdm.jsp");
            login.forward(request, response);
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
