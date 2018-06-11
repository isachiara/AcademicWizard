<%-- 
    Document   : perfilAluno
    Created on : 24/04/2018, 10:30:26
    Author     : Isabella
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <li id="menuItem"><a class="active" href="perfilAluno.jsp">Home</a></li>
                    <li id="menuItem"><a href="matricula" action="get">Matriculas</a></li>
                    <li id="menuItem"><a href="disciplinas" action="get">Lista Disciplinas</a></li>
                    <li id="menuItem"><a href="editarAluno" action="get">Editar informações</a></li>
                    <li id="menuItem" style="float:right"><a class="active" href="#about">Deslogar</a></li>
                </ul>
            </nav>
            <div class="container" id="corpo">
                <div>
                    <b><p>Informações do Usuário:</p></b>

                    <table class="table table-striped" id="perfil">
                        <tr>
                            <th>Nome:</th>
                            <td><c:out value="${perfil.nome}"/></td>
                        </tr>
                        <tr>
                            <th>Matricula:</th>
                            <td><c:out value="${perfil.matricula}"/></td>
                        </tr>
                        <tr>
                            <th>Curso:</th>
                            <td><c:out value="${perfil.curso}"/></td>
                        </tr>
                        <tr>
                            <th>CPF:</th>
                            <td><c:out value="${perfil.cpf}"/></td>
                        </tr>
                        <tr>
                            <th>Gênero:</th>
                            <td><c:out value="${perfil.sexo}"/></td>
                        </tr>
                        <tr>
                            <th>CEP:</th>
                            <td><c:out value="${endereco.cep}"/></td>
                        </tr>
                        <tr>
                            <th>Cidade:</th>
                            <td><c:out value="${endereco.cep}"/></td>
                        </tr>
                        <tr>
                            <th>Estado:</th>
                            <td><c:out value="${perfil.enderecoalunoList.estado}"/></td>
                        </tr>
                    </table>

                </div>
            </div>


            <footer> 10/05/2018 Versão 1.000
                © 2018 AcademicWizard</footer>
        </div>
    </body>
</html>
