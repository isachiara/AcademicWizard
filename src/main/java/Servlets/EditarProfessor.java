/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.EnderecoprofessorJpaController;
import Controller.ProfessorJpaController;
import Controller.TelefoneprofessorJpaController;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Edu
 */
public class EditarProfessor extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        Professor professor = (Professor) session.getAttribute("professor");

        ProfessorJpaController profControll = new ProfessorJpaController();
        Professor editar = profControll.findProfessor(professor.getSiape());

        EnderecoprofessorJpaController endControl = new EnderecoprofessorJpaController();
        Enderecoprofessor endereco = endControl.findEnderecoprofessor(editar.getEnderecoprofessor().getIdEndereco());

        request.setAttribute("perfil", editar);
        request.setAttribute("endereco", endereco);
        RequestDispatcher page = request.getRequestDispatcher("editarInformacoesProfessor.jsp");
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
        Professor professor = new Professor();
        Telefoneprofessor telefone = new Telefoneprofessor();
        Enderecoprofessor endereco = new Enderecoprofessor();

      ProfessorJpaController professorControl = new ProfessorJpaController();
        TelefoneprofessorJpaController telControl = new TelefoneprofessorJpaController();

        professor.setNome(request.getParameter("nome"));
        professor.setCpf(request.getParameter("cpf"));
        professor.setSexo(request.getParameter("genero"));
        professor.setSenha(request.getParameter("senha"));

        endereco.setEstado(request.getParameter("estado"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setCep(request.getParameter("cep"));
        endereco.setRua(request.getParameter("rua"));
        endereco.setNumero(request.getParameter("numero"));
        professor.setEnderecoprofessor(endereco);

        telefone.setTelefone(request.getParameter("telefone"));
        telefone.setProfessorSiape(professor);

        try {
            professorControl.edit(professor);
            telControl.edit(telefone);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(editarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(editarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(editarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher page = request.getRequestDispatcher("PerfilProfessor");
        page.forward(request, response);
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
