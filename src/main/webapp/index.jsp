<%-- 
    Document   : index
    Created on : 24/04/2018, 10:19:03
    Author     : Isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina inicial</title>

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
            font-family: Marker Felt, fantasy;
            text-align: center;
            padding: 1em;
            color: white;
            background-color: black;
            width: 800px;
            margin-top: 20px;
            font-size: 40px;
        }
        #corpo{
            background-color: #FAFAFA;
            width: 800px;
            padding: 1em;
            border-style: solid;
            border-color: black;
            border-width: 2px;
        }
        span{
            text-align: center;
        }
        #forms{
            display: inline-block;
            padding-right: 100px ;
            padding-left: 100px;
        }
        #tipo{
            background-color: black;
            color: white;
            padding: 5px;
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
            <header>Academic Wizard</header>
            <div class="container" id="corpo">
                <b><span>Escolha um dos modulos para fazer o login:</span></b>
                </br></br>
                <div class="container">
                    <span><c:out value="${erroLogin}"/></span><br>
                    <div id="forms">
                        <form action="loginAluno" method="POST">
                            <label id="tipo">Aluno</label></br>
                            <label>Matrícula: </label></br>
                            <input type="text" name="matricula"/></br></br>
                            <label>Senha: </label></br>
                            <input type="password" name="senha"/>
                            </br></br>
                            <button type="submit" name="submit" value="submit">Entrar</button>
                        </form>
                    </div>

                    <div id="forms">
                        <form action="loginProfessor" method="POST">
                            <label id="tipo">Professor</label></br>
                            <label>Siape: </label></br>
                            <input type="text" name="siape"/></br></br>
                            <label>Senha: </label></br>
                            <input type="password" name="senha"/>
                            </br></br>
                            <button type="submit" name="submit" value="submit">Entrar</button>
                        </form>
                    </div>
                </div>
            </div>
            <footer> 10/05/2018 Versão 1.000
                © 2018 AcademicWizard <a href="loginAdmin">Administrador</a></footer>
        </div>
    </body>
</html>
