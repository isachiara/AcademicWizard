/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ProfessorJpaController;
import Model.Aluno;
import Model.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class LoginProfessor extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
        processRequest(request, response);
        
        HttpSession sessao = request.getSession();
        
        Professor professor = new Professor();
        ProfessorJpaController profControl = new ProfessorJpaController();

        professor.setSiape(request.getParameter("siape"));
        professor.setSenha(request.getParameter("senha"));
        
        Professor usuarioResult = new Professor();
        
        usuarioResult = profControl.verificaLogin(professor);

        if (usuarioResult != null) {
            sessao.setAttribute("isActive", "verdadeiro");
            sessao.setAttribute("nomeDoCara", usuarioResult.getNome());
            sessao.setAttribute("oCara", usuarioResult);
            
            request.setAttribute("perfil", usuarioResult);
            response.sendRedirect(request.getContextPath() + "perfilProfessor.jsp");
        } else { // Erro de login
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Usuario ou senha incorretos');");
            out.println("</script>");

            sessao.setAttribute("isActive", "falso");
            try {
                //RequestDispatcher Same = request.getRequestDispatcher("/pages/login.jsp"); // Volta para login.sjp
                //Same.include(request, response);
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                //Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect(request.getContextPath() + "index.jsp");

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
