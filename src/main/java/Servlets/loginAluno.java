package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controller.AdministradorJpaController;
import Controller.AlunoJpaController;
import Controller.EnderecoalunoJpaController;
import Model.Administrador;
import Model.Aluno;
import Model.Enderecoaluno;
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
 * @author Henrique
 */
public class loginAluno extends HttpServlet {

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
        AlunoJpaController alunoControl = new AlunoJpaController();
        //EnderecoalunoJpaController enderecoControl = new EnderecoalunoJpaController();

        Aluno aluno = alunoControl.findAluno(request.getParameter("matricula"), request.getParameter("senha"));

       // Enderecoaluno endereco = enderecoControl.findEnderecoPorAluno(aluno);
        if (aluno != null) {
            HttpSession session = request.getSession();
            if (session.isNew()) {
                session.setAttribute("aluno", aluno);
            } else {
                session.invalidate();
                session = request.getSession();
                session.setAttribute("aluno", aluno);
            }
        
            RequestDispatcher page = request.getRequestDispatcher("PerfilAluno");
            page.forward(request, response);

        } else {
            request.setAttribute("erroLogin", "Matricula ou senha inválidos.");
            RequestDispatcher login = request.getRequestDispatcher("index.jsp");
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
