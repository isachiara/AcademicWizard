<%-- 
    Document   : inscricaoDisciplina
    Created on : 25/04/2018, 17:35:29
    Author     : Isabella
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matricula</title>
    </head>
    <style>
        body{
            background-image: url(imagem.png);
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
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
            width: 800px;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover {
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
            margin-top: 150px;
            position: fixed;
        }
    </style>
    <body>
        <div class="container" id = "all">
            <header>Matriculas</header>
          <nav><ul id="menu">
                    <li id="menuItem"><a class="active" href="perfilAluno.jsp">Home</a></li>
                    <li id="menuItem"><a href="MatriculaDisciplina" method="get">Matriculas</a></li>
                    <li id="menuItem"><a href="disciplinas">Lista Disciplinas</a></li>
                    <li id="menuItem"><a href="editarAluno">Editar informações</a></li>
                    <li id="menuItem" style="float:right"><a class="active" href="Logout">Deslogar</a></li>
                </ul>
            </nav>
            <div class="container" id="corpo">

                <form action="MatriculaDisciplina" method="post">
                    <table class="table table-striped" id="myTable">
                        <tr>
                            <th onclick="sortTable(0)">Nome: </th>
                            <th onclick="sortTable(1)">Periodo: </th>
                            <th>Marcar:</th>

                        </tr>
                        <c:forEach items="${disciplinas}" var="disciplina">
                            <tr>
                                <td>${disciplina.nome}</td>
                                <td>${disciplina.periodo}</td>
                                <td><input type="checkbox" value="Disciplina01" name="matricula" /></td>
                            </tr>
                        </c:forEach>

                    </table>
                    <button type="submit" class="btn btn-warning btn-block" value="submit">Concluir </button>
                   
                </form>

                
            </div>
            <footer> 10/05/2018 Versão 1.000
                © 2018 AcademicWizard</footer>
        </div>



    </body>
</html>
