<%-- 
    Document   : listaDisciplinas
    Created on : 25/04/2018, 17:34:42
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
        <script src="script.js"></script>
        <title>Lista Disciplinas</title>
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
            position: fixed;
        }
        th {
            cursor: pointer;
        }
    </style>
    <body>
        <div class="container" id = "all">
            <header>Lista das Disciplinas do Curso:</header>
            <nav><ul>
                    <li><a class="active" href="perfilAluno.jsp">Home</a></li>
                    <li><a href="matricula" action="get">Matriculas</a></li>
                    <li><a href="disciplinas" action="get">Lista Disciplinas</a></li>
                    <li><a href="editarAluno" action="get">Editar informações</a></li>
                    <li style="float:right"><a class="active" href="#about">Deslogar</a></li>
                </ul>
            </nav>
            <div class="container" id="corpo">

                <table class="table table-striped" id="myTable">
                    <tr>
                        <th onclick="sortTable(0)">Nome: </th>
                        <th onclick="sortTable(1)">Horario: </th>
                        <th onclick="sortTable(2)">Periodo: </th>
                        <th onclick="sortTable(3)">Requisito: </th>
                    </tr>
                    <c:forEach items="${lista}" var="disciplina">
                        <tr>
                            <td>${disciplina.nome}</td>
                            <td>${disciplina.horario}</td>
                            <td>${disciplina.periodo}</td>
                            <td>${disciplina.requisito}</td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

            <footer> 10/05/2018 Versão 1.000
                © 2018 AcademicWizard</footer>
        </div>


    </body>

</html>

