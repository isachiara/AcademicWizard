/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.AlunoJpaController;
import Controller.EnderecoalunoJpaController;
import Controller.TelefonealunoJpaController;
import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
import Model.Aluno;
import Model.Enderecoaluno;
import Model.Telefonealuno;
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
 * @author Isabella
 */
public class editarAluno extends HttpServlet {

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

        RequestDispatcher page = request.getRequestDispatcher("editarInformacoes.jsp");
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
        processRequest(request, response);
        Aluno aluno = new Aluno();
        Telefonealuno telAluno = new Telefonealuno();
        Enderecoaluno endAluno = new Enderecoaluno();

        AlunoJpaController alunoControl = new AlunoJpaController();
        EnderecoalunoJpaController endControl = new EnderecoalunoJpaController();
        TelefonealunoJpaController telControl = new TelefonealunoJpaController();

        aluno.setNome(request.getParameter("nome"));
        aluno.setCpf(request.getParameter("cpf"));
        aluno.setSexo(request.getParameter("genero"));

        endAluno.setEstado(request.getParameter("estado"));
        endAluno.setCidade(request.getParameter("cidade"));
        endAluno.setBairro(request.getParameter("bairro"));
        endAluno.setCep(request.getParameter("cep"));
        endAluno.setRua(request.getParameter("rua"));
        endAluno.setNumero(request.getParameter("numero"));
        aluno.setEnderecoaluno(endAluno);

        telAluno.setTelefonecol(request.getParameter("telefone"));
        telAluno.setAlunoMatricula(aluno);

        try {
            alunoControl.edit(aluno);
            endControl.edit(endAluno);
            telControl.edit(telAluno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(editarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(editarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(editarAluno.class.getName()).log(Level.SEVERE, null, ex);
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
