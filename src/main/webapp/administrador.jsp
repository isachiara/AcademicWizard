<%-- 
    Document   : Inicio
    Created on : 23/04/2018, 14:37:45
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
        <title>Acesso do Admin</title>
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
            <header>Tela do Administrador:</header>
            <div class="container" id="corpo">
                <div>
                    <form action="CrudAdmin" method="POST">
                        <h4>Formulário Aluno</h4>
                        <label>Matricula:</label>
                        <input type="text" name="matricula" value="201510240" required="required"/></br>
                        <label>Nome:</label>
                        <input type="text" name="nome" value="Isabella" required="required"/></br>
                        <label>CPF:</label>
                        <input type="text" name="cpf" value="1004587200" required="required"/></br>
                        <label>Curso:</label>
                        <input type="text" name="curso" value="TADS" required="required"/></br>
                        <label>Sexo:</label>
                        <input type="radio" name="genero" value="M" required="required"/> Masculino
                        <input type="radio" name="genero" value="F" required="required"/> Feminino</p>
                        <label>Senha:</label>
                        <input type="password" name="senha" value="senha" required="required"/></br>

                        </br>

                        <label>Estado:</label>
                        <input type="text" name="estado" value="estado" required="required"/></br>
                        <label>Cidade:</label>
                        <input type="text" name="cidade" value="cidade" required="required"/></br>
                        <label>Bairro:</label>
                        <input type="text" name="bairro" value="bairro" required="required"/></br>
                        <label>Rua:</label>
                        <input type="text" name="rua" value="rua" required="required"/></br>
                        <label>Numero:</label>
                        <input type="text" name="numero" value="455" required="required"/></br>
                        <label>Cep:</label>
                        <input type="text" name="cep" value="15445200" required="required"/></br>
                        </br>

                        <label>Telefone:</label>
                        <input type="text" name="telefone" value="158456121"/></br>
                        <input type="submit" name="submit" value="submit" />
                        </br></br>
                    </form>

                    <form action="CrudAdminProfessor" method="POST">
                        <h4>Formulário Professor</h4>
                        <label>Siape:</label>
                        <input type="text" name="siape" value="2091928" required="required"/></br>
                        <label>Nome:</label>
                        <input type="text" name="nome" value="Professor01" required="required"/></br>
                        <label>CPF:</label>
                        <input type="text" name="cpf" value="304.222.453-19" required="required"/></br>
                        <label>Sexo:</label>
                        <input type="radio" name="genero" value="M" required="required"/> Masculino
                        <input type="radio" name="genero" value="F" required="required"/> Feminino</p>
                        <label>Curso:</label>
                        <input type="text" name="curso" value="TADS" required="required"/></br>
                        <label>Senha:</label>
                        <input type="text" name="senha" value="senha" required="required"/></br>
                        </br>
                        <label>Estado:</label>
                        <input type="text" name="estado" value="estado" required="required"/></br>
                        <label>Cidade:</label>
                        <input type="text" name="cidade" value="cidade" required="required"/></br>
                        <label>Bairro:</label>
                        <input type="text" name="bairro" value="bairro" required="required"/></br>
                        <label>Rua:</label>
                        <input type="text" name="rua" value="rua" required="required"/></br>
                        <label>Numero:</label>
                        <input type="text" name="numero" value="455" required="required"/></br>
                        <label>Cep:</label>
                        <input type="text" name="cep" value="15445200" required="required"/></br>
                        </br>

                        <label>Telefone:</label>
                        <input type="text" name="telefone" value="158456121" required="required"/></br>
                        </br>
                        <input type="submit" name="submit" value="submit" />
                        </br></br>
                    </form>

                    <form action="CrudAdminDisciplina" method="POST">
                        <h4>Formulário Disciplina</h4>
                        <label>Nome Disciplina:</label>
                        <input type="text" name="nome" value="Disciplina01" required="required"/></br>
                        <label>Carga Horaria</label>
                        <input type="text" name="carga" value="45 horas" required="required"/></br>
                        <label>Horario</label>
                        <input type="text" name="hora" value="8h" required="required"/></br>
                        <label>Dia(s)</label>
                        <input type="text" name="dias" value="Segunda e Terça" required="required"/></br>
                        <label>Periodo</label>
                        <input type="number" name="periodo" value="3º" required="required"/></br>
                        <label>Requisito</label>
                        <select name="disciplina">
                            <option value="Nenhum">Nenhhum</option>
                            <c:forEach items="${listDisciplina}" var="disciplina" >
                                <option value="${disciplina.nome}">${disciplina.nome}</option>
                            </c:forEach>
                        </select></br>
                        <label>Professor</label>
                        <select name="professor">
                            <c:forEach items="${listProfessor}" var="professor" >
                                <option value="${professor.siape}" name="professor">${professor.nome}</option>
                            </c:forEach>
                        </select></br>
                        <input type="submit" name="submit" value="submit" />
                        </br></br>
                    </form>
                    <button><a href="index.jsp"/>Voltar</button>                    
                </div>
            </div>
        </div>
    </body>
</html>

