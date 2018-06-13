package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.AdministradorJpaController;
import Controller.AlunoJpaController;
import Controller.EnderecoalunoJpaController;
import Controller.TelefonealunoJpaController;
import Model.Administrador;
import Model.Aluno;
import Model.Enderecoaluno;
import Model.Telefonealuno;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Henrique
 */
public class CrudAdmin extends HttpServlet {

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
            throws ServletException, IOException, Exception {
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
        Aluno aluno = new Aluno();
        Telefonealuno telAluno = new Telefonealuno();
        Enderecoaluno endAluno = new Enderecoaluno();

        AlunoJpaController alunoControl = new AlunoJpaController();
        EnderecoalunoJpaController endControl = new EnderecoalunoJpaController();
        TelefonealunoJpaController telControl = new TelefonealunoJpaController();

        aluno.setMatricula(request.getParameter("matricula"));

        aluno.setNome(request.getParameter("nome"));
        aluno.setCpf(request.getParameter("cpf"));
        aluno.setSenha(request.getParameter("senha"));
        aluno.setSexo(request.getParameter("genero"));
        aluno.setCurso(request.getParameter("curso"));

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
            alunoControl.create(aluno);
            telControl.create(telAluno);
            RequestDispatcher page = request.getRequestDispatcher("administrador");
            page.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CrudAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
