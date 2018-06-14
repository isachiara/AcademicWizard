<%-- 
    Document   : editarInformacoes
    Created on : 25/04/2018, 17:35:43
    Author     : Isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        #forms{
            display: inline-block;
            padding-right: 100px ;
            padding-left: 100px;
        }
        label{
            padding:0px;
        }
        button{
            color: white;
        }
    </style>
    <body>
        <div class="container" id="all">
            <header>Solicitar modificação nas informações do aluno</header>
            <nav><ul id="menu">
                    <li id="menuItem"><a class="active" href="perfilAluno.jsp">Home</a></li>
                    <li id="menuItem"><a href="MatriculaDisciplina" action="get">Matriculas</a></li>
                    <li id="menuItem"><a href="disciplinas">Lista Disciplinas</a></li>
                    <li id="menuItem"><a href="editarAluno" action="get">Editar informações</a></li>
                    <li id="menuItem" style="float:right"><a class="active" href="Logout">Deslogar</a></li>
                </ul>
            </nav>
            <div class="container" id="corpo">
                <div>
                    <form action="editarAluno" method="post">
                        <div id="forms">
                            <label>Nome:</label></br>
                            <input type="text" name="nome" value="${perfil.nome}" required="required"/></br>
                            <label>CPF:</label></br>
                            <input type="text" name="cpf" value="${perfil.cpf}" required="required"/></br>
                            <label>Sexo:</label></br>
                            <input type="radio" name="genero" value="M" required="required"/> Masculino
                            <input type="radio" name="genero" value="F" required="required"/> Feminino</br>
                            <label>Senha:</label></br>
                            <input type="password" name="senha" value="${perfil.senha}" required="required"/></br>

                        </div>
                        <div id="forms">
                            <label>Estado:</label></br>
                            <input type="text" name="estado" value="${endereco.estado}" required="required"/></br>
                            <label>Cidade:</label></br>
                            <input type="text" name="cidade" value="${endereco.cidade}" required="required"/></br>
                            <label>Bairro:</label></br>
                            <input type="text" name="bairro" value="${endereco.bairro}" required="required"/></br>
                            <label>Rua:</label></br>
                            <input type="text" name="rua" value="${endereco.rua}" required="required"/></br>
                            <label>Numero:</label></br>
                            <input type="text" name="numero" value="${endereco.numero}" required="required"/></br>
                            <label>Cep:</label></br>
                            <input type="text" name="cep" value="${endereco.cep}" required="required"/></br>

                        </div>
                        <button type="submit" class="btn btn-warning btn-block">Concluir </button>
                    </form>
                    </br>

                </div>
            </div>
            <footer> 10/05/2018 Versão 1.000
                © 2018 AcademicWizard</footer>
        </div>

    </body>
</html>
