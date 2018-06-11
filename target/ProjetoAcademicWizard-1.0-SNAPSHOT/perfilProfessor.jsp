<%-- 
    Document   : perfilProfessor
    Created on : 24/04/2018, 10:30:26
    Author     : Luis Henrique
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Controller.*"%>
<%@page import="Model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%       
    /* Verificando se a sessão está ativa (Manda pra fora ou não?) ------------------------------------
        Se estiver ativa, permanece na página. Senão, redireciona para página principal */
    
    HttpSession sessao = request.getSession();
    String estaAtivo = (String) session.getAttribute("isActive");
     
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil Aluno</title>
    </head>
    <style>
        body{
            background-color: #585858;
        }
        #all{
            clear: both;
            width: 800px;
        }
        header {
            font-family: monospace;
            text-align: center;
            padding: 1em;
            color: white;
            background-color: black;
            width: 800px;
            margin-top: 20px;
            font-size: 40px;
        }
        #menu {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            width: 800px;
        }
        #menuItem {
            float: left;
        }
        #menuItem a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        #menuItem a:hover {
            background-color: #111;
        }
        #corpo{
            background-color: #FAFAFA;
            width: 800px;
            padding: 1em;
            border-style: solid;
            border-color: black;
            border-width: 2px;
        }
        footer{
            font-family: monospace;
            text-align: center;
            padding: 5px;
            color: white;
            background-color: black;
            width: 800px;
            position: fixed;
        }
        p{
            text-align: center;
            margin-bottom: 20px;
        }
       
    </style>
    <body>
        <div class="container" id = "all">
            <header>Bem vindo Aluno!</header>
            <nav><ul id="menu">
                    <li><a class="active" href="perfilProfessor.jsp">Home</a></li>
                    <li><a href="disciplinasProfessor.jsp" action="get">Lista Disciplinas</a></li>
                    <li><a href="editarInformacoesProfessor.jsp" action="get">Editar informações</a></li>
                    <li style="float:right"><a class="active" href="#about">Deslogar</a></li>
                    
                </ul>
            </nav>
            <div class="container" id="corpo">
                <div>
                    <b><p>Informações do Usuário:</p></b>

                    <table class="table table-striped">
                        <tr>
                            <th>Nome:</th>
                            <td>Luis Henrique </td>
                        </tr>
                        <tr>
                            <th>Siape:</th>
                            <td>206548240</td>
                        </tr>
                        <tr>
                            <th>Curso:</th>
                            <td>TADS</td>
                        </tr>
                        <tr>
                            <th>CPF:</th>
                            <td>1004587200</td>
                        </tr>
                        <tr>
                            <th>Gênero:</th>
                            <td>Masculino</td>
                        </tr>
                        <tr>
                            <th>CEP:</th>
                            <td>15445200</td>
                        </tr>
                        <tr>
                            <th>Cidade:</th>
                            <td>cidade</td>
                        </tr>
                        <tr>
                            <th>Estado:</th>
                            <td>estado</td>
                        </tr>
                    </table>

                </div>
            </div>


            <footer> 10/05/2018 Versão 1.000
                © 2018 AcademicWizard</footer>
        </div>
    </body>
</html>