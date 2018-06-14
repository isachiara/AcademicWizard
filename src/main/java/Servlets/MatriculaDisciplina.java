/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.DisciplinaHasAlunoJpaController;
import Controller.DisciplinaJpaController;
import Model.Aluno;
import Model.Disciplina;
import Model.DisciplinaHasAluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edu
 */
public class MatriculaDisciplina extends HttpServlet {

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
        DisciplinaJpaController dControll = new DisciplinaJpaController();
        List<Disciplina> d = dControll.getAllDisciplinas();

        request.setAttribute("disciplinas", d);
        RequestDispatcher page = request.getRequestDispatcher("inscricaoMatricula.jsp");
        page.forward(request, response);
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
        float f = 0;
        HttpSession sessao = request.getSession();
        Aluno aluno = (Aluno) sessao.getAttribute("aluno");

        Disciplina d = new Disciplina();
        String matricula = request.getParameter("matricula");
        DisciplinaJpaController dControll = new DisciplinaJpaController();
        d = dControll.disciplinaPorNome(matricula);

        DisciplinaHasAlunoJpaController matriculaControll = new DisciplinaHasAlunoJpaController();
        DisciplinaHasAluno discHasAlun = new DisciplinaHasAluno();

        discHasAlun.setAluno(aluno);
        discHasAlun.setDisciplina(d);
        discHasAlun.setEstadoDisciplina("Cursando");
        discHasAlun.setNota(f);

        try {
            matriculaControll.create(discHasAlun);
            RequestDispatcher page = request.getRequestDispatcher("PerfilAluno");
            page.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MatriculaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
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
